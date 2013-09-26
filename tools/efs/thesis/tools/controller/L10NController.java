package efs.thesis.tools.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;

import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.Constants;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.saas.model.L10n;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

@Controller
@RequestMapping("/locale")
public class L10NController {

	@SuppressWarnings("unchecked")
	@RequestMapping("/set/{id}")
	public String setDefaultLocale(@PathVariable("id")Integer localeId){
		
		Map<Integer, L10n> localesMap = (Map<Integer, L10n>) SessionCookieUtil.getAttribute(Constants.AVAILABLE_LOCALES, RequestAttributes.SCOPE_GLOBAL_SESSION);
		L10n defaultLocale = localesMap.get(localeId);
		
		SessionCookieUtil.setSession(Constants.DEFAULT_LOCALE, defaultLocale, RequestAttributes.SCOPE_GLOBAL_SESSION);
		return "redirect:" + CommonUtil.getHttpRequest().getHeader("Referer"); 
	}
	
//	@RequestMapping("/dateformat/")
//	public String setDefaultDateFormat(){
//		return "";
//	}
//	
//	@RequestMapping("/dateformat/save")
//	public String saveDefaultDateFormat(@RequestParam("dateFormat")String dateFormat){
//		return "";
//	}
}
