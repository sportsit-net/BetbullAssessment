package com.player.market.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.market.exception.InvildInputException;
import com.player.market.exception.RecordNotFoundException;
import com.player.market.model.Player;
import com.player.market.service.PlayerMarketService;

@RestController
@RequestMapping(name = "/player")
public class PlayerController {

	@Autowired
	PlayerMarketService playerMarketService;


	// list all the players 
	@GetMapping(path = "/player")
	public ResponseEntity<?> listPlayers() {
		try {
			List<Player> list = playerMarketService.getAllPlayers();
			if (list.size() == 0)
				throw new RecordNotFoundException("There are no players");
			return ResponseEntity.ok(playerMarketService.getAllPlayers());
		} catch (RecordNotFoundException e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	//create player after validating the input
	@PostMapping(path = "/player")
	public ResponseEntity<?> addPlayer(@Valid @RequestBody Player player) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdatePlayer(player));
		} catch (InvildInputException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	//update existing player
	@PutMapping(path = "/player/{playerId}")
	public ResponseEntity<?> updatePlayer(@PathVariable Long playerId, @RequestBody Player player) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdatePlayer(player));
		}
		catch (InvildInputException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	//delete existing player
	
	@DeleteMapping(path = "/player/{playerId}")
	public ResponseEntity<?> deletePlayer(@PathVariable Long playerId) {
		try {
			return ResponseEntity.ok(playerMarketService.deletePlayer(playerId));
		}catch (RecordNotFoundException e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
