package com.example.aquafi.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public @ResponseBody List<Game> gamesListRest() {
		return (List<Game>)gameDAO.fetchAllGames();
	}

	@RequestMapping(value="/games")
	public String game(Model model) {
		model.addAttribute("game", new Game());
		List<Game> games = gameDAO.fetchAllGames();
		model.addAttribute("games", games);
		return "games";
	}  
	
    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String addGame(@Valid Game game) {
        gameDAO.addGame(game);
        return "redirect:/";
    }    
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteGame(@RequestParam String id) {
    	System.out.println(id);
    	gameDAO.deleteGame(Long.parseLong(id));
        return "redirect:/";
    }    

}
