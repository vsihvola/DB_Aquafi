package com.example.aquafi.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Game {
	
	@NotNull
	private long id;
	
	private String team1;
	private String team2;
	private String map;
	
	@Size(min=4, max=5)
	private String result;
	
	public Game () {

	}
	
	public Game(Long id, String team1, String team2, String map, String result) {
		super();
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
		this.map = map;
		this.result = result;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Game[id=%d, team1='%s', team2='%s', map='%s', result='%s']",
                id, team1, team2, map, result);
    }
}
