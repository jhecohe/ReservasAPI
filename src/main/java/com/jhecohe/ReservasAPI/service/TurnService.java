package com.jhecohe.ReservasAPI.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jhecohe.ReservasAPI.exceptions.ServiceException;
import com.jhecohe.ReservasAPI.mapper.TurnMapper;
import com.jhecohe.ReservasAPI.persistence.entity.Turn;
import com.jhecohe.ReservasAPI.persistence.entity.TurnStatus;
import com.jhecohe.ReservasAPI.persistence.repository.TurnRepository;
import com.jhecohe.ReservasAPI.service.dto.TurnDTO;
import com.jhecohe.ReservasAPI.service.dto.TurnProcedureDTO;
import com.jhecohe.ReservasAPI.service.dto.TurnUpdateDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TurnService {
	
	private final TurnRepository turnRepository;
	private final TurnMapper turnMapper;
	
	public void createTurns(TurnProcedureDTO procedureDTO) {

		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");
		turnRepository.createTurnsWithParameters(
				LocalDate.parse(procedureDTO.getFechaInicio(), formatterDate),
				LocalDate.parse(procedureDTO.getFechaFin(), formatterDate),
				procedureDTO.getServicingId());
	}

	public List<TurnDTO> getTurnsByServicingId(Long servicingId) {
		
		List<Turn> turnList = turnRepository.findAllByServiceId(servicingId);
		List<TurnDTO> dtoList = turnList.stream().map(turn -> turnMapper.getDTO(turn))
		.collect(Collectors.toList());
		return dtoList;
	}

	public TurnDTO updateStateTurn(Long turnId, TurnUpdateDTO updateDTO) {

		Optional<Turn> turn = turnRepository.findById(turnId);
		if(turn.isEmpty())
		{
			throw new ServiceException("Turn ID not found", HttpStatus.NOT_FOUND);
		}
		Turn update = turn.get();
		update.setTurnStatus(TurnStatus.valueOf(updateDTO.getTurnStatus()));
		Turn updated = turnRepository.save(update);
		return turnMapper.getDTO(updated);
	}
}
