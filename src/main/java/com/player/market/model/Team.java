package com.player.market.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Jayashree
 * 
 * This is Player entity class to represent the Team details
 *
 */


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEAM")
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_Sequence")
	@SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
	@JsonIgnore
	private Long id;

	@Column(name = "NAME")
	@NotEmpty(message = "name must not be empty")
	private String name;

	@Column(name = "CURRENCY")
	@NotEmpty(message = "currency must not be empty")
	@Size(min = 3,max = 3)
	private String currency;

	@Column(name = "COMMISSION")
	private double commission;


}
