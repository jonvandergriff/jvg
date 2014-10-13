package com.stride.cartrek.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@EqualsAndHashCode(exclude = { "id" })
public class AccountPaymentInfoRelationship {

	@EmbeddedId
	@Getter
	@Setter
	private Id id = new Id();

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", insertable = false, updatable = false)
	private Account account;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "PAYMENT_INFO_ID", insertable = false, updatable = false)
	private PaymentInfo paymentInfo;

	@Embeddable
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor
	@EqualsAndHashCode
	public static class Id implements Serializable {

		private static final long serialVersionUID = 4896457527670618047L;

		@Column
		private Long userId;

		@Column
		private Long accountId;
	}

	public AccountPaymentInfoRelationship(Id id, Account account,
			PaymentInfo paymentInfo) {
		super();
		this.id = id;
		this.paymentInfo = paymentInfo;
		this.account = account;
		this.getId().userId = paymentInfo.getId();
		this.getId().accountId = account.getId();
		paymentInfo.getAccountPaymentInfoRelationships().add(this);
		account.getAccountPaymentInfoRelationships().add(this);
	}
}
