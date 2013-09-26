<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Tenant : ${tenantContextSession.tenantName}

<br/>

<div id="wrapper">
	<c:if test="${user_session_context.employee.role.name == 'HRD'}">
	<div>
		<a href="<%=request.getContextPath()%>/pim/employeelist">
			Employee List
		</a>
	</div>
	</c:if>
	
<c:if test="${showPimMenu}">
	<div>
		<STRONG>${employee.firstName} ${employee.middleName} ${employee.lastName}</STRONG>
	</div>
	<div>	7
		<c:if test="${subModule == 'details'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/pim/details/${employee.id}">
			Employee Details
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'contactdetails'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/pim/contactdetails/${employee.id}">
			Contact Details
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'dependents'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/pim/dependents/${employee.id}">
			Dependents
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'immigrations'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/pim/immigrations/${employee.id}">
			Immigrations
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'job'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/pim/job/${employee.id}">
			Job
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'reportto'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/pim/reportto/${employee.id}">
			Report To
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'leaveList'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/leave/list">
			Leave List
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'leaveSummary'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/leave/summary/${employee.id}">
			Leave Summary
		</a>
	</div>
	<div>
		<c:if test="${subModule == 'assignLeave'}">&#x2605;</c:if>
		<a href="<%=request.getContextPath()%>/leave/assign/${employee.id}">
			Leave
		</a>
	</div>
</c:if>
	<div>
		<a href="<%=request.getContextPath()%>/logout/${tenantContextSession.tenantAlias}">
			Logout
		</a>
	</div>
</div>

<br/>

<c:if test="${!empty user_session_context.employee}">
<div align="right">
Logged in as : ${user_session_context.employee.firstName} ${user_session_context.employee.middleName} ${user_session_context.employee.lastName} 
<%--with approval ${user_session_context.approvalAccess.approvalLevel.name} --%>
</div>
</c:if>