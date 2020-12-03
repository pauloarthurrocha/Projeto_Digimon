package com.rocha.service.impl;


import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rocha.dto.digimon.DigimonRegisterDto;
import com.rocha.dto.digimon.DigimonResponseDto;
import com.rocha.entity.Digimon;
import com.rocha.repository.DigimonRepository;
import com.rocha.service.DigimonService;



@Service
public class DigimonServiceImpl implements DigimonService{
	
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DigimonRepository digimonRepository;
    


    @Override
    public DigimonRegisterDto createDigimon(DigimonRegisterDto digimonRegisterDto) {
        Digimon digimon = modelMapper.map(digimonRegisterDto, Digimon.class);
        System.out.println(digimonRegisterDto.getName());
        digimon = digimonRepository.save(digimon);
     
        return modelMapper.map(digimon, DigimonRegisterDto.class);
    }

	@Override
	public List<DigimonRegisterDto> getAllDigimon() {
		  Iterable<Digimon> digimons = digimonRepository.findAll();
          List<DigimonRegisterDto> digimonsDto = new ArrayList<DigimonRegisterDto>();
          for (Digimon digimon : digimons) {
              DigimonRegisterDto digimonParse = modelMapper.map(digimon, DigimonRegisterDto.class);
              digimonsDto.add(digimonParse);
          }
      return digimonsDto;
	}

	@Override
	public DigimonRegisterDto getDigimonByName(String name) {
		 Digimon digimon =  digimonRepository.getDigimonByName(name);
			        
			        return modelMapper.map(digimon, DigimonRegisterDto.class);
	}

	@Override
	public Boolean existsDigimonByName(String name) {
	     List<Digimon> agency = digimonRepository.findDigimonByName(name);
	        if (agency.size() > 0) {
	            return true;
	        }
	        return false;

	}

	@Transactional
	@Override
	public void deleteDigimonByName(String name) {
		 digimonRepository.deleteByName(name);
		
	}

	@Override
	public DigimonResponseDto editDigimonByName(String name, DigimonRegisterDto dto) {
		  Digimon digimon = digimonRepository.getDigimonByName(name);
		  digimon.setName(dto.getName());
		  digimon.setLevel(dto.getLevel());
		  digimon.setUrl(dto.getUrl());
		   digimonRepository.save(digimon);
			        return modelMapper.map(digimon, DigimonResponseDto.class);
	}

	

}
