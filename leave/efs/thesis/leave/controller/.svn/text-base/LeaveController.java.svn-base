package efs.thesis.leave.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.leave.pojo.LeaveAssignContext;
import efs.thesis.leave.service.LeaveService;
import efs.thesis.saas.editor.DateEditor;
import efs.thesis.saas.editor.EmployeeEditor;
import efs.thesis.saas.editor.LeaveTypesEditor;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.LeaveTypes;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Controller
@SessionAttributes("context")
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveService service;
	
	@Autowired
	private EmployeeEditor employeeEditor;
	
	@Autowired
	private LeaveTypesEditor leaveTypesEditor;
	
	@Autowired
	private DateEditor dateEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request){
		binder.registerCustomEditor(Employee.class, employeeEditor);
		binder.registerCustomEditor(LeaveTypes.class, leaveTypesEditor);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@RequestMapping("/summary/{employeeId}")
	public String index(ModelMap map, @PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.load(employeeId));
		return "/leave/leave_summary";
	}

	@RequestMapping("/summary/{employeeId}/details/{employeeLeavesId}")
	public String summaryDetails(
			ModelMap map,
			@PathVariable("employeeId")Integer employeeId,
			@PathVariable("employeeLeavesId")Integer employeeLeavesId) throws Exception{
		map.addAllAttributes(service.summaryDetails(employeeId, employeeLeavesId));
		
		return "/leave/leave_summary_details";
	}
	
	@RequestMapping("/assign/{employeeId}")
	public String assign(ModelMap map, @PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.assign(employeeId));
		return "/leave/leave_assign";
	}
	
	@RequestMapping("/assign/save")
	public String saveAssign(@ModelAttribute("context")LeaveAssignContext context, BindingResult result) throws Exception{
		service.saveAssign(context, result);
		
		if(result.hasErrors()){
			return "/leave/leave_assign";
		}
		
		return "redirect:/leave/summary/" + context.getAssignedEmployee().getId();
	}
	
	@RequestMapping("/list")
	public String list(ModelMap map) throws Exception{
		map.addAllAttributes(service.list());
		return "/leave/list";
	}
	
	@RequestMapping("/approve/{employeeId}/leave/{employeeLeaveId}/{employeeLeaveHistoryId}")
	public String approveLeave(
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("employeeLeaveId")Integer employeeLeaveId,
			@PathVariable("employeeLeaveHistoryId")Integer employeeLeaveHistoryId){
		Integer approvalStatusId = Integer.valueOf(CommonUtil.getHttpRequest().getParameter("approvalStatus"));
		service.approveLeave(employeeLeaveHistoryId, approvalStatusId);
		return "redirect:/leave/summary/" + employeeId + "/details/" + employeeLeaveId;
	}
}