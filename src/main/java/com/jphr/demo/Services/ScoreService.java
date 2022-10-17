/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jphr.demo.Services;

import com.jphr.demo.Entidades.Score;
import com.jphr.demo.Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JUAN
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int scoreId) {
        return scoreRepository.getScore(scoreId);
    }

    public Score save(Score score) {
        if (score.getStars() >= 0 && score.getStars() <= 5) {
            if (score.getIdScore() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> sR = scoreRepository.getScore(score.getIdScore());
                if (sR.isEmpty()) {
                    return scoreRepository.save(score);
                }
            }

        }
        return score;
    }

    public Score update (Score score){
        if (score.getIdScore() != null) {
            Optional<Score> sR = scoreRepository.getScore(score.getIdScore());
            if (!sR.isEmpty()) {
                if (score.getMessageText() != null) {
                    sR.get().setMessageText(score.getMessageText());
                }
                if (score.getStars() != null && score.getStars() >= 0 && score.getStars() <= 5) {
                    sR.get().setStars(score.getStars());
                }
                scoreRepository.save(sR.get());
                return sR.get();
            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean deleteScore ( int scoreId){
        Boolean aB = getScore(scoreId).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aB;
    }
}
