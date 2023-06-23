package com.springrest.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
public @Data class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "level1", nullable = false)
	private @Getter @Setter String level1;

	@Column(name = "level2", nullable = false)
	private @Getter @Setter String level2;

}
