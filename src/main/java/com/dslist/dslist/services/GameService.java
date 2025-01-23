package com.dslist.dslist.services;

import com.dslist.dslist.dto.GameMinDTO;
import com.dslist.dslist.entities.Game;
import com.dslist.dslist.repositories.GameRespository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRespository gameRespository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRespository.findAll();
        return  result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
