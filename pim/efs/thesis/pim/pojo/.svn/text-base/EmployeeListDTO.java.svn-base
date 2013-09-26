package efs.thesis.pim.pojo;

import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.Job;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeListDTO {

	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String jobTitle;
	private String employmentStatus;
	private String subUnit;
	private String supervisor;
	
	public EmployeeListDTO(Employee emp){
		this.id = emp.getId();
		this.firstName = emp.getFirstName();
		this.middleName = emp.getMiddleName();
		this.lastName = emp.getLastName();
		
		for(Job job : emp.getJobs()){
			if(job.getTerminationStatus()){
				this.jobTitle = job.getJobTitle().getName();
				this.employmentStatus = job.getEmploymentStatus().getName();
				this.subUnit = job.getOrganizationUnitStructure().getName();
			}
		}
		
		Employee spv = emp.getEmployee();
		if(spv != null){
			this.supervisor = spv.getFirstName() + " " + spv.getMiddleName() + " " + spv.getLastName();
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
}
