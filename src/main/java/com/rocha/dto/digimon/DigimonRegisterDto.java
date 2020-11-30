package com.rocha.dto.digimon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DigimonRegisterDto {
	
	private String name;
	private String level;
	private String url;

}
