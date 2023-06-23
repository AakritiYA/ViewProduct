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
@Table(name = "product")
public @Data class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private @Getter @Setter String title;

	@Column(nullable = false)
	private @Getter @Setter double price;

	@Column
	private @Getter @Setter String description;

	@Column
	private @Getter @Setter Long categoryid;

}
