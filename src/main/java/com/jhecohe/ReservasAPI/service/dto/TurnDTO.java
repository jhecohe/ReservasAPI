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
public class TurnDTO {
	private long id;
	@NotNull
	private String turnDate;
	@NotNull
	private String startDate;
	@NotNull
	private String endDate;
	@NotNull
	private String turnStatus;
	private Long servicingId;
}
