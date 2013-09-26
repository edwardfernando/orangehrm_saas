/**
 * 
 */
package efs.thesis.pim.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import efs.thesis.common.factory.FilterCriteriaFactory;
import efs.thesis.common.pagination.criteria.FilterCriteria;
import efs.thesis.pim.pojo.EmployeeContactDetailsContext;
import efs.thesis.pim.pojo.EmployeeContext;
import efs.thesis.pim.pojo.EmployeeDependentsContext;
import efs.thesis.pim.pojo.EmployeeImmigrationsContext;
import efs.thesis.pim.pojo.EmployeeJobContext;
import efs.thesis.pim.service.EmployeeService;
import efs.thesis.saas.dao.impl.JobCategoryEditor;
import efs.thesis.saas.editor.ContactDetailsTypeEditor;
import efs.thesis.saas.editor.CountryEditor;
import efs.thesis.saas.editor.DateEditor;
import efs.thesis.saas.editor.DependentsTypeEditor;
import efs.thesis.saas.editor.EmployeeEditor;
import efs.thesis.saas.editor.EmploymentStatusEditor;
import efs.thesis.saas.editor.ImmigrationTypeEditor;
import efs.thesis.saas.editor.JobTitleEditor;
import efs.thesis.saas.editor.MaritalStatusEditor;
import efs.thesis.saas.editor.NationalityEditor;
import efs.thesis.saas.editor.OrganizationUnitStructureEditor;
import efs.thesis.saas.editor.ReportingMethodEditor;
import efs.thesis.saas.editor.WorkLocationEditor;
import efs.thesis.saas.filter.EmployeeListFilterCriteria;
import efs.thesis.saas.gridquery.EmployeeListGridQuery;
import efs.thesis.saas.model.ContactDetailsType;
import efs.thesis.saas.model.Country;
import efs.thesis.saas.model.DependentsType;
import efs.thesis.saas.model.Employee;
import efs.thesis.saas.model.EmploymentStatus;
import efs.thesis.saas.model.ImmgirationType;
import efs.thesis.saas.model.JobCategory;
import efs.thesis.saas.model.JobTitle;
import efs.thesis.saas.model.MaritalStatus;
import efs.thesis.saas.model.Nationality;
import efs.thesis.saas.model.OrganizationUnitStructure;
import efs.thesis.saas.model.ReportingMethod;
import efs.thesis.saas.model.WorkLocation;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Controller
@SessionAttributes("context")
@RequestMapping("/pim/")
public class EmployeeController {

	@Autowired
	private FilterCriteriaFactory filterCriteriaFactory;
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private DateEditor dateEditor;
	
	@Autowired
	private MaritalStatusEditor maritalStatusEditor;
	
	@Autowired
	private NationalityEditor nationalityEditor;
	
	@Autowired
	private CountryEditor countryEditor;
	
	@Autowired
	private ContactDetailsTypeEditor contactDetailsTypeEditor;
	
	@Autowired
	private DependentsTypeEditor dependentsTypeEditor;
	
	@Autowired
	private ImmigrationTypeEditor immigrationTypeEditor;
	
	@Autowired
	private JobTitleEditor jobTitleEditor;
	
	@Autowired
	private EmploymentStatusEditor employmentStatusEditor;
	
	@Autowired
	private JobCategoryEditor jobCategoryEditor;
	
	@Autowired
	private OrganizationUnitStructureEditor organizationUnitStructureEditor;
	
	@Autowired
	private WorkLocationEditor workLocationEditor;
	
	@Autowired
	private EmployeeEditor employeeEditor;
	
	@Autowired
	private ReportingMethodEditor reportingMethodEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request){
		binder.registerCustomEditor(Date.class, dateEditor);
		binder.registerCustomEditor(MaritalStatus.class, maritalStatusEditor);
		binder.registerCustomEditor(Nationality.class, nationalityEditor);
		binder.registerCustomEditor(Country.class, countryEditor);
		binder.registerCustomEditor(ContactDetailsType.class, contactDetailsTypeEditor);
		binder.registerCustomEditor(DependentsType.class, dependentsTypeEditor);
		binder.registerCustomEditor(ImmgirationType.class, immigrationTypeEditor);
		binder.registerCustomEditor(JobTitle.class, jobTitleEditor);
		binder.registerCustomEditor(EmploymentStatus.class, employmentStatusEditor);
		binder.registerCustomEditor(JobCategory.class, jobCategoryEditor);
		binder.registerCustomEditor(OrganizationUnitStructure.class, organizationUnitStructureEditor);
		binder.registerCustomEditor(WorkLocation.class, workLocationEditor);
		binder.registerCustomEditor(Employee.class, employeeEditor);
		binder.registerCustomEditor(ReportingMethod.class, reportingMethodEditor);
	}
	
	@RequestMapping("/employeelist")
	public String index(ModelMap map){
		FilterCriteria criteria = filterCriteriaFactory.create(EmployeeListFilterCriteria.class);
		map.addAllAttributes(service.load(criteria, EmployeeListGridQuery.class));
		return "/pim/employee_list";
	}
	
	@RequestMapping("/add")
	public String add(ModelMap map){
		map.addAllAttributes(service.add(0));
		return "/pim/employee_add";
	}
	
	@RequestMapping("/details/{employeeId}")
	public String addPersonalDetails(ModelMap map, 
			@PathVariable("employeeId")Integer id){
		map.addAllAttributes(service.add(id));
		return "/pim/employee_details";
	}
	
	@RequestMapping("/contactdetails/{employeeId}")
	public String addContactDetails(ModelMap map, 
			@PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.addContactDetails(employeeId, 0));
		return "/pim/employee_contact_details";
	}
	
	
	@RequestMapping("/contactdetails/{employeeId}/edit/{contactDetailsId}")
	public String editContactDetails(ModelMap map,
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("contactDetailsId")Integer contactDetailsId) throws Exception{
		map.addAllAttributes(service.addContactDetails(employeeId, contactDetailsId));
		return "/pim/employee_contact_details";
	}
	
	
	@RequestMapping("/dependents/{employeeId}")
	public String addDependents(ModelMap map, 
			@PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.addDependents(employeeId, 0));
		return "/pim/employee_dependents";
	}
	
	@RequestMapping("/dependents/{employeeId}/edit/{dependentsId}")
	public String editDependents(ModelMap map, 
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("dependentsId")Integer dependentsId) throws Exception{
		map.addAllAttributes(service.addDependents(employeeId, dependentsId));
		return "/pim/employee_dependents";
	}
	
	
	@RequestMapping("/immigrations/{employeeId}")
	public String addImmigration(ModelMap map, 
			@PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.addImmigrations(employeeId, 0));
		return "/pim/employee_immigrations";
	}
	
	@RequestMapping("/immigrations/{employeeId}/edit/{immigrationId}")
	public String editImmigration(ModelMap map, 
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("immigrationId")Integer immigrationId) throws Exception{
		map.addAllAttributes(service.addImmigrations(employeeId, immigrationId));
		return "/pim/employee_immigrations";
	}
	
	@RequestMapping("/job/{employeeId}")
	public String addJob(ModelMap map,
			@PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.addJob(employeeId, 0));
		return "/pim/employee_job";
	}
	
	@RequestMapping("/job/{employeeId}/edit/{jobId}")
	public String editJob(ModelMap map, 
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("jobId")Integer jobId) throws Exception{
		map.addAllAttributes(service.addJob(employeeId, jobId));
		return "/pim/employee_job";
	}
	
	@RequestMapping("/reportto/{employeeId}")
	public String reportTo(ModelMap map,
			@PathVariable("employeeId")Integer employeeId) throws Exception{
		map.addAllAttributes(service.reportTo(employeeId));
		return "/pim/employee_report_to";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute("context")EmployeeContext context){
		Integer newId =  service.save(context);
		return "redirect:/pim/details/" + newId;
	}
	
	@RequestMapping("/savecontactdetails")
	public String save(@ModelAttribute("context")EmployeeContactDetailsContext context){
		service.saveContactDetails(context);
		return "redirect:/pim/contactdetails/" + context.getEmployeeContext().getEntity().getId();
	}
	
	@RequestMapping("/savedependents")
	public String save(@ModelAttribute("context")EmployeeDependentsContext context){
		service.saveDependents(context);
		return "redirect:/pim/dependents/" + context.getEmployeeContext().getEntity().getId();
	}
	
	@RequestMapping("/saveimmigrations")
	public String save(@ModelAttribute("context")EmployeeImmigrationsContext context){
		service.saveImmigrations(context);
		return "redirect:/pim/immigrations/" + context.getEmployeeContext().getEntity().getId();
	}
	
	@RequestMapping("/savejob")
	public String save(@ModelAttribute("context")EmployeeJobContext context){
		service.saveJob(context);
		return "redirect:/pim/job/" + context.getEmployeeContext().getEntity().getId();
	}
	
	@RequestMapping("/savereportto")
	public String saveReportTo(){
		int employeeId = service.saveReportTo();
		return "redirect:/pim/reportto/" + employeeId;
	}
	
	@RequestMapping("/contactdetails/{employeeId}/delete/{contactDetailsId}")
	public String deleteContactDetails(
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("contactDetailsId")Integer contactDetailsId){
		service.deleteContactDetails(contactDetailsId);
		return "redirect:/pim/contactdetails/" + employeeId;
	}
	
	@RequestMapping("/dependents/{employeeId}/delete/{dependentsId}")
	public String deleteDependents(
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("dependentsId")Integer dependentsId){
		service.deleteDependents(dependentsId);
		return "redirect:/pim/dependents/" + employeeId;
	}
	
	@RequestMapping("/immigrations/{employeeId}/delete/{immigrationsId}")
	public String deleteImmigrations(
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("immigrationsId")Integer immigrationsId){
		service.deleteImmigrations(immigrationsId);
		return "redirect:/pim/immigrations/" + employeeId;
	}
	
	@RequestMapping("/job/{employeeId}/delete/{jobId}")
	public String deleteJob(
			@PathVariable("employeeId")Integer employeeId, 
			@PathVariable("jobId")Integer jobId){
		service.deleteJob(jobId);
		return "redirect:/pim/job/" + employeeId;
	}
}

