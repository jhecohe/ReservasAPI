package com.jhecohe.ReservasAPI.mapper;

public interface IMapper <Entity, DTO>{
	public Entity getEntity(DTO in);
	public DTO getDTO(Entity in);
}
