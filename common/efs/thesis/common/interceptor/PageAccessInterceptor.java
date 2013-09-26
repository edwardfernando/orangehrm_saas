package efs.thesis.common.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import efs.thesis.common.pojo.UserContext;
import efs.thesis.common.util.AnnotationScanner;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.Constants;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.saas.dao.AccessibleModuleDAO;
import efs.thesis.saas.dao.L10NDao;
import efs.thesis.saas.model.AccessibleModule;
import efs.thesis.saas.model.L10n;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class PageAccessInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private L10NDao dao;

	@Autowired
	private AccessibleModuleDAO accessibleModuleDAO;
	
	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String[] splitted = request.getServletPath().split("/");
		String module = splitted[1];
		String subModule = splitted.length > 2 ? splitted[2] : ""; /*handling /dwr */
		String url = new StringBuilder("/").append(module).append("/").append(subModule).toString();
		
		UserContext loggedUser = SessionCookieUtil.getLoggedUser();
		if(loggedUser == null && !module.equals("login") && !module.equals("logout")){
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "You're not authorized to open this page.");
			return false;
		}
		
		/*CHECK MODULE*/
		String nextURL = "";
		String prevURL = "";
		
		Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		
		AccessibleModule am = accessibleModuleDAO.getByUrl(url);
		if(!splitted[1].equals("crud") && !module.equals("login") && !module.equals("dwr") && !module.equals("locale") && !module.equals("logout")){
			if(CommonUtil.validateParam(am)){
				
				AccessibleModule nextAm = null;
				if(CommonUtil.validateParam(am.getNextSequenceId())){
					nextAm = accessibleModuleDAO.findById(Integer.valueOf(am.getNextSequenceId()));
				}
				
				AccessibleModule prevAm = null;
				if(CommonUtil.validateParam(am.getPrevSequenceId())){
					prevAm = accessibleModuleDAO.findById(Integer.valueOf(am.getPrevSequenceId()));
				}
				
				if(CommonUtil.validateParam(nextAm)){
					nextURL = request.getContextPath() + nextAm.getUrl() + "/" + pathVariables.get("employeeId"); 
				}
				
				if(CommonUtil.validateParam(prevAm)){
					prevURL = request.getContextPath() + prevAm.getUrl() + "/" + pathVariables.get("employeeId");
				}
				
				
				SessionCookieUtil.setSession(Constants.NEXT_URL, nextURL, RequestAttributes.SCOPE_REQUEST);
				SessionCookieUtil.setSession(Constants.PREVIOUS_URL, prevURL, RequestAttributes.SCOPE_GLOBAL_SESSION);
			}else{
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return false;
			}
		}
		/*CHECK MODULE*/
		
		/* SHOW PIM MENU? */
		List<String> pimSubModules = new ArrayList<String>();
		pimSubModules.add("details");
		pimSubModules.add("contactdetails");
		pimSubModules.add("dependents");
		pimSubModules.add("immigrations");
		pimSubModules.add("job");
		pimSubModules.add("reportto");
		pimSubModules.add("leaveSummary");
		pimSubModules.add("assignLeave");
		pimSubModules.add("leaveList");
		boolean showPimMenu = false;
		if(module.equals("pim") && pimSubModules.contains(subModule)){
			showPimMenu = true;
		}
		SessionCookieUtil.setSession("showPimMenu", showPimMenu, RequestAttributes.SCOPE_REQUEST);
		SessionCookieUtil.setSession("subModule", subModule, RequestAttributes.SCOPE_REQUEST);
		/* SHOW PIM MENU? */
		
		Map<String, Object> modulesMap = AnnotationScanner.instance().getMap();
		SessionCookieUtil.setSession(Constants.AVAILABLE_MODULES_CONTEXT, modulesMap, RequestAttributes.SCOPE_GLOBAL_SESSION);
		
		L10n defaultLocale = SessionCookieUtil.getDefaultLocale();
		if(!CommonUtil.validateParam(defaultLocale)){
			List<L10n> l10n = (List<L10n>) dao.execListNamedQuery("findL10NByTypeName", new Object[]{"Locale"});
			Map<Integer, L10n> localesMap = extractToMap(l10n);
			
			SessionCookieUtil.setSession(Constants.AVAILABLE_LOCALES, localesMap, RequestAttributes.SCOPE_GLOBAL_SESSION);
			SessionCookieUtil.setSession(Constants.DEFAULT_LOCALE, getDefaultLocale(l10n), RequestAttributes.SCOPE_GLOBAL_SESSION);
		}
		
		L10n defaultDateFormat = SessionCookieUtil.getDefaultDateFormat();
		if(!CommonUtil.validateParam(defaultDateFormat)){
			L10n dateFormat = (L10n)dao.execUniqueNamedQuery("findL10NByTypeNameAndDefault", new Object[]{"DateFormat"});
			SessionCookieUtil.setSession(Constants.DEFAULT_DATE_FORMAT, dateFormat, RequestAttributes.SCOPE_GLOBAL_SESSION);
		}
		
		return true;
	}
	
	private Map<Integer, L10n> extractToMap(List<L10n> l10n){
		Map<Integer, L10n> map = new HashMap<Integer, L10n>();
		
		for(L10n obj : l10n){
			map.put(obj.getId(), obj);
		}
		
		return map;
	}
	
	public L10n getDefaultLocale(List<L10n> l10n){
		for(L10n obj : l10n){
			if(obj.getIsDefault()){
				return obj;
			}
		}
		return l10n.get(1);
	}
}

