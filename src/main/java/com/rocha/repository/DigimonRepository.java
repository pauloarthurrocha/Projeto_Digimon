package com.rocha.repository;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rocha.entity.Digimon;

@Repository
@Table(name = "digimon")
public interface DigimonRepository extends JpaRepository<Digimon, Long> {
	List<Digimon> findDigimonEntityByName(String name);

	void deleteByName(String name);

}
