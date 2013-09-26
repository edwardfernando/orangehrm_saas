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
 * JobTitle generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "JOB_TITLE")
public class JobTitle extends PlainModel implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String name;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String description;
	
	@FormElement(type = FormType.TEXTAREA, listed = true)
	private String note;
	private Set<JobSpecification> jobSpecifications = new HashSet<JobSpecification>(0);
	private Set<Job> jobs = new HashSet<Job>(0);

	public JobTitle() {
	}

	public JobTitle(String name, String description, String note,
			Set<JobSpecification> jobSpecifications, Set<Job> jobs) {
		this.name = name;
		this.description = description;
		this.note = note;
		this.jobSpecifications = jobSpecifications;
		this.jobs = jobs;
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

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobTitle")
	public Set<JobSpecification> getJobSpecifications() {
		return this.jobSpecifications;
	}

	public void setJobSpecifications(Set<JobSpecification> jobSpecifications) {
		this.jobSpecifications = jobSpecifications;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobTitle")
	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return getName();
	}

}
