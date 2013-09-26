<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Add Supervisor / Subordinate</legend>
	<form:form action="${pageContext.request.contextPath}/pim/savereportto" method="post" modelAttribute="employee">
		<input type="hidden" value="${employee.id}" name="employeeId"/>
		<table>
			<tr>
				<td>
					<input type="radio" value="supervisor" id="supervisor" name="employeeRelation"/>
					<label for="supervisor">Supervisor</label>
					
					<input type="radio" value="subordinate" id="subordinate" name="employeeRelation"/>
					<label for="subordinate">Subordinate</label>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>
					Reporting Method
				</td>
				<td>
				<c:forEach items="${reportingMethodList}" var="rm">
					<input type="radio" value="${rm.id}" id="reportingMethod-${rm.id}" name="reportingMethod"/>
					<label for="reportingMethod-${rm.id}">${rm.name}</label>
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td>Employee</td>
				<td>
					<select name="employee">
						<c:forEach items="${employeeList}" var="emp">
						<option value="${emp.id}">${emp.firstName} ${emp.middleName} ${emp.lastName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="Save"/>
	</form:form>
</fieldset>


<fieldset>
	<legend>Job Hierarchy</legend>
	<table width="100%">
		<tr>
			<td>Supervisor</td>
			<td>Subordinates</td>
		</tr>
		<tr>
			<td valign="top">
				<c:if test="${!empty employee.employee}">
					<a href="<%=request.getContextPath()%>/pim/details/${employee.employee.id}"> 
					${employee.employee.firstName} ${employee.employee.middleName} ${employee.employee.lastName}
					</a>
				</c:if>
			</td>
			<td>
				<c:forEach items="${subordinatesList}" var="sub">
					&#x2605;
					<a href="<%=request.getContextPath()%>/pim/details/${sub.id}"> 
						${sub.firstName} ${sub.middleName} ${sub.lastName}
					</a>
					(${sub.reportingMethod.name}) <br/>
				</c:forEach>
			</td>
		</tr>
	</table>
	
</fieldset>