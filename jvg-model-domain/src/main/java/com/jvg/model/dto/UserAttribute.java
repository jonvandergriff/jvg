package com.stride.cartrek.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.stride.cartrek.model.domain.enums.AttributeType;

@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class UserAttribute {

	@Id
	@Column(name = "user_attrbute_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private AttributeType attributeType;

}
