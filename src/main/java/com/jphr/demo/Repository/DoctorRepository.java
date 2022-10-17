/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.DoctorCRUDRepository;
import com.jphr.demo.Entidades.Doctor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JUAN
 */
@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCRUDRepository doctorCRUDRepository;

    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCRUDRepository.findAll();
    }
    public Optional<Doctor> getDoctor(int id){
        return doctorCRUDRepository.findById(id);
    }

    public Doctor save(Doctor doctor){
        return doctorCRUDRepository.save(doctor);
    }

    public void delete(Doctor doctor){
        doctorCRUDRepository.delete(doctor);
    }
}
