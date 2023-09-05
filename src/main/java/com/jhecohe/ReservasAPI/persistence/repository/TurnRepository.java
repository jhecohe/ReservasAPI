package com.jhecohe.ReservasAPI.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.jhecohe.ReservasAPI.persistence.entity.Turn;

public interface TurnRepository extends JpaRepository<Turn, Long>{

	List<Turn> findAllByServiceId(Long tradingId);
	
	@Procedure(value = "TURN_CREATION")
	void createTurnsWithParameters(LocalDate fechaInicio, LocalDate fechaFin, Long servicingId);
}
