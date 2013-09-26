package efs.thesis.pim.pojo;

import efs.thesis.common.pojo.Loggable;
import efs.thesis.saas.model.ReportingMethod;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class EmployeeReportToContext implements Loggable {

	private EmployeeContext employeeContext;
	private ReportingMethod entity;
	
	public EmployeeReportToContext(){
		
	}
	
	public EmployeeReportToContext(ReportingMethod entity, EmployeeContext employeeContext){
		this.employeeContext = employeeContext;
		
	}
	
	@Override
	public String audit() {
		// TODO Auto-generated method stub
		return null;
	}

}
