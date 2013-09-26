package efs.thesis.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class CrudInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		return true;
	}
	
}
