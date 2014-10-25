package com.jvg.model.dto;

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
public class ContactInfo {

	@Id
	@Column(name = "CONTACT_INFO_ID")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	@OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL)
	private Set<UserContactInfoRelationship> userContactInfoRelationships;

	@Getter
	@Setter
	@OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL)
	private Set<ContactInfoPhonesRelationship> contactInfoPhonesRelationships;

	@Getter
	@Setter
	private String twitterHandle;

	@Getter
	@Setter
	private String facebookUrl;

	@Getter
	@Setter
	private String facebookUserName;

}
