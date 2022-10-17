/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.ReservationCRUDRepository;
import com.jphr.demo.DTOs.DtoReportStatus;
import com.jphr.demo.Entidades.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JUAN
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCRUDRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCRUDRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation){

        return reservationCRUDRepository.save(reservation);
    }

    public void delete(Reservation reservation){

        reservationCRUDRepository.delete(reservation);
    }
    
    public DtoReportStatus getReportStatus(){
        DtoReportStatus dtoReportStatus = new DtoReportStatus();
        dtoReportStatus.setCancelled(reservationCRUDRepository.countbystatus("cancelled"));
        dtoReportStatus.setCompleted(reservationCRUDRepository.countbystatus("completed"));
        return dtoReportStatus;
    }
}
