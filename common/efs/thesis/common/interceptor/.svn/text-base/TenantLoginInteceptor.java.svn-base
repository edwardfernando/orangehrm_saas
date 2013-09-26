package efs.thesis.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TenantLoginInteceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		/*Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		String tenantAlias = "";
		for(Map.Entry<String, String> entry : pathVariables.entrySet()){
			tenantAlias = entry.getValue();
			break;
		}
		
		Tenants tenant = TenantDataSource.instance().getTenantByAlias(tenantAlias);
		if(!CommonUtil.validateParam(tenant)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}else{
			TenantContext ctx = SessionCookieUtil.getTenantContext();
			if(!CommonUtil.validateParam(ctx)){
				ctx = TenantDataSource.instance().getTenantContextById(tenant.getId());
				SessionCookieUtil.setSession(Constants.TENANT_CONTEXT_SESSION, ctx, RequestAttributes.SCOPE_GLOBAL_SESSION);
			}
		}*/
		
		return true;
	}
	
}
