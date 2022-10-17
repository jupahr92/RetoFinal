/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.SpecialtyCRUDRepository;
import com.jphr.demo.Entidades.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JUAN
 */
@Repository
public class SpecialtyRepository {
    @Autowired
    private SpecialtyCRUDRepository specialtyCRUDRepository;
    public List<Specialty> getAll(){

        return (List<Specialty>) specialtyCRUDRepository.findAll();
    }
    public Optional<Specialty> getSpecialty(int id){

        return specialtyCRUDRepository.findById(id);
    }

    public Specialty save(Specialty specialty){

        return specialtyCRUDRepository.save(specialty);
    }

    public void delete(Specialty specialty){

        specialtyCRUDRepository.delete(specialty);
    }
}
