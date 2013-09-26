<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<table border="1">
	<tr>
		<td>Emmployee</td>
		<td>Leave Type</td>
		<td>From</td>
		<td>To</td>
		<td>Leave Taken</td>
		<td>Action</td>
	</tr>

<c:forEach items="${employeeLeaveList}" var="leave">
	<tr>
		<td>${leave.employeeLeaves.employee.firstName} 
			${leave.employeeLeaves.employee.middleName} 
			${leave.employeeLeaves.employee.lastName}</td>
		<td>${leave.employeeLeaves.leaveTypes.name}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${leave.fromDate}" /></td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${leave.toDate}" /></td>
		<td>${leave.leaveTaken}</td>
		<td>
			<a href="<%=request.getContextPath()%>/leave/summary/${leave.employeeLeaves.employee.id}/details/${leave.employeeLeaves.id}">
			Approve/Reject
			</a>
		</td>
	</tr>
</c:forEach>
</table>