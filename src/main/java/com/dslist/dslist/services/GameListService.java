package com.dslist.dslist.services;

import com.dslist.dslist.dto.GameDTO;
import com.dslist.dslist.dto.GameListDTO;
import com.dslist.dslist.dto.GameMinDTO;
import com.dslist.dslist.entities.Game;
import com.dslist.dslist.entities.GameList;
import com.dslist.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRespository gameRespository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRespository.findAll();
        // return  result.stream().map(x -> new GameListDTO(x)).toList(); o de baix oé mais elegante
        return  result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRespository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max ; i++) {
            gameListRespository.updateBelongingPosition(listId,list.get(i).getId(), i);
        }
    }

}
