package com.jhecohe.ReservasAPI.persistence.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Servicing {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERVICE_SEQ")
	@SequenceGenerator(sequenceName = "service_seq", allocationSize = 1, name = "SERVICE_SEQ")
	private Long id;
	private String name;
	private LocalDate serviceDate;
	private LocalTime open;
	private LocalTime close;
	private Long duration;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trading_id")
	@NotNull
	private Trading trading;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
	private List<Turn> turnList;

	public Servicing(String name, LocalDate serviceDate, LocalTime open, LocalTime close, Long duration, Trading trading) {
		this.name = name;
		this.serviceDate = serviceDate;
		this.open = open;
		this.close = close;
		this.duration = duration;
		this.trading = trading;
	}

}
