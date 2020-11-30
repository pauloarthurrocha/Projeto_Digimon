package com.rocha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.dto.digimon.DigimonRegisterDto;
import com.rocha.dto.error.ErrorDto;
import com.rocha.service.DigimonService;

@RestController
@RequestMapping("/digimon")
public class DigimonController {

	@Autowired
	private DigimonService digimonService;

	@PostMapping("/cadastro/{id}")
	ResponseEntity<?> registerDigimon(@RequestBody DigimonRegisterDto body) {
		try {
			if (!digimonService.existsDigimonByName(body.getName())) {
				return new ResponseEntity<DigimonRegisterDto>(digimonService.createDigimon(body), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ErrorDto>(new ErrorDto("Digimon já cadastrado"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<DigimonRegisterDto>> findAll() {

		List<DigimonRegisterDto> list = digimonService.getAllDigimon();

		return ResponseEntity.ok().body(list);

	}


}
