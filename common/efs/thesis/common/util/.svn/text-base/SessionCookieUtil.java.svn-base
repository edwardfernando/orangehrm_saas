package efs.thesis.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import efs.thesis.common.pojo.TenantContext;
import efs.thesis.common.pojo.UserContext;
import efs.thesis.saas.model.L10n;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class SessionCookieUtil {

	public static void setSession(String constantName, Object object, int scope){
		RequestContextHolder.currentRequestAttributes().setAttribute(constantName, object, scope);
	}
	
	public static Object getAttribute(String constantName, int scope){
		return RequestContextHolder.currentRequestAttributes().getAttribute(constantName, scope);
	}
	
	public static L10n getDefaultLocale(){
		return (L10n) getAttribute(Constants.DEFAULT_LOCALE, RequestAttributes.SCOPE_GLOBAL_SESSION);
	}
	
	public static L10n getDefaultDateFormat(){
		return (L10n)getAttribute(Constants.DEFAULT_DATE_FORMAT, RequestAttributes.SCOPE_GLOBAL_SESSION);
	}
	
	public static TenantContext getTenantContext(){
		return (TenantContext)getAttribute(Constants.TENANT_CONTEXT_SESSION, RequestAttributes.SCOPE_GLOBAL_SESSION);
	}
	
	public static UserContext getLoggedUser(){
		return (UserContext)getAttribute(Constants.USER_SESSION_CONTEXT, RequestAttributes.SCOPE_GLOBAL_SESSION);
	}
	
	public static boolean isTenantContextCookieExists(HttpServletRequest httpRequest){
		boolean result = false;
		
		Cookie[] cookies = httpRequest.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(Constants.TENANT_CONTEXT_COOKIE)){
					result = true;
					break;
				}
			}
		}
		
		return result;
	}
	
	public static Cookie getTenantContextCookie(HttpServletRequest httpRequest){
		Cookie tenantCookie = null;
		
		Cookie[] cookies = httpRequest.getCookies();
		if(CommonUtil.validateParam(cookies)){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(Constants.TENANT_CONTEXT_COOKIE)){
					tenantCookie = cookie;
					break;
				}
			}			
		}
		
		return tenantCookie;
	}
}
