package efs.thesis.leave.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.DateUtil;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.leave.pojo.LeaveAssignContext;
import efs.thesis.leave.pojo.LeaveSummaryContext;
import efs.thesis.leave.pojo.LeaveSummaryDetailsDTO;
import efs.thesis.saas.dao.ApprovalLevelDAO;
import efs.thesis.saas.dao.ApprovalStatusDAO;
import efs.thesis.saas.dao.EmployeeAccessDAO;
import efs.thesis.saas.dao.EmployeeDAO;
import efs.thesis.saas.dao.EmployeeLeaveHistoryDAO;
import efs.thesis.saas.dao.EmployeeLeavesDAO;
import efs.thesis.saas.dao.LeaveApprovalHistoryDAO;
import efs.thesis.saas.dao.LeavePeriodDAO;
import efs.thesis.saas.dao.LeaveTypesDAO;
import efs.thesis.saas.model.Approval;
import efs.thesis.saas.model.ApprovalLevel;
import efs.thesis.saas.model.ApprovalStatus;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.EmployeeAccess;
import efs.thesis.saas.model.EmployeeLeaveHistory;
import efs.thesis.saas.model.EmployeeLeaves;
import efs.thesis.saas.model.LeaveApprovalHistory;
import efs.thesis.saas.model.LeaveTypes;
import efs.thesis.saas.model.Role;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class LeaveService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeLeavesDAO employeeLeavesDAO;
	
	@Autowired
	private EmployeeLeaveHistoryDAO employeeLeaveHistoryDAO;
	
	@Autowired
	private LeaveTypesDAO leaveTypesDAO;
	
	@Autowired
	private LeavePeriodDAO leavePeriodDAO;
	
	@Autowired
	private ApprovalLevelDAO approvalLevelDAO;
	
	@Autowired
	private LeaveApprovalHistoryDAO leaveApprovalHistoryDAO;
	
	@Autowired
	private ApprovalStatusDAO approvalStatusDAO;
	
	@Autowired
	private EmployeeAccessDAO employeeAccessDAO;
	
	public Map<String, Object> load(Integer employeeId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		Employee emp = employeeDAO.findById(employeeId);
		
		List<LeaveSummaryContext> summaryList = new ArrayList<LeaveSummaryContext>();
		for(LeaveTypes types : leaveTypesDAO.findAll()){
			LeaveSummaryContext context = new LeaveSummaryContext();
			context.setLeaveTypes(types);
			context.setEmployee(emp);
			
			EmployeeLeaves el = (EmployeeLeaves)employeeLeavesDAO.execUnique("from EmployeeLeaves el where el.employee.id = ? and el.leaveTypes = ?", new Object[]{employeeId, types});
			context.setEmployeeLeaves(el);
			
			summaryList.add(context);
		}
		
		map.put("employee", emp);
		map.put("leavesList", summaryList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> summaryDetails(Integer employeeId, Integer employeeLeavesId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		EmployeeLeaves employeeLeaves = employeeLeavesDAO.findById(employeeLeavesId);
		
		List<ApprovalStatus> approvalStatusList = approvalStatusDAO.findAll();
		List<EmployeeLeaveHistory> empLeavesHistory = (List<EmployeeLeaveHistory>)employeeLeaveHistoryDAO.execList("from EmployeeLeaveHistory elh where elh.employeeLeaves = ?", new Object[]{employeeLeaves});
		List<ApprovalLevel> requiredApprovalLevel = (List<ApprovalLevel>)approvalLevelDAO.execList("from ApprovalLevel al where al.isRequired = true order by al.id");
		List<LeaveSummaryDetailsDTO> leaveSummaryDetailsDTOList = new ArrayList<LeaveSummaryDetailsDTO>();
		
		
		EmployeeAccess ac = (EmployeeAccess)employeeAccessDAO.
				execUnique("from EmployeeAccess ae where ae.employee = ? and ae.accessibleModule.url = ?", 
						new Object[]{SessionCookieUtil.getLoggedUser().getEmployee(), "/leave/approve"});
		
		for(EmployeeLeaveHistory elh : empLeavesHistory){
			LeaveSummaryDetailsDTO dto = new LeaveSummaryDetailsDTO();
			dto.setEntity(elh);
			dto.setLeaveTypes(elh.getEmployeeLeaves().getLeaveTypes());
			dto.setFrom(elh.getFromDate());
			dto.setTo(elh.getToDate());
			dto.setLeaveTake(elh.getLeaveTaken());
			
			List<Integer> requiredApprovalLevelList = new ArrayList<Integer>();
			for(ApprovalLevel al : requiredApprovalLevel){
				LeaveApprovalHistory lah = (LeaveApprovalHistory)leaveApprovalHistoryDAO.
						execUnique("from LeaveApprovalHistory lah where lah.employeeLeaveHistory = ? and lah.approval.approvalLevel = ?", new Object[]{elh, al});
				dto.getLeaveApprovalHistory().put(al.getName(), lah);
				requiredApprovalLevelList.add(al.getId());
			}
			Collections.sort(requiredApprovalLevelList);
			
			List<LeaveApprovalHistory> approvalHistoryList = (List<LeaveApprovalHistory>)leaveApprovalHistoryDAO.
					execList("from LeaveApprovalHistory lah where lah.employeeLeaveHistory = ? and lah.approval.approvalLevel.id < ?", 
							new Object[]{elh, ac.getApprovalLevel().getId()});
			
			
			List<Integer> currentApprovedLevel = new ArrayList<Integer>();
			for(LeaveApprovalHistory lah : approvalHistoryList){
				currentApprovedLevel.add(lah.getApproval().getApprovalLevel().getId());
			}
			Collections.sort(currentApprovedLevel);
			
			
			boolean isApproved = false;
			for(Map.Entry<String, LeaveApprovalHistory> leave : dto.getLeaveApprovalHistory().entrySet()){
				LeaveApprovalHistory lah = leave.getValue();
				if(CommonUtil.validateParam(lah)){
//					lah.getApproval().getApprovalStatus().getName().equalsIgnoreCase("approved");
					Integer approvedLevel = lah.getApproval().getApprovalLevel().getId();
					if(requiredApprovalLevelList.contains(approvedLevel)){
						isApproved = true;
					}else{
						isApproved = false;
					}
				}
			}
			dto.setIsApproved(isApproved);
			
			requiredApprovalLevelList.removeAll(currentApprovedLevel);
			
			boolean ableToApprove = false;
			if(requiredApprovalLevelList.get(0) == ac.getApprovalLevel().getId()){
				ableToApprove = true;
			}
			dto.setLoggedUserAbleToApprove(ableToApprove);
			
			
			leaveSummaryDetailsDTOList.add(dto);
		}
		
		map.put("approvalStatusList", approvalStatusList);
		map.put("empLeavesHistory", empLeavesHistory);
		map.put("employee", employeeDAO.findById(employeeId));
		map.put("employeeLeaves", employeeLeaves);
		map.put("leaveSummaryDetail", leaveSummaryDetailsDTOList);
		return map;
	}
	
	public Map<String, Object> assign(Integer employeeId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(employeeId);
		map.put("context", new LeaveAssignContext(emp));
		
		map.put("subordinatesList", employeeDAO.execList("from Employee e where e.employee = ?", new Object[]{emp}));
		
		return map;
	}
	
	public void saveAssign(LeaveAssignContext context, Errors err) throws Exception{
		EmployeeLeaves el = (EmployeeLeaves) employeeLeavesDAO.execUnique("from EmployeeLeaves el where el.leaveTypes = ? and el.employee = ?", 
								new Object[]{context.getLeaveTypes(), context.getAssignedEmployee()});
		
		int leaveTaken = Days.daysBetween(new DateTime(context.getFromDate()), new DateTime(context.getToDate())).getDays();
		if(!CommonUtil.validateParam(el)){
			err.reject("", "Employee " + context.getEmployeeName() + " doesn't have any allocation for " + context.getLeaveTypes().getName() + " leave.");
		}else if(el.getLeaveAllocation() < leaveTaken){
			err.reject("", "Employee can't take " + leaveTaken +" day(s) for "+ el.getLeaveTypes().getName() +". Only " + el.getLeaveAllocation() + " day(s) left.");
		}else{
			EmployeeLeaveHistory leaveHistory = new EmployeeLeaveHistory();
			leaveHistory.setLeaveTaken(leaveTaken);
			leaveHistory.setEmployeeLeaves(el);
			leaveHistory.setFromDate(context.getFromDate());
			leaveHistory.setToDate(context.getToDate());
			employeeLeaveHistoryDAO.insert(leaveHistory);
		}
	}
	
	public Map<String, Object> list() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmployeeLeaveHistory> leaves = new ArrayList<EmployeeLeaveHistory>();
		
		Role loggedRole = SessionCookieUtil.getLoggedUser().getEmployee().getRole();
		if(loggedRole.getCode().equals("HRD") || loggedRole.getCode().equals("GM")){
			leaves = employeeLeaveHistoryDAO.findAll();
		}else{
			leaves = (List<EmployeeLeaveHistory>) employeeLeaveHistoryDAO.
					execList("from EmployeeLeaveHistory elh where elh.employeeLeaves.employee.employee = ?", 
							new Object[]{SessionCookieUtil.getLoggedUser().getEmployee()});
		}
		map.put("employeeLeaveList", leaves);
		return map;
	}
	
	public void approveLeave(Integer employeeLeaveHistoryId, Integer approvalStatusId){
		EmployeeLeaveHistory elh = employeeLeaveHistoryDAO.findById(employeeLeaveHistoryId);
		ApprovalStatus as = approvalStatusDAO.findById(approvalStatusId);
		ApprovalLevel al = SessionCookieUtil.getLoggedUser().getApprovalAccess().getApprovalLevel();
		
		Approval app = new Approval();
		app.setDate(DateUtil.now());
		app.setApprovalLevel(al);
		app.setApprovalStatus(as);
		
		LeaveApprovalHistory lah = new LeaveApprovalHistory();
		lah.setApproval(app);
		lah.setEmployeeLeaveHistory(elh);
		
		leaveApprovalHistoryDAO.insert(lah);
	}
}
