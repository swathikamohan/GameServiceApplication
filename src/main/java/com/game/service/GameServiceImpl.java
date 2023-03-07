package com.game.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.dao.GameDAO;
import com.game.entity.Game;
import com.game.exception.GameAlreadyExistsException;
import com.game.exception.ValueNotFoundException;

@Service
public class GameServiceImpl implements GameService{
	@Autowired
	private GameDAO gameDao;
	
	@Override
	public List<Game> getAllGames() {
		return gameDao.findAll();
	}

	@Override
	public void getGameById(Integer gameId) throws ValueNotFoundException {
		if(gameDao.findById(gameId).isEmpty()) {
			throw new ValueNotFoundException();
			}
		else {
		    @SuppressWarnings("unused")
			Optional<Game> game = Optional.empty();
			}
	}

	@Override
	public Game addGame(Game game1) throws GameAlreadyExistsException {
		if(gameDao.findById(game1.getGameId()).isEmpty())	{
			gameDao.save(game1);
		return game1;
	}
	else {
		throw new GameAlreadyExistsException();
	}
}

	@Override
	public Game updateGame(Game game1) throws GameAlreadyExistsException {
		gameDao.save(game1);
		return game1;

	}

	@Override
	public void deleteGameById(Integer gameId) throws ValueNotFoundException {
		@SuppressWarnings("deprecation")
		Game g=gameDao.getById(gameId);
		gameDao.delete(g);
		
	}

}