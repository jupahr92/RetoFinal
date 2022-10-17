/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.jphr.demo.CRUDRepository;

import com.jphr.demo.Entidades.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JUAN
 */
public interface MessageCRUDRepository extends CrudRepository<Message, Integer> {
    
}
