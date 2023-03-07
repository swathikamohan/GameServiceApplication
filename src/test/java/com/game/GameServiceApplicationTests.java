package com.game;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.game.dao.GameDAO;
import com.game.entity.Game;

@SpringBootTest
class GameServiceApplicationTests {
	
	
	@Autowired
	private GameDAO gameDao;
	
	
	@Test
		void addgame() throws Exception {
			new Game(1,"car racing","video games", (float) 250.90);
			assertNotNull(gameDao.findById(1).get());

		}
		
		
		@Test
		 void getGame(){
			 Game game = gameDao.findById(1).get();
			 Assertions.assertThat(game.getGameId()).isEqualTo(1);
			 }
		
		
		@Test
		@Rollback(value = false)
		void updateGame(){
		Game game = gameDao.findById(1).get();
		 game.setGameName("car racing");
		Game gameUpdated =gameDao.save(game);
		Assertions.assertThat(gameUpdated.getGameName()).isEqualTo("car racing");
		}
		

}
