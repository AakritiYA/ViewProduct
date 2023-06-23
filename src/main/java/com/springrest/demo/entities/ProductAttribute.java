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
@Table(name = "attribute")
public @Data class ProductAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attributeid;

	@Column
	private @Getter @Setter Long productid;

	@Column
	private @Getter @Setter String color;

	@Column
	private @Getter @Setter String size;

}
