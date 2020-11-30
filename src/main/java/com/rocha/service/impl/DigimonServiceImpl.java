package com.rocha.service.impl;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.dto.digimon.DigimonRegisterDto;
import com.rocha.entity.Digimon;
import com.rocha.repository.DigimonRepository;
import com.rocha.service.DigimonService;

@Service
public class DigimonServiceImpl implements DigimonService{
	
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DigimonRepository DigimonRepository;

    @Override
    public DigimonRegisterDto createDigimon(DigimonRegisterDto digimonRegisterDto) {
        Digimon digimon = modelMapper.map(digimonRegisterDto, Digimon.class);
       digimon = DigimonRepository.save(digimon);
       System.out.println();
        return modelMapper.map(digimon, DigimonRegisterDto.class);
    }

	@Override
	public List<DigimonRegisterDto> getAllDigimon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigimonRegisterDto getDigimonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existsDigimonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
