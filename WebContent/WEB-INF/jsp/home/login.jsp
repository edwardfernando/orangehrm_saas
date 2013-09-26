<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/ui.datepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/crudutil.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lib/ui.all.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css-grid.css" />

</head>
<body>
	<form:form action="/OrangeHRM_SaaS/login/${tenantAlias}/check" method="post" modelAttribute="userContext">
		<form:errors path="*" cssClass="error"/>
		<table>
			<tr>
				<td>Username</td>
				<td>
					<input type="text" name="employee.username"/>
					<form:errors path="employee.username" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="employee.password"/>
					<form:errors path="employee.password" cssClass="error"/>
				</td>
			</tr>
			<%--
			<tr>
				<td>Tenant</td>
				<td>
					<select name="tenant">
					<c:forEach items="${tenants}" var="tenant">
						<option value="${tenant.tenantId}">${tenant.tenantName}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			 --%>
			<tr>
				<td colspan="2">
					<input type="submit" value="Login"/>
				</td>
			</tr>
		</table>		
	</form:form>
</body>
</html>