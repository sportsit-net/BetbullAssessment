package com.player.market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Jayashree
 * 
 * This is Player entity class to represent the player team mapping details
 *
 */


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAYERTEAMMAPPER",uniqueConstraints = { @UniqueConstraint(columnNames = { "PLAYER_ID", "TEAM_ID" }) })
public class PlayerTeamMapper {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playerteam_Sequence")
	@SequenceGenerator(name = "playerteam_Sequence", sequenceName = "PLAYER_TEAM_SEQ")
	@JsonIgnore
	private Long id;

	@Column(name = "PLAYER_ID")
	@Min(1)
	private Long playerId;
	@Min(1)
	@Column(name = "TEAM_ID")
	private Long teamId;

}
