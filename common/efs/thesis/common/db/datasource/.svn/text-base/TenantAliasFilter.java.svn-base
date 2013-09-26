package efs.thesis.common.db.datasource;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import efs.thesis.common.pojo.TenantContext;
import efs.thesis.common.util.CommonUtil;
import efs.thesis.common.util.SessionCookieUtil;

public class TenantAliasFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
		TenantContext ctx = SessionCookieUtil.getTenantContext();
		if(CommonUtil.validateParam(ctx)){
			Logger.getGlobal().info("** Setting tenant alias to TenantContextHolder > " + ctx.getTenantAlias());
			TenantContextHolder.set(ctx.getTenantAlias());
		}
		
		next.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
