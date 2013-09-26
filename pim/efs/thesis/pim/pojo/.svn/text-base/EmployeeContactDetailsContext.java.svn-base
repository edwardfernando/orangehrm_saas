package efs.thesis.pim.pojo;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.model.ContactDetails;
import efs.thesis.saas.model.ContactDetailsType;
import efs.thesis.saas.model.Country;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeContactDetailsContext implements Loggable {

	private ContactDetails entity;
	private EmployeeContext employeeContext;
	private ContactDetailsType contactDetailsType;
	private String addressStreet1;
	private String addressStreet2;
	private String city;
	private String stateProvince;
	private Country country;
	private String homeTelephone;
	private String mobile;
	private String workTelephone;
	private String workEmail;
	private String otherEmail;
	
	public EmployeeContactDetailsContext(){}
	
	public EmployeeContactDetailsContext(EmployeeContext employeeContext){
		this.employeeContext = employeeContext;
	}
	
	public EmployeeContactDetailsContext(ContactDetails entity, EmployeeContext employeeContext) {
		setEntity(entity);
		this.employeeContext = employeeContext;
	}

	public ContactDetails getEntity() {
		return entity;
	}

	public void setEntity(ContactDetails entity) {
		this.entity = entity;
		
		if(CommonUtil.validateParam(entity)){
			this.contactDetailsType = entity.getContactDetailsType();
			this.country = entity.getCountry();
			this.addressStreet1 = entity.getAddressStreet1();
			this.addressStreet2 = entity.getAddressStreet2();
			this.city = entity.getCity();
			this.stateProvince = entity.getStateProvince();
			this.country = entity.getCountry();
			this.homeTelephone = entity.getHomeTelephone();
			this.mobile = entity.getMobile();
			this.workTelephone = entity.getWorkTelephone();
			this.workEmail = entity.getWorkEmail();
			this.otherEmail = entity.getOtherEmail();
		}
	}
	
	public EmployeeContext getEmployeeContext() {
		return employeeContext;
	}
	public void setEmployeeContext(EmployeeContext employeeContext) {
		this.employeeContext = employeeContext;
	}
	public ContactDetailsType getContactDetailsType() {
		return contactDetailsType;
	}
	public void setContactDetailsType(ContactDetailsType contactDetailsType) {
		this.contactDetailsType = contactDetailsType;
	}
	public String getAddressStreet1() {
		return addressStreet1;
	}
	public void setAddressStreet1(String addressStreet1) {
		this.addressStreet1 = addressStreet1;
	}
	public String getAddressStreet2() {
		return addressStreet2;
	}
	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getHomeTelephone() {
		return homeTelephone;
	}
	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getWorkTelephone() {
		return workTelephone;
	}
	public void setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
	}
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	public String getOtherEmail() {
		return otherEmail;
	}
	public void setOtherEmail(String otherEmail) {
		this.otherEmail = otherEmail;
	}
	
	@Override
	public String toString() {
		return "EmployeeContactDetailsContext [contactDetailsType="
				+ contactDetailsType + ", addressStreet1=" + addressStreet1
				+ ", addressStreet2=" + addressStreet2 + ", city=" + city
				+ ", stateProvince=" + stateProvince + ", country=" + country
				+ ", homeTelephone=" + homeTelephone + ", mobile=" + mobile
				+ ", workTelephone=" + workTelephone + ", workEmail="
				+ workEmail + ", otherEmail=" + otherEmail + "]";
	}

	@Override
	public String audit() {
		String audit = "";
		if(CommonUtil.validateParam(entity) && CommonUtil.validateParam(entity.getId())){
			audit = "Update " + entity.getClass().getSimpleName() + " with ID " + entity.getId();
		}else{
			audit = "Creating new ContactDetails :: " + this;
		}
		return audit;
	}
	
	
}
