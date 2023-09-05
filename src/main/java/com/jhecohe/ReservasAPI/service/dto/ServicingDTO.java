package com.jhecohe.ReservasAPI.service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class ServicingDTO {
	
	@NotNull
	private String name;
	@NotNull
	private String serviceDate;
	@NotNull
	private String open;
	@NotNull
	private String close;
	@NotNull
	private Long duration;
	@NotNull
	private Long tradingId;
}
