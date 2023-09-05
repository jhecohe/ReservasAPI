package com.jhecohe.ReservasAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jhecohe.ReservasAPI.exceptions.ServiceException;
import com.jhecohe.ReservasAPI.mapper.ServiceMapper;
import com.jhecohe.ReservasAPI.persistence.entity.Servicing;
import com.jhecohe.ReservasAPI.persistence.repository.ServiceRepository;
import com.jhecohe.ReservasAPI.service.dto.ServicingDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicingService {
	
	private final ServiceRepository serviceRepository;
	private final ServiceMapper serviceMapper;
	
	public ServicingDTO createServicing(ServicingDTO serviceDTO) {
		
		Servicing service = serviceRepository.save(serviceMapper.getEntity(serviceDTO));
		return serviceMapper.getDTO(service);
	}

	public List<ServicingDTO> getServicingByTradingId(Long tradingId) {
		
		List<Servicing> servicingList = serviceRepository.findAllByTradingId(tradingId);
		List<ServicingDTO> dtoList = servicingList.stream().map(service -> serviceMapper.getDTO(service))
		.collect(Collectors.toList());
		return dtoList;
	}
	
	public Servicing getServicing(Long servicingId) {
		Optional<Servicing> servicing = serviceRepository.findById(servicingId);
		if(servicing.isEmpty())
		{
			throw new ServiceException("Service ID not found", HttpStatus.NOT_FOUND);
		}
		return servicing.get();
	}
}
