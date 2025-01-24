package com.dslist.dslist.services;

import com.dslist.dslist.dto.GameDTO;
import com.dslist.dslist.dto.GameMinDTO;
import com.dslist.dslist.entities.Game;
import com.dslist.dslist.projections.GameMinProjection;
import com.dslist.dslist.repositories.GameRespository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRespository gameRespository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRespository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRespository.findAll();
        return  result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRespository.searchByList(listId);
        return  result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
