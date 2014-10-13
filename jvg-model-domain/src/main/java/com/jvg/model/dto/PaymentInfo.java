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
import javax.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.stride.cartrek.model.domain.enums.PaymentType;

@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class PaymentInfo {

	@Id
	@Column(name = "payment_info_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@Getter
	@Setter
	private Boolean primary;

	@Version
	private Integer lock;

	@Getter
	@Setter
	@OneToMany(mappedBy = "paymentInfo", cascade = CascadeType.ALL)
	private Set<AccountPaymentInfoRelationship> accountPaymentInfoRelationships;

}
