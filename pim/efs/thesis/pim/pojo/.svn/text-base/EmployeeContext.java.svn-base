package efs.thesis.pim.pojo;

import java.util.Date;
import java.util.List;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.MaritalStatus;
import efs.thesis.saas.model.Nationality;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeContext implements Loggable {

	private Employee entity;
	private String firstName;
	private String middleName;
	private String lastName;
	private String employeeId;
	private String photograph;
	private String username;
	private String password;
	private String otherId;
	private String licenseDriverNumber;
	private Date licenseExpiryDate;
	private String gender;
	private MaritalStatus maritalStatus;
	private Nationality nationality;
	private Date dateOfBirth;
	private List<EmployeeContactDetailsContext> employeeContactDetailsContextList;
	private List<EmployeeDependentsContext> employeeDependentsContextList;
	private List<EmployeeImmigrationsContext> employeeImmigrationsContextList;
	private List<EmployeeJobContext> employeeJobContextList;
	
	public EmployeeContext() {
		
	}
	
	public EmployeeContext(Employee entity) {
		setEntity(entity);
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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPhotograph() {
		return photograph;
	}
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	public String getLicenseDriverNumber() {
		return licenseDriverNumber;
	}
	public void setLicenseDriverNumber(String licenseDriverNumber) {
		this.licenseDriverNumber = licenseDriverNumber;
	}
	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Employee getEntity() {
		return entity;
	}
	public void setEntity(Employee entity) {
		this.entity = entity;
		
		this.firstName = entity.getFirstName();
		this.middleName = entity.getMiddleName();
		this.lastName = entity.getLastName();
		this.employeeId = entity.getEmployeeId();
		this.username = entity.getUsername();
		this.password = entity.getPassword();
		this.otherId = entity.getOtherId();
		this.licenseDriverNumber = entity.getDriverLicenseNumber();
		this.gender = entity.getGender() == null ? "" : entity.getGender().toString();
		this.maritalStatus = entity.getMaritalStatus();
		this.dateOfBirth = entity.getDateOfBirth();
		this.nationality = entity.getNationality();
	}
	public List<EmployeeContactDetailsContext> getEmployeeContactDetailsContextList() {
		return employeeContactDetailsContextList;
	}
	public void setEmployeeContactDetailsContextList(List<EmployeeContactDetailsContext> employeeContactDetailsContextList) {
		this.employeeContactDetailsContextList = employeeContactDetailsContextList;
	}
	public List<EmployeeDependentsContext> getEmployeeDependentsContextList() {
		return employeeDependentsContextList;
	}
	public void setEmployeeDependentsContextList(List<EmployeeDependentsContext> employeeDependentsContextList) {
		this.employeeDependentsContextList = employeeDependentsContextList;
	}
	public List<EmployeeImmigrationsContext> getEmployeeImmigrationsContextList() {
		return employeeImmigrationsContextList;
	}
	public void setEmployeeImmigrationsContextList(List<EmployeeImmigrationsContext> employeeImmigrationsContextList) {
		this.employeeImmigrationsContextList = employeeImmigrationsContextList;
	}
	public List<EmployeeJobContext> getEmployeeJobContextList() {
		return employeeJobContextList;
	}
	public void setEmployeeJobContextList(List<EmployeeJobContext> employeeJobContextList) {
		this.employeeJobContextList = employeeJobContextList;
	}

	@Override
	public String toString() {
		return "EmployeeContext [firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", employeeId="
				+ employeeId + ", photograph=" + photograph + ", username="
				+ username + ", password=" + password + ", otherId=" + otherId
				+ ", licenseDriverNumber=" + licenseDriverNumber
				+ ", licenseExpiryDate=" + licenseExpiryDate + ", gender="
				+ gender + ", maritalStatus=" + maritalStatus
				+ ", nationality=" + nationality + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

	@Override
	public String audit() {
		String audit = "";
		if(CommonUtil.validateParam(entity) && CommonUtil.validateParam(entity.getId())){
			audit = "Update " + entity.getClass().getSimpleName() + " with ID " + entity.getId();
		}else{
			audit = "Creating new Employee :: " + this;
		}
		return audit;
	}

}
