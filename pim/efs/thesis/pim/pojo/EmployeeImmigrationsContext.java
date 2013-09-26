package efs.thesis.pim.pojo;

import java.util.Date;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.saas.model.Country;
import efs.thesis.saas.model.ImmgirationType;
import efs.thesis.saas.model.Immgration;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeImmigrationsContext implements Loggable {

	private EmployeeContext employeeContext;
	private ImmgirationType immigrationType;
	private Immgration entity;
	private String number;
	private Date issuedDate;
	private Date expiryDate;
	private String eligibilityStatus;
	private Country country;
	private Date eligibilityReviewDate;
	private String comments;
	
	public EmployeeImmigrationsContext(){
		
	}
	
	public EmployeeImmigrationsContext(Immgration entity, EmployeeContext context){
		this.employeeContext = context;
		setEntity(entity);
	}
	
	public ImmgirationType getImmigrationType() {
		return immigrationType;
	}
	public void setImmigrationType(ImmgirationType immigrationType) {
		this.immigrationType = immigrationType;
	}
	public EmployeeContext getEmployeeContext() {
		return employeeContext;
	}
	public void setEmployeeContext(EmployeeContext employeeContext) {
		this.employeeContext = employeeContext;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getEligibilityStatus() {
		return eligibilityStatus;
	}
	public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Date getEligibilityReviewDate() {
		return eligibilityReviewDate;
	}
	public void setEligibilityReviewDate(Date eligibilityReviewDate) {
		this.eligibilityReviewDate = eligibilityReviewDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Immgration getEntity() {
		return entity;
	}
	public void setEntity(Immgration entity) {
		this.entity = entity;
		
		if(CommonUtil.validateParam(entity)){
			this.immigrationType = entity.getImmgirationType();
			this.number = entity.getNumber();
			this.issuedDate = entity.getIssuedDate();
			this.expiryDate = entity.getExpiryDate();
			this.eligibilityStatus = entity.getEligibilityStatus();
			this.eligibilityReviewDate = entity.getEligibilityReviewDate();
			this.country = entity.getCountry();
			this.comments = entity.getComments();
		}
	}

	@Override
	public String toString() {
		return "EmployeeImmigrationsContext [immigrationType="
				+ immigrationType + ", entity=" + entity + ", number=" + number
				+ ", issuedDate=" + issuedDate + ", expiryDate=" + expiryDate
				+ ", eligibilityStatus=" + eligibilityStatus + ", country="
				+ country + ", eligibilityReviewDate=" + eligibilityReviewDate
				+ ", comments=" + comments + "]";
	}

	@Override
	public String audit() {
		String audit = "";
		if(CommonUtil.validateParam(entity) && CommonUtil.validateParam(entity.getId())){
			audit = "Update " + entity.getClass().getSimpleName() + " with ID " + entity.getId();
		}else{
			audit = "Creating new Immigrations :: " + this;
		}
		return audit;
	}
	
}
