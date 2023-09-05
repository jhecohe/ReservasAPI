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
public class TurnProcedureDTO {
	@NotNull
	private String fechaInicio;
	@NotNull
	private String fechaFin;
	@NotNull
	private Long servicingId;
}