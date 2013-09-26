package efs.thesis.saas.filter;

import efs.thesis.common.pagination.criteria.AbstractFilterCriteria;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeListFilterCriteria extends AbstractFilterCriteria {

	private Integer id;
	private String employeeName;
	private String supervisorName;
	private String jobTitle;
	private String employmentStatus;
	private String subUnit;
	private Boolean showAll = false;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getSubUnit() {
		return subUnit;
	}
	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}
	public Boolean getShowAll() {
		return showAll;
	}
	public void setShowAll(Boolean showAll) {
		this.showAll = showAll;
	}
	
}
