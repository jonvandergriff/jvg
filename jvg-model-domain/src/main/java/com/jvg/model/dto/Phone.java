package com.jvg.model.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.jvg.model.domain.enums.PhoneType;

@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class Phone {

	@Id
	@Column(name = "PHONE_ID")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "phone", cascade = CascadeType.ALL)
	private Set<ContactInfoPhonesRelationship> contactInfoPhonesRelationships;

}
