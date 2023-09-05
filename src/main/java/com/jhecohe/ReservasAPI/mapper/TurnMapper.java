package com.jhecohe.ReservasAPI.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.jhecohe.ReservasAPI.persistence.entity.Servicing;
import com.jhecohe.ReservasAPI.persistence.entity.Turn;
import com.jhecohe.ReservasAPI.persistence.entity.TurnStatus;
import com.jhecohe.ReservasAPI.service.ServicingService;
import com.jhecohe.ReservasAPI.service.dto.TurnDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TurnMapper implements IMapper<Turn, TurnDTO> {
	
	ServicingService servicingService;

	@Override
	public Turn getEntity(TurnDTO in) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");
		Servicing s = servicingService.getServicing(in.getServicingId());
		return new Turn(
				LocalDate.parse(in.getTurnDate(), formatterDate),
				LocalTime.parse(in.getStartDate()),
				LocalTime.parse(in.getStartDate()),
				TurnStatus.valueOf(in.getTurnStatus()),
				s);
	}

	@Override
	public TurnDTO getDTO(Turn in) {
		// TODO Auto-generated method stub
		TurnDTO tDTO = new TurnDTO();
		tDTO.setTurnDate(in.getTurnDate().toString());
		tDTO.setStartDate(in.getStartDate().toString());
		tDTO.setEndDate(in.getEndDate().toString());
		tDTO.setTurnStatus(in.getTurnStatus().name());
		tDTO.setId(in.getId());
		return tDTO;
	}

}
