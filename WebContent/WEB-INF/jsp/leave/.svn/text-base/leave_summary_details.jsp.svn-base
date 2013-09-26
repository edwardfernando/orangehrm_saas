<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

Leave Summary Details : ${employeeLeaves.leaveTypes.name} for ${employee.firstName} ${employee.middleName} ${employee.lastName}
<table border="1">
	<tr>
		<td>Leave Type</td>
		<td>From</td>
		<td>To</td>
		<td>Leave Taken</td>
		<td>Status</td>
		<td>Approval History</td>
		<td>Action</td>
	</tr>

<c:if test="${empty empLeavesHistory}">
	<tr>
		<td colspan="7">
			No History
		</td>
	</tr>
</c:if>
<c:if test="${!empty empLeavesHistory}">
	<c:forEach items="${leaveSummaryDetail}" var="leave">
	<tr>
		<td>${leave.leaveTypes.name}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${leave.from}" /></td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${leave.to}" /></td>
		<td align="center">${leave.leaveTake}</td>
		<td>
			<c:choose> 
					<c:when test="${leave.isApproved}">
					Approved
					</c:when>
					<c:otherwise>
					Not Approved
					</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:forEach items="${leave.leaveApprovalHistory}" var="approvalHistory">
				${approvalHistory.key} -
				<c:choose> 
					<c:when test="${empty approvalHistory.value}">
						N.A
					</c:when>
					<c:otherwise>
						<fmt:formatDate pattern="dd/MM/yyyy" value="${approvalHistory.value.approval.date}" /> : ${approvalHistory.value.approval.approvalStatus.name}
					</c:otherwise>
				</c:choose>
				<br/>
			</c:forEach>
		</td>
		<td>
			<form action="<%=request.getContextPath()%>/leave/approve/${employee.id}/leave/${leave.entity.employeeLeaves.id}/${leave.entity.id}" method="post">
			<select name="approvalStatus" <c:if test="${!leave.loggedUserAbleToApprove}">disabled="disabled"</c:if>>
			<c:forEach items="${approvalStatusList}" var="approvalStatus">
				<option value="${approvalStatus.id}">${approvalStatus.name}</option>
			</c:forEach>
			</select>
			<input type="submit" value="Save" <c:if test="${!leave.loggedUserAbleToApprove}">disabled="disabled"</c:if>/>
			</form>
		</td>
	</tr>
	</c:forEach>
</c:if>

</table>