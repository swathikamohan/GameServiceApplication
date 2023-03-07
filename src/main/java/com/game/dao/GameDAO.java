package com.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.game.entity.Game;

public interface GameDAO extends JpaRepository<Game, Integer>{

}
