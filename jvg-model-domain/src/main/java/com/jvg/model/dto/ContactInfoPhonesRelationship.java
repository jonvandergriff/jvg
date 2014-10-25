package com.jvg.model.dto;

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
public class ContactInfoPhonesRelationship {

	@EmbeddedId
	@Getter
	@Setter
	private Id id = new Id();

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "PHONE_ID", insertable = false, updatable = false)
	private Phone phone;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "CONTACT_INFO_ID", insertable = false, updatable = false)
	private ContactInfo contactInfo;

	@Embeddable
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	@NoArgsConstructor
	@EqualsAndHashCode
	public static class Id implements Serializable {
		private static final long serialVersionUID = 4896457527670618047L;
		@Column
		private Long phoneId;
		@Column
		private Long contactInfoId;
	}

	public ContactInfoPhonesRelationship(Id id, Phone phone,
			ContactInfo contactInfo) {
		this.id = id;
		this.phone = phone;
		this.contactInfo = contactInfo;
		this.getId().phoneId = phone.getId();
		this.getId().contactInfoId = contactInfo.getId();
		phone.getContactInfoPhonesRelationships().add(this);
		contactInfo.getContactInfoPhonesRelationships().add(this);
	}

}
