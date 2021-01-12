package com.player.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.player.market.model.PlayerTeamMapper;

@Repository
public interface PlayerTeamRepository extends JpaRepository<PlayerTeamMapper, Long> {

	public PlayerTeamMapper findByPlayerId(Long playerId);

}
