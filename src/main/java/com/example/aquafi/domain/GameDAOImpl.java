package com.example.aquafi.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GameDAOImpl implements GameDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//TBD More complex datatables
	
	public List<Game> fetchAllGames() {

		String dataToGet = "SELECT * FROM Game";
		RowMapper<Game> mapper = new GameRowMapper();
		List<Game> games = jdbcTemplate.query(dataToGet, mapper);

		return games;
	}
	
	public void addGame(Game game) {
		String dataToAdd = "INSERT INTO Game (team1, team2, map, result) VALUES (?, ?, ?, ?)";
		Object[] data = new Object[] { game.getTeam1(), game.getTeam2(), game.getMap(), game.getResult()};
		jdbcTemplate.update(dataToAdd, data);
		
	}
	
	public void deleteGame(Long gameID) {
		String dataToDelete= "DELETE FROM Game WHERE id = ?";
		Object[] data = new Object[] { gameID };
		jdbcTemplate.update(dataToDelete, data);
	}

}
