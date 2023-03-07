package com.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.entity.Game;
import com.game.exception.GameAlreadyExistsException;
import com.game.exception.ValueNotFoundException;
import com.game.service.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameservice;

	@GetMapping("/game")
	public List<Game> getAllGames(){
		return this.gameservice.getAllGames();
	}
	
	@GetMapping("/game/{gameId}")
	public ResponseEntity<Game> getId(@PathVariable("gameId") Integer gameId) {
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@PostMapping("/game")
	public Game addGame(@RequestBody Game game1) throws GameAlreadyExistsException {
		return this.gameservice.addGame(game1);
	}

	@PutMapping("/game")
	public Game updateGame(@RequestBody Game game1) throws GameAlreadyExistsException {
		return this.gameservice.updateGame(game1);
	}
	
	@DeleteMapping("/game/{gameId}")
	public void deleteGame(@PathVariable("gameId") Integer gameId) throws ValueNotFoundException {
		this.gameservice.deleteGameById(gameId);

	}
}