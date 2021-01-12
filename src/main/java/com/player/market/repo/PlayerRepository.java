package com.player.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.player.market.model.Player;

import antlr.collections.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	//List<Player> findAllByids(List<Long> ids);

}
