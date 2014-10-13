package com.stride.cartrek.model.dto;

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

import com.stride.cartrek.model.domain.enums.AddressType;
import com.stride.cartrek.model.domain.enums.StateEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class Address {

	@Id
	@Column(name = "address_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	private Boolean primry;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	@Getter
	@Setter
	private String street1;

	@Getter
	@Setter
	private String street2;

	@Getter
	@Setter
	private String city;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private StateEnum state;

	@Getter
	@Setter
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
	private Set<UserAddressRelationship> userAddressRelationships;

}
