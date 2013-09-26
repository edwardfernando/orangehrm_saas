package efs.thesis.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import efs.thesis.common.mvc.form.CrudForm;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.validator.ValidatorUtil;
import efs.thesis.tools.service.CrudService;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Controller
@SessionAttributes(value={"modelAttribute","type"})
@RequestMapping("/crud")
public class CrudController {

	@Autowired
	private CrudService service;
	
	@RequestMapping("/{type}")
	public String index(@PathVariable("type")String type, ModelMap map) throws Exception{
		map.addAllAttributes(service.load(type));
		return "/tools/crud/index";
	}
	
	@RequestMapping("/{type}/add")
	public String add(@PathVariable("type")String type, ModelMap map) throws Exception{
		map.addAllAttributes(service.add(type));
		return "/tools/crud/form";
	}

	@RequestMapping("/{type}/edit/{id}")
	public String edit(@PathVariable("type")String type, @PathVariable("id")Integer id, ModelMap map) throws Exception{
		map.addAllAttributes(service.edit(type, id));
		return "/tools/crud/form";
	}
	
	@RequestMapping("/{type}/save")
	public String save(@PathVariable("type")String type, ModelMap map, @ModelAttribute("modelAttribute")CrudForm form, BindingResult result, SessionStatus status, RedirectAttributes redAtt) throws Exception{
		ValidatorUtil.instance().validate(form, result);
		
		if(!result.hasErrors()){
			service.save(type, form);
			status.setComplete();
			return "redirect:/crud/" + type;
		}
		
		return "/tools/crud/form";
	}
	
	@RequestMapping("/{type}/save/configuration")
	public String saveConfiguration(@PathVariable("type")String type, @ModelAttribute("modelAttribute")CrudForm form, RedirectAttributes redAtt) throws Exception{
		service.saveConfiguration(type, form);
		return "redirect:" + CommonUtil.getHttpRequest().getHeader("Referer"); 
	}
	
	@RequestMapping("/{type}/delete/{id}")
	public String delete(@PathVariable("type")String type, @PathVariable("id")Integer id) throws Exception{
		service.delete(type, id);
		return "redirect:/crud/" + type;
	}
	
}
