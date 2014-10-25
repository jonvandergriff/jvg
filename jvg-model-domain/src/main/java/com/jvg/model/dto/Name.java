package com.jvg.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class Name {

	@Id
	@Column(name = "name_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	private Boolean primry;

	@Getter
	@Setter
	private String title;

	@Getter
	@Setter
	private String firstName;

	@Getter
	@Setter
	private String middleName;

	@Getter
	@Setter
	private String lastName;

}
