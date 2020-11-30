package com.rocha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/cadastro")
	ResponseEntity<?> registerDigimon(@RequestBody DigimonRegisterDto body) {
		try {
			System.out.println(body.getName());
			if (!digimonService.existsDigimonByName(body.getName())) {
				return new ResponseEntity<DigimonRegisterDto>(digimonService.createDigimon(body), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ErrorDto>(new ErrorDto("Digimon já cadastrado"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/name")
	ResponseEntity<?> getDigimonByName(@PathVariable String name) {
		try {
			return new ResponseEntity<DigimonRegisterDto>(digimonService.getDigimonByName(name), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("Erro inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	ResponseEntity<?> getAllDigimon() {
		try {
			return new ResponseEntity<List<DigimonRegisterDto>>((digimonService.getAllDigimon()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("Erro inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{name}")
	public ResponseEntity<?> deleteDigimon(@PathVariable String name) {
		try {
			digimonService.deleteDigimonByName(name);
			return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<ErrorDto>(new ErrorDto("Erro inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/{name}")
	ResponseEntity<?> editAgencyById(@PathVariable String name, @RequestBody DigimonRegisterDto digimonRegisterDto) {
		try {
			return new ResponseEntity<DigimonRegisterDto>(digimonService.editDigimonByName(name, digimonRegisterDto),
					HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<ErrorDto>(new ErrorDto("Erro inesperado"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
