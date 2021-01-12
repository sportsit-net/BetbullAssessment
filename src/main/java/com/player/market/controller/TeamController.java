package com.player.market.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.player.market.exception.RecordNotFoundException;
import com.player.market.model.Team;
import com.player.market.service.PlayerMarketService;

@RestController
public class TeamController {

	@Autowired
	PlayerMarketService playerMarketService;

	//list all the teams
	@GetMapping(path = "/team")
	public ResponseEntity<?> listTeams() {
		try {
			return ResponseEntity.ok(playerMarketService.getAllTeam());
		} catch (RecordNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
//create team
	@PostMapping(path = "/team")
	public ResponseEntity<?> addTeam(@Valid @RequestBody Team team) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdateTeam(team));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
//update team based on team id
	@PutMapping(path = "/team/{teamId}")
	public ResponseEntity<?> updateTeam(@PathVariable Long teamId, @Valid @RequestBody Team team) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdateTeam(team));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
//delete team
	@DeleteMapping(path = "/team/{teamId}")
	public ResponseEntity<?> deleteTeam(@PathVariable Long teamId) {
		try {
			return ResponseEntity.ok(playerMarketService.deleteTeam(teamId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
