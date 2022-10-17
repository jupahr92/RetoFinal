/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Services;

import com.jphr.demo.Entidades.Specialty;
import com.jphr.demo.Repository.SpecialtyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JUAN
 */
@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll() {

        return specialtyRepository.getAll();
    }

    public Optional<Specialty> getSpecialty(int specialtyId) {

        return specialtyRepository.getSpecialty(specialtyId);
    }

    public Specialty save(Specialty specialty) {
        if (specialty.getId() == null) {
            return specialtyRepository.save(specialty);
        } else {
            Optional<Specialty> special = specialtyRepository.getSpecialty(specialty.getId());
            if (special.isEmpty()) {
                return specialtyRepository.save(specialty);
            } else {
                return specialty;
            }
        }
    }

    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty>s=specialtyRepository.getSpecialty(specialty.getId());
            if(!s.isEmpty()){
                if(specialty.getDescription()!=null){
                    s.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName()!=null){
                    s.get().setName(specialty.getName());
                }
                return specialtyRepository.save(s.get());
            }
        }
        return specialty;
    }
    public boolean deleteSpecialty(int specialtyId){
        Boolean aB=getSpecialty(specialtyId).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return aB;
    }
}
