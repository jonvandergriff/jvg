package com.jvg.model.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.jvg.model.domain.enums.AttributeType;

/**
 * 
 * @author Jon Vandergriff
 * 
 */
@Entity
@Table
@EqualsAndHashCode(exclude = { "id" })
public class User {

	@Id
	@Column(name = "user_id")
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	@Enumerated(EnumType.STRING)
	private AttributeType attributeType;

	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Set<Name> names = new HashSet<Name>();

	@Getter
	@Setter
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserAddressRelationship> userAddressRelationships = new HashSet<UserAddressRelationship>();

	@Getter
	@Setter
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserContactInfoRelationship> userContactInfoRelationships = new HashSet<UserContactInfoRelationship>();

	@Getter
	@Setter
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserAccountRelationship> userAccountRelationships = new HashSet<UserAccountRelationship>();

}
