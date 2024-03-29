package efs.thesis.saas.model;

// Generated Mar 13, 2013 12:38:40 PM by Hibernate Tools 3.2.1.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.db.model.PlainModel;
import efs.thesis.common.enumtype.FormType;

/**
 * Job generated by hbm2java
 */

@AutoCrud
@Entity
@Table(name = "JOB")
@NamedQuery(name = "findJobByEmployee", query = "from Job j where j.employee = ?")
public class Job extends PlainModel implements java.io.Serializable {

	private Integer id;
	private WorkLocation workLocation;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private JobCategory jobCategory;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private JobTitle jobTitle;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private EmploymentStatus employmentStatus;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private OrganizationUnitStructure organizationUnitStructure;
	
	@FormElement(type = FormType.DATE, listed = true, filterable = true)
	private Date joinDate;
	
	@FormElement(type = FormType.DATE, listed = true)
	private Date contractStartDate;
	
	@FormElement(type = FormType.DATE, listed = true)
	private Date contractEndDate;
	
	@FormElement(type = FormType.CHECKBOX, listed = true)
	private Boolean terminationStatus;
	
	@FormElement(type = FormType.TEXT, listed = true)
	private String contractAttachment;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private Employee employee;
	
	private Set<Termination> terminations = new HashSet<Termination>(0);
//	private Set<Employee> employees = new HashSet<Employee>(0);

	public Job() {
	}

	public Job(WorkLocation workLocation, JobCategory jobCategory,
			JobTitle jobTitle, EmploymentStatus employmentStatus,
			OrganizationUnitStructure organizationUnitStructure) {
		this.workLocation = workLocation;
		this.jobCategory = jobCategory;
		this.jobTitle = jobTitle;
		this.employmentStatus = employmentStatus;
		this.organizationUnitStructure = organizationUnitStructure;
	}

	public Job(WorkLocation workLocation, JobCategory jobCategory,
			JobTitle jobTitle, EmploymentStatus employmentStatus,
			OrganizationUnitStructure organizationUnitStructure, Date joinDate,
			Date contractStartDate, Date contractEndDate,
			Boolean terminationStatus, String contractAttachment,
			Set<Termination> terminations) {
		this.workLocation = workLocation;
		this.jobCategory = jobCategory;
		this.jobTitle = jobTitle;
		this.employmentStatus = employmentStatus;
		this.organizationUnitStructure = organizationUnitStructure;
		this.joinDate = joinDate;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.terminationStatus = terminationStatus;
		this.contractAttachment = contractAttachment;
		this.terminations = terminations;
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
	@JoinColumn(name = "WORK_LOCATION_ID")
	public WorkLocation getWorkLocation() {
		return this.workLocation;
	}

	public void setWorkLocation(WorkLocation workLocation) {
		this.workLocation = workLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_CATEGORY_ID")
	public JobCategory getJobCategory() {
		return this.jobCategory;
	}

	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_TITLE_ID")
	public JobTitle getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYMENT_STATUS_ID")
	public EmploymentStatus getEmploymentStatus() {
		return this.employmentStatus;
	}

	public void setEmploymentStatus(EmploymentStatus employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZATION_UNIT_STRUCTURE_ID")
	public OrganizationUnitStructure getOrganizationUnitStructure() {
		return this.organizationUnitStructure;
	}

	public void setOrganizationUnitStructure(
			OrganizationUnitStructure organizationUnitStructure) {
		this.organizationUnitStructure = organizationUnitStructure;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "JOIN_DATE", length = 10)
	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONTRACT_START_DATE", length = 10)
	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONTRACT_END_DATE", length = 10)
	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	@Column(name = "TERMINATION_STATUS")
	public Boolean getTerminationStatus() {
		return this.terminationStatus;
	}

	public void setTerminationStatus(Boolean terminationStatus) {
		this.terminationStatus = terminationStatus;
	}

	@Column(name = "CONTRACT_ATTACHMENT")
	public String getContractAttachment() {
		return this.contractAttachment;
	}

	public void setContractAttachment(String contractAttachment) {
		this.contractAttachment = contractAttachment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job")
	public Set<Termination> getTerminations() {
		return this.terminations;
	}

	public void setTerminations(Set<Termination> terminations) {
		this.terminations = terminations;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "job")
//	public Set<Employee> getEmployees() {
//		return this.employees;
//	}
//
//	public void setEmployees(Set<Employee> employees) {
//		this.employees = employees;
//	}

	@Override
	public String toString() {
		return new StringBuffer(getJobTitle().toString()).append(" - ").append(getEmploymentStatus()).toString();
	}

}
