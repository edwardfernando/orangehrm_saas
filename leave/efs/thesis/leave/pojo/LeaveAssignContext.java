package efs.thesis.leave.pojo;

import java.util.Date;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.LeaveTypes;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class LeaveAssignContext implements Loggable {

	private Employee assignedEmployee;
	private Employee entity;
	private LeaveTypes leaveTypes;
	private Date fromDate;
	private Date toDate;
	private String comments;

	public LeaveAssignContext(Employee entity) {
		this.entity = entity;
	}

	public Employee getAssignedEmployee() {
		return assignedEmployee;
	}

	public void setAssignedEmployee(Employee assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}

	public Employee getEntity() {
		return entity;
	}

	public void setEntity(Employee entity) {
		this.entity = entity;
	}

	public LeaveTypes getLeaveTypes() {
		return leaveTypes;
	}

	public void setLeaveTypes(LeaveTypes leaveTypes) {
		this.leaveTypes = leaveTypes;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmployeeName(){
		return new StringBuilder(entity.getFirstName()).append(" ").
				append(entity.getMiddleName()).append(" ").
				append(entity.getLastName()).toString();
	}
	
	@Override
	public String toString() {
		return "LeaveAssignContext [assignedEmployee=" + assignedEmployee
				+ ", entity=" + entity + ", leaveTypes=" + leaveTypes
				+ ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", comments=" + comments + "]";
	}

	@Override
	public String audit() {
		return null;
	}

}
