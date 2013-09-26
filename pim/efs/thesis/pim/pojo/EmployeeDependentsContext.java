package efs.thesis.pim.pojo;

import java.util.Date;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.model.Dependents;
import efs.thesis.saas.model.DependentsType;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */


public class EmployeeDependentsContext implements Loggable {

	private EmployeeContext employeeContext;
	private Dependents entity;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private DependentsType dependentsType;
	
	public EmployeeDependentsContext(){
		
	}
	
	public EmployeeDependentsContext(Dependents dependents, EmployeeContext employeeContext){
		this.employeeContext = employeeContext;
		
		setEntity(dependents);
		
	}
	
	public EmployeeContext getEmployeeContext() {
		return employeeContext;
	}
	public void setEmployeeContext(EmployeeContext employeeContext) {
		this.employeeContext = employeeContext;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public DependentsType getDependentsType() {
		return dependentsType;
	}
	public void setDependentsType(DependentsType dependentsType) {
		this.dependentsType = dependentsType;
	}
	public Dependents getEntity() {
		return entity;
	}
	public void setEntity(Dependents entity) {
		this.entity = entity;
		
		if(CommonUtil.validateParam(entity)){
			this.firstName = entity.getFirstName();
			this.middleName = entity.getMiddleName();
			this.lastName = entity.getLastName();
			this.dateOfBirth = entity.getDateOfBirth();
			this.dependentsType = entity.getDependentsType();
		}
	}

	@Override
	public String toString() {
		return "EmployeeDependentsContext [entity=" + entity + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth
				+ ", dependentsType=" + dependentsType + "]";
	}

	@Override
	public String audit() {
		String audit = "";
		if(CommonUtil.validateParam(entity) && CommonUtil.validateParam(entity.getId())){
			audit = "Update " + entity.getClass().getSimpleName() + " with ID " + entity.getId();
		}else{
			audit = "Creating new Dependents :: " + this;
		}
		return audit;
	}

}
