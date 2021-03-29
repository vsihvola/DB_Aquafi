package com.example.aquafi.domain;

import java.util.List;

public interface GameDAO {
	
	public List<Game> fetchAllGames();
	
	public void addGame (Game game);

	public void deleteGame (Long gameID);
}
