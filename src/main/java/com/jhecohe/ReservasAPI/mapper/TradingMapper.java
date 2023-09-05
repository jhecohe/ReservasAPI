package com.jhecohe.ReservasAPI.mapper;

import org.springframework.stereotype.Component;

import com.jhecohe.ReservasAPI.persistence.entity.Trading;
import com.jhecohe.ReservasAPI.service.dto.TradingDTO;

@Component
public class TradingMapper implements IMapper<Trading, TradingDTO> {

	@Override
	public Trading getEntity(TradingDTO in) {
		// TODO Auto-generated method stub
		return new Trading(in.getName(), in.getMaxCapacity());
	}

	@Override
	public TradingDTO getDTO(Trading in) {
		// TODO Auto-generated method stub
		return new TradingDTO(in.getId(), in.getName(), in.getMaxCapacity());
	}

}
