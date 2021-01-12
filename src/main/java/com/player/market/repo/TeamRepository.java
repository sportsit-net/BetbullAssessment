package com.player.market.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.player.market.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	@Query(value="select * FROM Team t LEFT JOIN PlayerTeamMapper pt WHERE t.id = pt.TEAM_ID and pt.player_Id in (:playerIds)", nativeQuery = true)
	List<Team> findAll(@Param("playerIds") List<Long> playerIds);

	@Query(value="select * FROM Team t LEFT JOIN PlayerTeamMapper pt WHERE t.id = pt.TEAM_ID and pt.player_Id in (:playerId)", nativeQuery = true)
	Team findByPlayerId(@Param("playerId") Long playerId);

}
