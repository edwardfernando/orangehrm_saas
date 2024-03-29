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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;

/**
 * OrganizationUnitStructure generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "ORGANIZATION_UNIT_STRUCTURE")
public class OrganizationUnitStructure extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private OrganizationUnitStructure organizationUnitStructure;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String code;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String name;
	
	@FormElement(type = FormType.TEXTAREA, listed = true)
	private String description;
	private Set<Job> jobs = new HashSet<Job>(0);
	private Set<OrganizationUnitStructure> organizationUnitStructures = new HashSet<OrganizationUnitStructure>(0);

	public OrganizationUnitStructure() {
	}

	public OrganizationUnitStructure(
			OrganizationUnitStructure organizationUnitStructure) {
		this.organizationUnitStructure = organizationUnitStructure;
	}

	public OrganizationUnitStructure(
			OrganizationUnitStructure organizationUnitStructure, String code,
			String name, String description, Set<Job> jobs,
			Set<OrganizationUnitStructure> organizationUnitStructures) {
		this.organizationUnitStructure = organizationUnitStructure;
		this.code = code;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
		this.organizationUnitStructures = organizationUnitStructures;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_GROUP")
	public OrganizationUnitStructure getOrganizationUnitStructure() {
		return this.organizationUnitStructure;
	}

	public void setOrganizationUnitStructure(
			OrganizationUnitStructure organizationUnitStructure) {
		this.organizationUnitStructure = organizationUnitStructure;
	}

	@Column(name = "CODE", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organizationUnitStructure")
	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organizationUnitStructure")
	public Set<OrganizationUnitStructure> getOrganizationUnitStructures() {
		return this.organizationUnitStructures;
	}

	public void setOrganizationUnitStructures(
			Set<OrganizationUnitStructure> organizationUnitStructures) {
		this.organizationUnitStructures = organizationUnitStructures;
	}

	@Override
	public String toString() {
		return getName();
	}

}
