package com.stride.cartrek.model.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class Account {

	@Id
	@Column(name = "account_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<UserAccountRelationship> userAccountRelationships;

	@Getter
	@Setter
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<AccountPaymentInfoRelationship> accountPaymentInfoRelationships;

}
