package com.jhecohe.ReservasAPI.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI setupOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Reservas")
						.version("1.0")
						.description("Sistema de Reserva de Turnos")
						);
	}
}
