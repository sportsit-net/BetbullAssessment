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

import com.player.market.model.PlayerTeamMapper;
import com.player.market.service.PlayerMarketService;

@RestController
public class PlayerMarketController {

	@Autowired
	PlayerMarketService playerMarketService;

	@GetMapping(path = "/playerteam")
	public ResponseEntity<?> listPlayerTeamMapping() {
		try {
			return ResponseEntity.ok(playerMarketService.getAllPlayerTeamMappings());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(path = "/playerteam")
	public ResponseEntity<?> mapPlayerTeam(@Valid @RequestBody PlayerTeamMapper tp) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdatePlayerTeam(tp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping(path = "/playerteam/{playerTeamMapId}")
	public ResponseEntity<?> updateTeam(@PathVariable Long Id, @RequestBody PlayerTeamMapper tp) {
		try {
			return ResponseEntity.ok(playerMarketService.createUpdatePlayerTeam(tp));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(path = "/playerteam/{playerTeamMapId}")
	public ResponseEntity<?> deletePlayerTeam(@PathVariable Long playerTeamMapId) {
		try {
			return ResponseEntity.ok(playerMarketService.deletePlayerTeamMapping(playerTeamMapId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}


	@GetMapping(path = "/playerteam/{playerId}/team")
	public ResponseEntity<?> listTeamsByPlayerId(@PathVariable Long playerId) {
		try {
			return ResponseEntity.ok(playerMarketService.getTeamByPlayerId(playerId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(path = "/team/contractfee/{playerId}")
	public ResponseEntity<?> getContractFee(@PathVariable Long playerId) {
		try {
			return ResponseEntity.ok(playerMarketService.playerContractFee(playerId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
