package com.jhecohe.ReservasAPI.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhecohe.ReservasAPI.persistence.entity.Trading;

public interface TradingRepository extends JpaRepository<Trading, Long>{

}
