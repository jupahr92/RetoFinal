/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.jphr.demo.CRUDRepository;

import com.jphr.demo.Entidades.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JUAN
 */
public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {
    
    @Query("SELECT d.doctor, COUNT(d.doctor) from Reservation AS d group by d.doctor order by COUNT(d.doctor) DESC")
    public List<Object[]> countTotalReservationsByDoctor();

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );

    public List<Reservation>findAllByStatus(String status);
    
    @Query(value="Select count(idreservation) from reservations where status =?", nativeQuery=true)
    public Integer countbystatus(String status);
    
}
