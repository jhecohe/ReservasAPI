package com.jhecohe.ReservasAPI.persistence.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Turn {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TURN_SEQ")
	@SequenceGenerator(sequenceName = "turn_seq", allocationSize = 1, name = "TURN_SEQ")
	private long id;
	private LocalDate turnDate;
	private LocalTime startDate;
	private LocalTime endDate;
	@Enumerated(EnumType.STRING)
	private TurnStatus turnStatus;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	private Servicing service;

	public Turn(LocalDate turnDate, LocalTime startDate, LocalTime endDate, TurnStatus turnStatus, Servicing service) {
		this.turnDate = turnDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.turnStatus = turnStatus;
		this.service = service;
	}

}
