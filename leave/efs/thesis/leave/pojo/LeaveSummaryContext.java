package efs.thesis.leave.pojo;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.EmployeeLeaves;
import efs.thesis.saas.model.LeaveTypes;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class LeaveSummaryContext implements Loggable {
	
	private Employee employee;
	private EmployeeLeaves employeeLeaves;
	private LeaveTypes leaveTypes;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeLeaves getEmployeeLeaves() {
		return employeeLeaves;
	}

	public void setEmployeeLeaves(EmployeeLeaves employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	public LeaveTypes getLeaveTypes() {
		return leaveTypes;
	}

	public void setLeaveTypes(LeaveTypes leaveTypes) {
		this.leaveTypes = leaveTypes;
	}

	@Override
	public String audit() {
		return null;
	}

}
