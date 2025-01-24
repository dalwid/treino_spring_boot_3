package com.dslist.dslist.services;

import com.dslist.dslist.dto.GameDTO;
import com.dslist.dslist.dto.GameListDTO;
import com.dslist.dslist.dto.GameMinDTO;
import com.dslist.dslist.entities.Game;
import com.dslist.dslist.entities.GameList;
import com.dslist.dslist.repositories.GameListRespository;
import com.dslist.dslist.repositories.GameRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRespository gameListRespository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRespository.findAll();
        // return  result.stream().map(x -> new GameListDTO(x)).toList(); o de baix oé mais elegante
        return  result.stream().map(GameListDTO::new).toList();
    }

}
