<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Leave Summary</legend>
	
	<table width="100%" border="!">
		<tr>
			<td>Employee Name</td>
			<td>Leave Type</td>
			<td>Leave Entitled (Days)</td>
			<%--
			<td>Leave Scheduled (Days)</td>
			 --%>
			<td>Leave Taken (Days)</td>
			<td>Leave Balance (Days)</td>
		</tr>
	<c:forEach items="${leavesList}" var="leave">
		<tr>
			<td>${leave.employee.firstName} ${leave.employee.middleName} ${leave.employee.lastName}</td>
			<td>${leave.leaveTypes.name}</td>
			<td>
				<a href="<%=request.getContextPath()%>/leave/summary/${employee.id}/details/${leave.employeeLeaves.id}">
				${leave.employeeLeaves.leaveAllocation}
				</a>
			</td>
			<td></td>
			<td></td>
		</tr>
	</c:forEach>
	</table>
</fieldset>