/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Services;

import com.jphr.demo.Entidades.Admin;
import com.jphr.demo.Repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JUAN
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin setInsert(Admin admin){
        return adminRepository.setInsert(admin);
    }

    public Admin setUpdate(Admin admin){
        return adminRepository.setUpdate(admin);
    }

    public void setDelete(Integer id){
        adminRepository.setDelete(id);
    }

    public Admin getOne(Integer id){
        return adminRepository.getOne(id);
    }

    public List<Admin> getAll(){
        return adminRepository.getall();
    }

}
