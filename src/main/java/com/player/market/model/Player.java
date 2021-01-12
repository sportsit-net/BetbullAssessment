package com.player.market.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 
 * @author Jayashree
 * 
 * This is Player entity class to represent the player details
 *
 */

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAYER")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_Sequence")
	@SequenceGenerator(name = "player_Sequence", sequenceName = "PLAYER_SEQ")
	@JsonIgnore
	private Long id;

	@Column(name = "NAME")
	@NotEmpty(message = "name must not be empty")
	private String name;

	@Column(name = "DOB")
	private LocalDate dob;

	@Column(name = "START_DATE")
	private LocalDate startDate;

	//player transfer fee , age is taken in years and and experience in months
	public double getTransferFee() {
		return (getPlayerExperience() * 100000) / getPlayerAge();
	}

	private long getPlayerExperience() {
		return ChronoUnit.MONTHS.between(YearMonth.from(this.startDate), YearMonth.from(LocalDate.now()));
	}

	private long getPlayerAge() {
		return ChronoUnit.YEARS.between(YearMonth.from(this.dob), YearMonth.from(LocalDate.now()));
	}
	
}
