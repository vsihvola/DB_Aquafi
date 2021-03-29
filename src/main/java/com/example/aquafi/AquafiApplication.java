package com.example.aquafi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.aquafi.domain.Game;
import com.example.aquafi.domain.GameDAOImpl;

@SpringBootApplication
public class AquafiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AquafiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AquafiApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(GameDAOImpl gameDAO) {
		return (args) -> {
			for (Game game : gameDAO.fetchAllGames()) {
				log.info(game.toString());
			}
	       
		};
	}	

}
