package efs.thesis.pim.pojo;

import java.util.Date;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.model.EmploymentStatus;
import efs.thesis.saas.model.Job;
import efs.thesis.saas.model.JobCategory;
import efs.thesis.saas.model.JobTitle;
import efs.thesis.saas.model.OrganizationUnitStructure;
import efs.thesis.saas.model.WorkLocation;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeJobContext implements Loggable {

	private EmployeeContext employeeContext;
	private Job entity;
	private JobTitle jobTitle;
	private EmploymentStatus employmentStatus;
	private JobCategory jobCategory;
	private Date joinDate;
	private OrganizationUnitStructure organizationUnitStructure;
	private WorkLocation workLocation;
	private Date startDate;
	private Date endDate;
	
	public EmployeeJobContext(){
		
	}
	
	public EmployeeJobContext(Job entity, EmployeeContext employeeContext) {
		this.employeeContext = employeeContext;
		setEntity(entity);
	}

	public EmployeeContext getEmployeeContext() {
		return employeeContext;
	}
	public void setEmployeeContext(EmployeeContext employeeContext) {
		this.employeeContext = employeeContext;
	}
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
	public EmploymentStatus getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(EmploymentStatus employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public JobCategory getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(JobCategory jobCategory) {
		this.jobCategory = jobCategory;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public OrganizationUnitStructure getOrganizationUnitStructure() {
		return organizationUnitStructure;
	}
	public void setOrganizationUnitStructure(
			OrganizationUnitStructure organizationUnitStructure) {
		this.organizationUnitStructure = organizationUnitStructure;
	}
	public WorkLocation getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(WorkLocation workLocation) {
		this.workLocation = workLocation;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getEntity() {
		return entity;
	}

	public void setEntity(Job entity) {
		this.entity = entity;
		
		if(CommonUtil.validateParam(entity)){
			this.jobTitle = entity.getJobTitle();
			this.employmentStatus = entity.getEmploymentStatus();
			this.jobCategory = entity.getJobCategory();
			this.joinDate = entity.getJoinDate();
			this.organizationUnitStructure = entity.getOrganizationUnitStructure();
			this.workLocation = entity.getWorkLocation();
			this.startDate = entity.getContractEndDate();
			this.endDate = entity.getContractEndDate();
		}
	}

	@Override
	public String toString() {
		return "EmployeeJobContext [jobTitle=" + jobTitle
				+ ", employmentStatus=" + employmentStatus + ", jobCategory="
				+ jobCategory + ", joinDate=" + joinDate
				+ ", organizationUnitStructure=" + organizationUnitStructure
				+ ", workLocation=" + workLocation + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	@Override
	public String audit() {
		String audit = "";
		if(CommonUtil.validateParam(entity) && CommonUtil.validateParam(entity.getId())){
			audit = "Update " + entity.getClass().getSimpleName() + " with ID " + entity.getId();
		}else{
			audit = "Creating new Job :: " + this;
		}
		return audit;
	}
	
}
