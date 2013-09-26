package efs.thesis.saas.model;

// Generated Mar 13, 2013 12:38:40 PM by Hibernate Tools 3.2.1.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;

/**
 * Country generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "COUNTRY")
public class Country extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, listed = true, filterable = true)
	private String name;
	
	@FormElement(type = FormType.TEXT, listed = true, filterable = true)
	private String code;
	private Set<Immgration> immgrations = new HashSet<Immgration>(0);
	private Set<ContactDetails> contactDetailses = new HashSet<ContactDetails>(0);
	private Set<WorkLocation> workLocations = new HashSet<WorkLocation>(0);

	public Country() {
	}

	public Country(String name, String code, Set<Immgration> immgrations,
			Set<ContactDetails> contactDetailses,
			Set<WorkLocation> workLocations) {
		this.name = name;
		this.code = code;
		this.immgrations = immgrations;
		this.contactDetailses = contactDetailses;
		this.workLocations = workLocations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Immgration> getImmgrations() {
		return this.immgrations;
	}

	public void setImmgrations(Set<Immgration> immgrations) {
		this.immgrations = immgrations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	public Set<ContactDetails> getContactDetailses() {
		return this.contactDetailses;
	}

	public void setContactDetailses(Set<ContactDetails> contactDetailses) {
		this.contactDetailses = contactDetailses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
	public Set<WorkLocation> getWorkLocations() {
		return this.workLocations;
	}

	public void setWorkLocations(Set<WorkLocation> workLocations) {
		this.workLocations = workLocations;
	}

	@Override
	public String toString() {
		return getName();
	}

}
