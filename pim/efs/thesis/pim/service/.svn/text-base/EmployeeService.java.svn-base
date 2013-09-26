/**
 * 
 */
package efs.thesis.pim.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import efs.thesis.common.annotation.AuditTrails;
import efs.thesis.common.enumtype.AuditTrailsActionType;
import efs.thesis.common.factory.GridViewFactory;
import efs.thesis.common.pagination.FilterPaging;
import efs.thesis.common.pagination.criteria.FilterCriteria;
import efs.thesis.common.pagination.gridquery.AbstractGridViewQuery;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.pim.pojo.EmployeeContactDetailsContext;
import efs.thesis.pim.pojo.EmployeeContext;
import efs.thesis.pim.pojo.EmployeeDependentsContext;
import efs.thesis.pim.pojo.EmployeeImmigrationsContext;
import efs.thesis.pim.pojo.EmployeeJobContext;
import efs.thesis.pim.pojo.EmployeeListDTO;
import efs.thesis.saas.dao.ContactDetailsDAO;
import efs.thesis.saas.dao.DependentsDAO;
import efs.thesis.saas.dao.EmployeeDAO;
import efs.thesis.saas.dao.EmploymentStatusDAO;
import efs.thesis.saas.dao.ImmigrationDAO;
import efs.thesis.saas.dao.JobDAO;
import efs.thesis.saas.dao.JobTitleDAO;
import efs.thesis.saas.dao.OrganizationUnitStructureDAO;
import efs.thesis.saas.dao.ReportingMethodDAO;
import efs.thesis.saas.filter.EmployeeListFilterCriteria;
import efs.thesis.saas.model.ContactDetails;
import efs.thesis.saas.model.Dependents;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.Immgration;
import efs.thesis.saas.model.Job;
import efs.thesis.saas.model.ReportingMethod;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Component
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmploymentStatusDAO employmentStatusDAO;
	
	@Autowired
	private JobTitleDAO jobTitleDAO;
	
	@Autowired
	private OrganizationUnitStructureDAO organizationUnitStructureDAO;
	
	@Autowired
	private ContactDetailsDAO contactDetailsDAO;
	
	@Autowired
	private DependentsDAO dependentsDAO;
	
	@Autowired
	private ImmigrationDAO immigrationDAO;
	
	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private ReportingMethodDAO reportingMethodDAO;
	
	public Map<String, Object> load(FilterCriteria filterCriteria, Class<? extends AbstractGridViewQuery> query){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<EmployeeListDTO> dtos = new ArrayList<EmployeeListDTO>();
		for(Object obj : FilterPaging.filter(employeeDAO, GridViewFactory.create(filterCriteria, query))){
			Employee emp = (Employee)obj;
			dtos.add(new EmployeeListDTO(emp));
		}
		
		EmployeeListFilterCriteria cri = (EmployeeListFilterCriteria)filterCriteria;
		if(CommonUtil.validateParam(cri.getEmploymentStatus())){
			map.put("employmentStatus", employmentStatusDAO.findById(Integer.parseInt(cri.getEmploymentStatus())).getName());
		}
		
		if(CommonUtil.validateParam(cri.getJobTitle())){
			map.put("jobTitle", jobTitleDAO.findById(Integer.parseInt(cri.getJobTitle())).getName());
		}
		
		if(CommonUtil.validateParam(cri.getSubUnit())){
			map.put("subUnit", organizationUnitStructureDAO.findById(Integer.parseInt(cri.getSubUnit())).getName());
		}
		
		map.put("showAll", cri.getShowAll());
		
		map.put("employee_list", dtos);
		map.put("filterCriteria", filterCriteria);
		return map;
	}
	
	public Map<String, Object> add(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(id);
		
		EmployeeContext context = new EmployeeContext();
		if(CommonUtil.validateParamWithZeroPosibility(id)){
			context.setEntity(emp);
		}
		
		map.put("employee", emp);
		map.put("context", context);
		return map;
	}
	
	public Map<String, Object> addContactDetails(Integer employeeId, Integer contactDetailsId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(employeeId);
		List<ContactDetails> contactDetailsList = (List<ContactDetails>)contactDetailsDAO.execListNamedQuery("findContactDetailsByEmployee", new Object[]{emp});
		
		ContactDetails cd = null;
		if(CommonUtil.validateParamWithZeroPosibility(contactDetailsId)){
			cd = contactDetailsDAO.findById(contactDetailsId);
		}
		
		EmployeeContext employeeContext = new EmployeeContext(emp);
		map.put("context", new EmployeeContactDetailsContext(cd, employeeContext));
		map.put("contactDetailsList", contactDetailsList);
		map.put("employee", emp);
		return map;
	}
	
	public Map<String, Object> addDependents(Integer employeeId, Integer dependentsId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(employeeId);
		EmployeeContext employeeContext = new EmployeeContext(emp);
		List<Dependents> dependentsList = (List<Dependents>)dependentsDAO.execListNamedQuery("findDependentsByEmployee", new Object[]{emp});

		Dependents dependents = null;
		if(CommonUtil.validateParamWithZeroPosibility(dependentsId)){
			dependents = dependentsDAO.findById(dependentsId);
		}
		
		map.put("employee", emp);
		map.put("dependentsList", dependentsList);
		map.put("context", new EmployeeDependentsContext(dependents, employeeContext));
		return map;
	}
	
	public Map<String, Object> addImmigrations(Integer employeeId, Integer immigrationId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(employeeId);
		EmployeeContext employeeContext = new EmployeeContext(emp);
		List<Immgration> immigrationsList = (List<Immgration>)immigrationDAO.execListNamedQuery("findImmigrationsByEmployee", new Object[]{emp});
		
		Immgration img = null;
		if(CommonUtil.validateParamWithZeroPosibility(immigrationId)){
			img = immigrationDAO.findById(immigrationId);
		}
		
		map.put("immigrationsList", immigrationsList);
		map.put("employee", emp);
		map.put("context", new EmployeeImmigrationsContext(img, employeeContext));
		return map;
	}
	
	public Map<String, Object> addJob(Integer employeeId, Integer jobId) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(employeeId);
		EmployeeContext employeeContext = new EmployeeContext(emp);
		List<Job> jobList = (List<Job>)jobDAO.execListNamedQuery("findJobByEmployee", new Object[]{emp});
		
		Job job = null;
		if(CommonUtil.validateParamWithZeroPosibility(jobId)){
			job = jobDAO.findById(jobId);
		}
		
		map.put("jobList", jobList);
		map.put("employee", emp);
		map.put("context", new EmployeeJobContext(job, employeeContext));
		return map;
	}
	
	public Map<String, Object> reportTo(Integer employeeId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee emp = employeeDAO.findById(employeeId);
		
		map.put("employee", emp);
		map.put("employeeList", employeeDAO.findAll());
		map.put("reportingMethodList", reportingMethodDAO.findAll());
		map.put("subordinatesList", employeeDAO.execList("from Employee e where e.employee = ?", new Object[]{emp}));
		return map;
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.CREATE_UPDATE, className = Employee.class)
	public Integer save(EmployeeContext context){
		Employee emp = context.getEntity();
		
		if(!CommonUtil.validateParam(emp)){
			emp = new Employee();
		}
		
		emp.setFirstName(context.getFirstName());
		emp.setMiddleName(context.getMiddleName());
		emp.setLastName(context.getLastName());
		emp.setEmployeeId(context.getEmployeeId());
		emp.setUsername(context.getUsername());
		emp.setPassword(context.getPassword());
		
		emp.setEmployeeId(context.getEmployeeId());
		emp.setOtherId(context.getOtherId());
		emp.setDriverLicenseNumber(context.getLicenseDriverNumber());
		emp.setLicenseExpiryDate(context.getLicenseExpiryDate());
		emp.setGender(Boolean.valueOf(context.getGender()));
		emp.setNationality(context.getNationality());
		emp.setDateOfBirth(context.getDateOfBirth());
		emp.setMaritalStatus(context.getMaritalStatus());
		
		employeeDAO.insertOrUpdate(emp);
		
		return emp.getId();
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.CREATE_UPDATE, className = ContactDetails.class)
	public void saveContactDetails(EmployeeContactDetailsContext context){
		ContactDetails cd = context.getEntity();
		
		if(!CommonUtil.validateParam(cd)){
			cd = new ContactDetails();
		}
		
		cd.setContactDetailsType(context.getContactDetailsType());
		cd.setEmployee(context.getEmployeeContext().getEntity());
		cd.setAddressStreet1(context.getAddressStreet1());
		cd.setAddressStreet2(context.getAddressStreet2());
		cd.setCity(context.getCity());
		cd.setStateProvince(context.getStateProvince());
		cd.setCountry(context.getCountry());
		cd.setHomeTelephone(context.getHomeTelephone());
		cd.setMobile(context.getMobile());
		cd.setWorkTelephone(context.getWorkTelephone());
		cd.setWorkEmail(context.getWorkEmail());
		cd.setOtherEmail(context.getOtherEmail());
		
		contactDetailsDAO.insertOrUpdate(cd);
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.CREATE_UPDATE, className = Dependents.class)
	public void saveDependents(EmployeeDependentsContext context){
		Dependents dep = context.getEntity();
		
		if(!CommonUtil.validateParam(dep)){
			dep = new Dependents();
		}
		
		dep.setEmployee(context.getEmployeeContext().getEntity());
		dep.setFirstName(context.getFirstName());
		dep.setMiddleName(context.getMiddleName());
		dep.setLastName(context.getLastName());
		dep.setDateOfBirth(context.getDateOfBirth());
		dep.setDependentsType(context.getDependentsType());
		
		dependentsDAO.insertOrUpdate(dep);
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.CREATE_UPDATE, className = Immgration.class)
	public void saveImmigrations(EmployeeImmigrationsContext context){
		Immgration img = context.getEntity();
		
		if(!CommonUtil.validateParam(img)){
			img = new Immgration();
		}
		
		img.setEmployee(context.getEmployeeContext().getEntity());
		img.setImmgirationType(context.getImmigrationType());
		img.setNumber(context.getNumber());
		img.setIssuedDate(context.getIssuedDate());
		img.setExpiryDate(context.getExpiryDate());
		img.setEligibilityStatus(context.getEligibilityStatus());
		img.setCountry(context.getCountry());
		img.setEligibilityReviewDate(context.getEligibilityReviewDate());
		img.setComments(context.getComments());
		
		immigrationDAO.insertOrUpdate(img);
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.CREATE_UPDATE, className = Job.class)
	public void saveJob(EmployeeJobContext context){
		Job job = context.getEntity();
		
		if(!CommonUtil.validateParam(job)){
			job = new Job();
		}
		
		job.setEmployee(context.getEmployeeContext().getEntity());
		job.setJobTitle(context.getJobTitle());
		job.setEmploymentStatus(context.getEmploymentStatus());
		job.setJobCategory(context.getJobCategory());
		job.setJoinDate(context.getJoinDate());
		job.setOrganizationUnitStructure(context.getOrganizationUnitStructure());
		job.setWorkLocation(context.getWorkLocation());
		job.setContractStartDate(context.getStartDate());
		job.setContractEndDate(context.getEndDate());
		job.setTerminationStatus(Boolean.FALSE);
		
		jobDAO.insertOrUpdate(job);
	}
	
	public int saveReportTo(){
		HttpServletRequest request = CommonUtil.getHttpRequest();
		Employee currentEmployee = employeeDAO.findById(Integer.parseInt(request.getParameter("employeeId")));
		Employee spvOrSub = employeeDAO.findById(Integer.parseInt(request.getParameter("employee")));
		ReportingMethod rm = reportingMethodDAO.findById(Integer.parseInt(request.getParameter("reportingMethod")));
		
		String relationship = request.getParameter("employeeRelation");
		if(relationship.equals("supervisor")){
			currentEmployee.setEmployee(spvOrSub);
			currentEmployee.setReportingMethod(rm);
			employeeDAO.update(currentEmployee);
		}else if(relationship.equals("subordinate")){
			spvOrSub.setEmployee(currentEmployee);
			spvOrSub.setReportingMethod(rm);
			employeeDAO.update(spvOrSub);
		}
				
		return currentEmployee.getId();
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.DELETE, className = ContactDetails.class)
	public void deleteContactDetails(Integer id){
		contactDetailsDAO.delete(contactDetailsDAO.findById(id));
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.DELETE, className = Dependents.class)
	public void deleteDependents(Integer id){
		dependentsDAO.delete(dependentsDAO.findById(id));
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.DELETE, className = Immgration.class)
	public void deleteImmigrations(Integer id){
		immigrationDAO.delete(immigrationDAO.findById(id));
	}
	
	@AuditTrails(actionType = AuditTrailsActionType.DELETE, className = Job.class)
	public void deleteJob(Integer id){
		jobDAO.delete(jobDAO.findById(id));
	}
}
