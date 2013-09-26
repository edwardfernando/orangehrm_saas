<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fieldset>
	<legend>Assign Leave</legend>
	
	<form:form action="${pageContext.request.contextPath}/leave/assign/save" modelAttribute="context" method="post">
	<form:errors path="*" cssClass="error"/>
	<table>

		<tr>
			<td>Assigned To</td>
			<td>
				<select name="assignedEmployee">
					<option value="${context.entity.id}">My Self - ${context.entity.firstName} ${context.entity.middleName} ${context.entity.lastName}</option>
					
					<c:if test="${!empty subordinatesList}">
						<c:forEach items="${subordinatesList}" var="emp">
						<c:if test="${context.entity.id != emp.id}">
							<option value="${emp.id}">${emp.firstName} ${emp.middleName} ${emp.lastName}</option>
						</c:if>
						</c:forEach>
					</c:if>
				</select>
			</td>
		</tr>

		<tr>
			<td>Leave Type</td>
			<td>
				<input type="hidden" id="leaveTypes" name="leaveTypes" value="${context.leaveTypes.id}"/>
				<span id="leaveTypes-span">${context.leaveTypes.name}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/leaveTypes?popup&target=leaveTypes');">Select</a>
			</td>
		</tr>
		<tr>
			<td>From Date</td>
			<td>
				<input type="text" size="7" name="fromDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.fromDate}" />" readonly/>
			</td>
		</tr>
		<tr>
			<td>To Date</td>
			<td>
				<input type="text" size="7" name="toDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.toDate}" />" readonly/>
			</td>
		</tr>
		<tr>
			<td>Comments</td>
			<td>
				<textarea name="comments"></textarea>
			</td>
		</tr>
	</table>
	<input type="submit" value="Save"/>
	</form:form>
</fieldset>