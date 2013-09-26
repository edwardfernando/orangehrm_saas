<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Employee Information Filter</legend>
	
	<form action="<%=request.getContextPath()%>/pim/employeelist" method="post">
	<table>
		<tr>
			<td>Employee First Name</td>
			<td>:</td>
			<td><input type="text" name="employeeName" value="${filterCriteria.employeeName}"/></td>
			<td>ID</td>
			<td>:</td>
			<td><input type="text" name="id" value="${filterCriteria.id}"/></td>
			<td>Employment Status</td>
			<td>:</td>
			<td>
				<input type="hidden" id="employmentStatus" name="employmentStatus" value="${filterCriteria.employmentStatus}"/>
				<span id="employmentStatus-span">${employmentStatus}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/employmentStatus?popup&target=employmentStatus');">Select</a>
			</td>
		</tr>
		<tr>
			<td>Supervisor First Name</td>
			<td>:</td>
			<td><input type="text" name="supervisorName" value="${filterCriteria.supervisorName}"/></td>
			<td>Job Title</td>
			<td>:</td>
			<td>
				<input type="hidden" id="jobTitle" name="jobTitle" value="${filterCriteria.jobTitle}"/>
				<span id="jobTitle-span">${jobTitle}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/jobTitle?popup&target=jobTitle');">Select</a>
			</td>
			<td>Sub Unit</td>
			<td>:</td>
			<td>
				<input type="hidden" id="subUnit" name="subUnit" value="${filterCriteria.subUnit}"/>
				<span id="subUnit-span">${subUnit}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/organizationUnitStructure?popup&target=subUnit');">Select</a>
			</td>
		</tr>
		<tr>
			<td>Show Complete Data</td>
			<td>:</td>
			<td>				
				<select name="showAll">
					<option value="true" <c:if test="${showAll}">selected="selected"</c:if>>Yes</option>
					<option value="false" <c:if test="${!showAll}">selected="selected"</c:if>>No</option>
				</select>
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<input type="submit" value="Search"/><input type="button" value="Reset" onclick="window.location='<%=request.getContextPath()%>/pim/employeelist'"/>
	</form>
</fieldset>

Employee Information

<table border="1" cellpadding="5" cellspacing="0"  width="100%">
	<tr>
		<td><input type="checkbox" name="selectAllCB"/></td>
		<td>ID</td>
		<td>First (& Middle) Name</td>
		<td>Last Name</td>
		<td>Job Title</td>
		<td>Employment Status</td>
		<td>Sub Unit</td>
		<td>Supervisor</td>
	</tr>
<c:forEach items="${employee_list}" var="emp">
	<tr>
		<td><input type="checkbox" name="${emp.id}-cb" value="${emp.id}"/></td>
		<td><a href="<%=request.getContextPath()%>/pim/details/${emp.id}">${emp.id}</a></td>
		<td><a href="<%=request.getContextPath()%>/pim/details/${emp.id}">${emp.firstName} ${emp.middleName}</a></td>
		<td><a href="<%=request.getContextPath()%>/pim/details/${emp.id}">${emp.lastName}</a></td>
		<td>${emp.jobTitle}</td>
		<td>${emp.employmentStatus}</td>
		<td>${emp.subUnit}</td>
		<td>${emp.supervisor}</td>
	</tr>
</c:forEach>