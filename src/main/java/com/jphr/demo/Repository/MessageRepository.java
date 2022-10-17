/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.MessageCRUDRepository;
import com.jphr.demo.Entidades.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JUAN
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;

    public List<Message> getAll(){

        return (List<Message>) messageCRUDRepository.findAll();
    }
    public Optional<Message> getMessage(int id){

        return messageCRUDRepository.findById(id);
    }

    public Message save(Message message){

        return messageCRUDRepository.save(message);
    }

    public void delete(Message message){

        messageCRUDRepository.delete(message);
    }
}
