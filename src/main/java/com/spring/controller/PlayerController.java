package com.spring.controller;

import java.util.List;

import com.spring.model.Player;
import com.spring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayerController {

	private PlayerService playerService;

	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping("/data")
	// http://localhost:8080/api/data
	public String getData() {
		return "mydata";
	}

	// http://localhost:8080/api/players
	@GetMapping("/players")
	public List<Player> players() {
		return playerService.AllPlayers();
	}

	// http://localhost:8080/api/player?id=
	@GetMapping("/player")
	public Player player(@RequestParam int id) {
		Player player = playerService.getPlayer(id);
		if (player == null) {
			throw new RuntimeException("id : " + id + " not founded!");
		}
		return player;
	}

	// http://localhost:8080/api/player
	@PostMapping("/player")
	public String addPlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Added Successfuly";
	}

	// http://localhost:8080/api/player
	@PutMapping("/player")
	public String updatePlayer(@RequestBody Player player) {
		System.out.println(player.getPlayerID());
		if (playerService.getPlayer(player.getPlayerID()) == null) {
			throw new RuntimeException("id : " + player.getPlayerID() + " not founded!");
		}
		playerService.savePlayer(player);
		return "Updated Successfuly";
	}

	// http://localhost:8080/api/player?id=
	@DeleteMapping("/player")
	public String deletePlayer(@RequestParam int id) {
		playerService.deletePlayer(id);
		return "Deleted Successfuly";
	}

}
