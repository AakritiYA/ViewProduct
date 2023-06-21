package com.springrest.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "attribute")
public @Data class ProductAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attributeid;

	@Column
	private Long productid;

	@Column
	private String color;

	@Column
	private String size;

}
