package efs.thesis.common.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class CommonUtil {

	public static synchronized String getValidTarget(String target){
		if(target == null || target.equals("")){
			target = "target";
		}
		return target;
	}
	
	public static synchronized Integer getValidPageIndex(String page){
		if(page == null || page.equals("")){
			page = "1";
		}
		
		return Integer.valueOf(page);
	}
	
	public static synchronized Integer getValidIntegerParam(String param){
		return (param != null && !param.equals("")) ? Integer.valueOf(param) : null;
	}
	
	public static synchronized Long getValidLongParam(String param){
		return (param != null && !param.equals("")) ? Long.valueOf(param) : null;
	}
	
	public static synchronized boolean validateParam(Date date){
		return date != null;
	}
	
	public static synchronized boolean validateParam(String param){
		return (param != null && !param.equals("") && !param.isEmpty());
	}
	
	public static synchronized boolean validateParam(Object param){
		return param != null;
	}
	
	public static synchronized boolean validateParamWithZeroPosibility(Object param) {
		return (param != null && !param.toString().equals("") && !param.toString().equals("0"));
	}
	
	public static synchronized boolean validateParamWithZeroPosibility(String param) {
		return (param != null && !param.equals("") && !param.equals("0"));
	}

	public static synchronized boolean validateParamWithZeroPosibility(Integer param) {
		return (param != null && !param.equals(Integer.valueOf(0)));
	}

	public static synchronized boolean validateParamWithZeroPosibility(Long param) {
		return (param != null && !param.equals(Long.valueOf(0)));
	}
	
	public static synchronized HttpServletRequest getHttpRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
