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
public class UserContactInfoRelationship {

	@EmbeddedId
	@Getter
	@Setter
	private Id id = new Id();

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private User user;

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
		private Long userId;
		@Column
		private Long contactInfoId;
	}

	public UserContactInfoRelationship(Id id, User user, ContactInfo contactInfo) {
		this.id = id;
		this.user = user;
		this.contactInfo = contactInfo;
		this.getId().userId = user.getId();
		this.getId().contactInfoId = contactInfo.getId();
		user.getUserContactInfoRelationships().add(this);
		contactInfo.getUserContactInfoRelationships().add(this);
	}
}
