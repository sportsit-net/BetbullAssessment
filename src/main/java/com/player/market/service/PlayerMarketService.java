package com.player.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.player.market.dto.ContractFee;
import com.player.market.exception.InvildInputException;
import com.player.market.exception.RecordNotFoundException;
import com.player.market.model.Player;
import com.player.market.model.PlayerTeamMapper;
import com.player.market.model.Team;
import com.player.market.repo.PlayerRepository;
import com.player.market.repo.PlayerTeamRepository;
import com.player.market.repo.TeamRepository;

@Component
public class PlayerMarketService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	PlayerTeamRepository playerTeamRepository;

	public ArrayList<Player> getAllPlayers() {
		return (ArrayList<Player>) playerRepository.findAll();
	}

	public List<Player> findPlayerByIds(List<Long> ids) {
		return playerRepository.findAllById(ids);
	}

	public Optional<Player> findById(Long id) {
		return playerRepository.findById(id);
	}

	public Player createUpdatePlayer(Player p) {

		if (p.getDob().isAfter(p.getStartDate()))
			throw new InvildInputException("Player DOB is invalid");

		if (p.getDob().getYear() == (p.getStartDate().getYear()))
			throw new InvildInputException("Player Start date is Invalid");

		return playerRepository.save(p);
	}

	public String deletePlayer(Long id) {
		try {
			Player p = playerRepository.getOne(id);
			if (p==null)
				throw new RecordNotFoundException(id + "Player Not Found" );
			playerRepository.deleteById(id);
		} catch (Exception e) {
			throw new RecordNotFoundException(id + "Player Not Found" );
		}
		return "Player Deleted Successfully ";
	}

	public List<Team> getAllTeam() {
		List<Team> list =teamRepository.findAll();
		if (list.size()==0)
			throw new RecordNotFoundException("No Teams Yet");
		return list;
	}

	public Team createUpdateTeam(Team t) {
		return teamRepository.save(t);
	}

	public String deleteTeam(Long id) {

		try {
			Team t = teamRepository.getOne(id);
			if (t == null)
				throw new RecordNotFoundException(id + "Team Not Found");
			playerRepository.deleteById(id);
		} catch (Exception e) {
			throw new RecordNotFoundException(id + "Team Not Found");
		}

		teamRepository.deleteById(id);

		return "Team Deleted Successfully ";
	}

	public List<PlayerTeamMapper> getAllPlayerTeamMappings() {
		return playerTeamRepository.findAll();
	}

	public PlayerTeamMapper createUpdatePlayerTeam(PlayerTeamMapper t) {
		return playerTeamRepository.save(t);
	}

	public String deletePlayerTeamMapping(Long id) {
		teamRepository.deleteById(id);
		return "Player/Team Mapping Deleted Successfully ";
	}

	public List<Team> getTeamsByPlayerId(List<Long> playerIds) {
		return teamRepository.findAll(playerIds);
	}

	public Team getTeamByPlayerId(Long playerId) {
		return teamRepository.findByPlayerId(playerId);
	}
	
	//contract fee calculation 
	public ContractFee playerContractFee(Long playerId) {
		Player player = playerRepository.findById(playerId).get();
		double transferFee = player.getTransferFee();
		PlayerTeamMapper pt = playerTeamRepository.findByPlayerId(playerId);
		Team team = teamRepository.findById(pt.getTeamId()).get();
		return new ContractFee(transferFee + (transferFee * team.getCommission()), team.getCurrency());
	}
}
