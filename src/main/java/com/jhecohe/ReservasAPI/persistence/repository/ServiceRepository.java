package com.jhecohe.ReservasAPI.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhecohe.ReservasAPI.persistence.entity.Servicing;

public interface ServiceRepository extends JpaRepository<Servicing, Long>{

	List<Servicing> findAllByTradingId(Long tradingId);
}
