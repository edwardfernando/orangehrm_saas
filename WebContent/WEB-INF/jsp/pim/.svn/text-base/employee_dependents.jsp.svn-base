<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Employee Dependents</legend>
	
	<form:form action="${pageContext.request.contextPath}/pim/savedependents" method="post" modelAttribute="context">
		<table>
			<tr>
				<td rowspan="2">Full Name</td>
				<td><input type="text" name="firstName" value="${context.firstName}"/></td>
				<td><input type="text" name="middleName" value="${context.middleName}"/></td>
				<td><input type="text" name="lastName" value="${context.lastName}"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>Middle Name</td>
				<td>Last Name</td>
			</tr>
			<tr>
				<td>Relationship</td>
				<td>
					<input type="hidden" id="dependentsType" name="dependentsType" value="${context.dependentsType.id}"/>
					<span id="dependentsType-span">${context.dependentsType.name}</span>
					<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/dependentsType?popup&target=dependentsType');">Select</a>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="text" size="7" name="dateOfBirth" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.dateOfBirth}" />" readonly/></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<input type="submit" value="Save"/>
	</form:form>
</fieldset>

<table border="1" width="100%">
	<tr>
		<td>#</td>
		<td>First Name</td>
		<td>MIddle Name</td>
		<td>Last Name</td>
		<td>Relation</td>
		<td>DoB</td>
	</tr>
<c:forEach items="${dependentsList}" var="dep">
	<tr>
		<td>
			[<a href="<%=request.getContextPath()%>/pim/dependents/${employee.id}/edit/${dep.id}">Edit</a>]
			[<a href="<%=request.getContextPath()%>/pim/dependents/${employee.id}/delete/${dep.id}">Delete</a>]
		</td>
		<td>${dep.firstName}</td>
		<td>${dep.middleName}</td>
		<td>${dep.lastName}</td>
		<td>${dep.dependentsType.name}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${dep.dateOfBirth}" /></td>
	</tr>
</c:forEach>
</table>