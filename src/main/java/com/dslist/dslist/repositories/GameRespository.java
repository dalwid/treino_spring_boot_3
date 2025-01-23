package com.dslist.dslist.repositories;

import com.dslist.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRespository extends JpaRepository<Game, Long> {
}
