package com.jhecohe.ReservasAPI.persistence.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Trading {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRADING_SEQ")
	@SequenceGenerator(sequenceName = "trading_seq", allocationSize = 1, name = "TRADING_SEQ")
	private Long id;
	private String name;
	private int maxCapacity;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trading")
	private List<Servicing> servicingList;

	public Trading(String name, int maxCapacity) {
		this.name = name;
		this.maxCapacity = maxCapacity;
	}

}
