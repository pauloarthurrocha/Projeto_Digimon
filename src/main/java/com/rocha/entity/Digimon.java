package com.rocha.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "digimon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Digimon implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String name;
	private String level;
	private String url;

}