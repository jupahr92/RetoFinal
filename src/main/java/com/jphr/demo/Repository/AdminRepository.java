/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.AdminCRUDRepository;
import com.jphr.demo.Entidades.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JUAN
 */

@Repository
public class AdminRepository {
    @Autowired
    private AdminCRUDRepository adminCRUDRepository;

    public Admin setInsert(Admin admin){

        Optional<Admin> obj = adminCRUDRepository.findById(admin.getIdAdmin());
        if (obj.isEmpty() == true){
            return adminCRUDRepository.save(admin);
        }
        else
            return null;
    }

    public Admin setUpdate(Admin admin){
        Boolean paraGrabar = true;
        Optional<Admin> obj = adminCRUDRepository.findById(admin.getIdAdmin());
        Admin objCambio;
        if (obj.isEmpty() == false){
            objCambio = obj.get();

            if (admin.getName() != null)
                objCambio.setName(admin.getName());

            if (admin.getEmail()!= null)
                objCambio.setEmail(admin.getEmail());

            if (admin.getPassword() != null)
                objCambio.setPassword(admin.getPassword());

            return adminCRUDRepository.save(admin);
        }
        else
            return null;
    }

    public void setDelete(Integer id){
        Optional<Admin> obj = adminCRUDRepository.findById(id);
        if (obj.isEmpty() == false)
            adminCRUDRepository.deleteById(id);

    }

    public List<Admin> getall(){
        return (List<Admin>) adminCRUDRepository.findAll();
    }

    public Admin getOne(Integer id){
        Optional<Admin> obj = adminCRUDRepository.findById(id);
        Admin devolver;
        if (obj.isEmpty() == false)
            devolver = obj.get();
        else
            devolver = null;
        return  devolver;
    }
}
