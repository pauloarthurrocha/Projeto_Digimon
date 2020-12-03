package com.rocha.repository;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocha.dto.digimon.DigimonRegisterDto;
import com.rocha.entity.Digimon;

@Repository
@Table(name = "digimon")
public interface DigimonRepository extends JpaRepository<Digimon, Long> {
	List<Digimon> findDigimonByName(String name);
	Digimon getDigimonByName(String name);

	Long deleteByName(String name);

	void save(DigimonRegisterDto digimonDto);

}
