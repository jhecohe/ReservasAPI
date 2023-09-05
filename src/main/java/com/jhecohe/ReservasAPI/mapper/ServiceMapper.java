package com.jhecohe.ReservasAPI.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.jhecohe.ReservasAPI.persistence.entity.Servicing;
import com.jhecohe.ReservasAPI.persistence.entity.Trading;
import com.jhecohe.ReservasAPI.service.TradingService;
import com.jhecohe.ReservasAPI.service.dto.ServicingDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ServiceMapper implements IMapper<Servicing, ServicingDTO> {
	
	TradingService tradingService;

	@Override
	public Servicing getEntity(ServicingDTO in) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");
		Trading t = tradingService.getTrading(in.getTradingId());
		return new Servicing(in.getName(),
				LocalDate.parse(in.getServiceDate(), formatterDate),
				LocalTime.parse(in.getOpen()),
				LocalTime.parse(in.getClose()),
				in.getDuration(), t);
	}

	@Override
	public ServicingDTO getDTO(Servicing in) {
		// TODO Auto-generated method stub
		ServicingDTO sDTO = new ServicingDTO();
		sDTO.setName(in.getName());
		sDTO.setServiceDate(in.getServiceDate().toString());
		sDTO.setOpen(in.getOpen().toString());
		sDTO.setClose(in.getClose().toString());
		sDTO.setDuration(in.getDuration());
		return sDTO;
	}

}
