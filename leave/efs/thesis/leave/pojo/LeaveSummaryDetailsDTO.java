package efs.thesis.leave.pojo;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import efs.thesis.saas.model.EmployeeLeaveHistory;
import efs.thesis.saas.model.LeaveApprovalHistory;
import efs.thesis.saas.model.LeaveTypes;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class LeaveSummaryDetailsDTO {

	private EmployeeLeaveHistory entity;
	private LeaveTypes leaveTypes;
	private Date from;
	private Date to;
	private int leaveTake;
	private boolean isApproved;
	private boolean loggedUserAbleToApprove;
	private Map<String, LeaveApprovalHistory> leaveApprovalHistory = new TreeMap<String, LeaveApprovalHistory>();
	
	
	public EmployeeLeaveHistory getEntity() {
		return entity;
	}
	public void setEntity(EmployeeLeaveHistory entity) {
		this.entity = entity;
	}
	public LeaveTypes getLeaveTypes() {
		return leaveTypes;
	}
	public void setLeaveTypes(LeaveTypes leaveTypes) {
		this.leaveTypes = leaveTypes;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public int getLeaveTake() {
		return leaveTake;
	}
	public void setLeaveTake(int leaveTake) {
		this.leaveTake = leaveTake;
	}
	public Map<String, LeaveApprovalHistory> getLeaveApprovalHistory() {
		return leaveApprovalHistory;
	}
	public void setLeaveApprovalHistory(Map<String, LeaveApprovalHistory> leaveApprovalHistory) {
		this.leaveApprovalHistory = leaveApprovalHistory;
	}
	public boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public boolean getLoggedUserAbleToApprove() {
		return loggedUserAbleToApprove;
	}
	public void setLoggedUserAbleToApprove(boolean loggedUserAbleToApprove) {
		this.loggedUserAbleToApprove = loggedUserAbleToApprove;
	}
	@Override
	public String toString() {
		return "LeaveSummaryDetailsDTO [leaveTypes=" + leaveTypes + ", from="
				+ from + ", to=" + to + ", leaveTake=" + leaveTake
				+ ", leaveApprovalHistory=" + leaveApprovalHistory + "]";
	}

}
