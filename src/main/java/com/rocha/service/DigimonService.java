package com.rocha.service;

import java.util.List;

import com.rocha.dto.digimon.DigimonRegisterDto;




public interface DigimonService {
	
	public abstract DigimonRegisterDto createDigimon(DigimonRegisterDto DigimonRegisterDto);
	public abstract List<DigimonRegisterDto> getAllDigimon();
	public abstract DigimonRegisterDto getDigimonByName(String name);
	public abstract Boolean existsDigimonByName(String name);
	public abstract void deleteDigimonByName(String name);
	public abstract DigimonRegisterDto editDigimonByName(String name, DigimonRegisterDto dto);

}
