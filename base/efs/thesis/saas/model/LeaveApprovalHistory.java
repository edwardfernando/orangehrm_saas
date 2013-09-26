package efs.thesis.saas.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import efs.thesis.common.annotation.AutoCrud;
import efs.thesis.common.annotation.FormElement;
import efs.thesis.common.enumtype.FormType;

@AutoCrud
@Entity
@Table(name = "LEAVE_APPROVAL_HISTORY")
public class LeaveApprovalHistory implements java.io.Serializable {

	private Integer id;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private EmployeeLeaveHistory employeeLeaveHistory;
	
	@FormElement(type = FormType.POPUP, listed = true)
	private Approval approval;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_LEAVE_HISTORY_ID")
	public EmployeeLeaveHistory getEmployeeLeaveHistory() {
		return employeeLeaveHistory;
	}
	public void setEmployeeLeaveHistory(EmployeeLeaveHistory employeeLeaveHistory) {
		this.employeeLeaveHistory = employeeLeaveHistory;
	}
	
	
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APPROVAL_ID")
	public Approval getApproval() {
		return approval;
	}
	public void setApproval(Approval approval) {
		this.approval = approval;
	}
	
}
