package efs.thesis.home.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.RequestAttributes;

import efs.thesis.common.pojo.UserContext;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.Constants;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.saas.dao.EmployeeAccessDAO;
import efs.thesis.saas.dao.EmployeeDAO;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.EmployeeAccess;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class TenantService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeAccessDAO employeeAccessDAO;
	
	public Map<String, Object> login(String tenantAlias){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userContext", new UserContext());
		map.put("tenantAlias", tenantAlias);
//		map.put("tenants", TenantDataSource.instance().getTenantContextList());
		return map;
	}
	
	public Map<String, Object> checkLogin(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		return map;
	}
	
	public void validateForm(UserContext ctx, Errors err) throws Exception{
		String username = ctx.getEmployee().getUsername();
		String password = ctx.getEmployee().getPassword();
		
		if(!CommonUtil.validateParam(username)){
			err.rejectValue("employee.username", "", "Please provide your username");
		}
		
		if(!CommonUtil.validateParam(password)){
			err.rejectValue("employee.password", "", "Please provide your password");
		}
		
		if(CommonUtil.validateParam(username) && CommonUtil.validateParam(password)){
			Employee emp = (Employee)employeeDAO.execUnique("from Employee e where e.username = ?", new Object[]{username});
			if(!CommonUtil.validateParam(emp)){
				err.reject("","No user found.");
			}else if(!emp.getPassword().equals(password)){
				err.reject("", "Password incorrect.");
			}else{
				EmployeeAccess ac = (EmployeeAccess)employeeAccessDAO.execUnique("from EmployeeAccess ae where ae.employee = ? and ae.accessibleModule.url = ?", new Object[]{emp, "/leave/approve"});

				UserContext loggedUser = new UserContext(emp);
				loggedUser.setApprovalAccess(ac);
				SessionCookieUtil.setSession(Constants.USER_SESSION_CONTEXT, loggedUser, RequestAttributes.SCOPE_GLOBAL_SESSION);
			}
		}
	}
}
