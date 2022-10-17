/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Repository;

import com.jphr.demo.CRUDRepository.ScoreCRUDRepository;
import com.jphr.demo.Entidades.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author JUAN
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCRUDRepository scoreCRUDRepository;

    public List<Score> getAll(){

        return (List<Score>) scoreCRUDRepository.findAll();
    }
    public Optional<Score> getScore(int id){

        return scoreCRUDRepository.findById(id);
    }

    public Score save(Score score){

        return scoreCRUDRepository.save(score);

    }
    public void delete(Score score){

        scoreCRUDRepository.delete(score);
    }
}
