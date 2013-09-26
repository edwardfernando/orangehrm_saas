package efs.thesis.common.db.datasource;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;

import efs.thesis.common.pojo.TenantContext;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.Constants;
import efs.thesis.common.util.SessionCookieUtil;
import efs.thesis.saas.config.datasource.TenantDataSource;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class TenantFilter implements Filter {

	private TenantContext context;
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String[] servletPath = httpRequest.getServletPath().split("/");
		String tenantAlias = servletPath[2];	//must be 'login'
		String loginUrlString = servletPath[1];	//this should be gramedia/chevron/.,,

		Logger.getGlobal().info("Request from : " + ((HttpServletRequest)request).getServletPath());
		
		context = TenantDataSource.instance().getTenantContextByAlias(tenantAlias);
		if(!CommonUtil.validateParam(context)){
			httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND, "There's no " + tenantAlias + " registered.");
			return;
		}else{
			
			Logger.getGlobal().info("Setting Context for " + context);
			TenantContextHolder.set(tenantAlias);
			
			SessionCookieUtil.setSession(Constants.TENANT_CONTEXT_SESSION, context, RequestAttributes.SCOPE_GLOBAL_SESSION);
			
			
			next.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
}
