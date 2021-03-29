package com.example.aquafi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.aquafi.controller.AquafiController;
import com.example.aquafi.domain.Game;
import com.example.aquafi.domain.GameDAO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AquafiApplicationTests {
	
	@Autowired
	private GameDAO gameDao;
	
	@Autowired 
	private AquafiController controller;

	@Test
	public void controllerLoads() throws Exception {
		assertNotNull(controller);
	}
	
	@Test
	public void fetchDataFromDB() {
		
		//Straight connect to database
		List<Game> games = gameDao.fetchAllGames();
		assertNotNull(games);
		assertTrue(games.size() >= 1);
		
		//Test test helper
		List<Game> testHelperGames = DataForTest();
		assertNotNull(testHelperGames);
		assertTrue(games.size() >= 1);
	}
	
	@Test
	public void createNewGame() {
		
		//Create game
		Game testGame = new Game();
		
		//setAttributes
		testGame.setTeam1("Team Aquafi");
		testGame.setTeam2("Test Team");
		testGame.setMap("de_dust2");
		testGame.setResult("16-14");
		
		//Add Game
		gameDao.addGame(testGame);
		
		//Fetch games
		List<Game> testHelperGames = DataForTest();
		assertEquals(testHelperGames.get(testHelperGames.size()-1), testGame);
		
	}
	
	@Test
	public void deleteGame() {
		
		//Fetch data
		List<Game> testHelperGames = DataForTest();
		
		//Get last game from list and for helper to assert
		Game theLastGame = testHelperGames.get(testHelperGames.size() - 1);
		
		//Get id from lists last game
		Long gameIDtoDelete = theLastGame.getId();
		
		//Delete the game
		gameDao.deleteGame(gameIDtoDelete);
		
		//Fetch data again and check that game doesn't exists
		List<Game> updatedData = DataForTest();
		for(int i = 0; i < updatedData.size(); i++) {
			assertNotEquals(updatedData.get(i), theLastGame);
		}
		
	}
	
	public List<Game> DataForTest() {
		
		//Fetch data from database
		List<Game> games = gameDao.fetchAllGames();
		return games;
	}

}
