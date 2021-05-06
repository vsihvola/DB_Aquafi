package com.example.aquafi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.aquafi.domain.Game;
import com.example.aquafi.domain.GameDAO;

@Controller
public class AquafiController {
	
	@Autowired
	private GameDAO gameDAO;
	
	@RequestMapping(value="/")
	public String showGames(Model model) {
		List<Game> games = gameDAO.fetchAllGames();
		model.addAttribute("games", games);
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}  
	

	@RequestMapping(value="/games")
	public String game(Model model) {
		model.addAttribute("game", new Game());
		List<Game> games = gameDAO.fetchAllGames();
		model.addAttribute("games", games);
		return "games";
	}  
	
    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    public String addGame(Game game) {
        gameDAO.addGame(game);
        return "redirect:/";
    }    
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteGame(@RequestParam String id) {
    	System.out.println(id);
    	gameDAO.deleteGame(Long.parseLong(id));
        return "redirect:/";
    }    

}
