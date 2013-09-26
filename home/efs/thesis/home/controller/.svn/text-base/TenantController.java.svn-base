package efs.thesis.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import efs.thesis.common.pojo.UserContext;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.home.service.TenantService;
import efs.thesis.saas.config.datasource.TenantDataSource;
import efs.thesis.saas.model.Role;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Controller
@SessionAttributes("userContext")
public class TenantController {

	@Autowired
	private TenantService service;
	
	@RequestMapping("/login/{tenantAlias}")
	public String login(@PathVariable("tenantAlias")String tenantAlias, ModelMap map){
		map.addAllAttributes(service.login(tenantAlias));
		return "/home/login";
	}
	
	@RequestMapping(value = "/login/{tenantAlias}/check", method = RequestMethod.POST)
	public String checkLogin(@PathVariable("tenantAlias")String tenantAlias, ModelMap map, @ModelAttribute UserContext ctx, BindingResult result) throws Exception{
		service.validateForm(ctx, result);
		
		if(result.hasErrors()){
			return "/home/login";	
		}

		map.put("tenants", TenantDataSource.instance().getTenantContextMap());

		String redirectURL = "";
		UserContext loggedUser = SessionCookieUtil.getLoggedUser();
		Role role = loggedUser.getEmployee().getRole();
		
		if(role.getCode().equalsIgnoreCase("HRD") || role.getCode().equalsIgnoreCase("GM")){
			redirectURL = "/pim/employeelist";
		}else{
			redirectURL = "/pim/details/" + loggedUser.getEmployee().getId();
		}
		
		return "redirect:" + redirectURL;
	}
	
	@RequestMapping("/logout/{tenantAlias}")
	public String logout(){
		String tenantAlias = SessionCookieUtil.getTenantContext().getTenantAlias();
		
		HttpServletRequest request = CommonUtil.getHttpRequest();
		request.getSession().invalidate();
		return "redirect:/login/" + tenantAlias;
	}
}