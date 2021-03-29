package com.example.aquafi.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GameRowMapper implements RowMapper<Game> {

	public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
		Game game = new Game();
		game.setId(rs.getLong("id"));
		game.setTeam1(rs.getString("team1"));
		game.setTeam2(rs.getString("team2"));
		game.setMap(rs.getString("map"));
		game.setResult(rs.getString("result"));
		
		return game;
	}
}
