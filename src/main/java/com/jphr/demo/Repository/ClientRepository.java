/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.ClientCRUDRepository;
import com.jphr.demo.Entidades.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JUAN
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;
    public List<Client> getAll(){

        return (List<Client>) clientCRUDRepository.findAll();
    }
    public Optional<Client> getClient(int id){

        return clientCRUDRepository.findById(id);
    }

    public Client save(Client client){

        return clientCRUDRepository.save(client);
    }

    public void delete(Client client){

        clientCRUDRepository.delete(client);
    }
}
