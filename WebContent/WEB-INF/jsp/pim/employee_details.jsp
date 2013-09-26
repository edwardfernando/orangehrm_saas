<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Personal Details</legend>
	<form:form action="${pageContext.request.contextPath}/pim/save" method="post" modelAttribute="context">
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
			<td>Employee ID</td>
			<td><input type="text" name="employeeId"  value="${context.employeeId}"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Other ID</td>
			<td><input type="text" name="otherId" value="${context.otherId}"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Driver License Number</td>
			<td><input type="text" name="licenseDriverNumber"  value="${context.licenseDriverNumber}"/></td>
			<td>License Expiry Date</td>
			<td><input type="text" size="7" name="licenseExpiryDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.licenseExpiryDate}" />" readonly/></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<input type="radio" name="gender" id="male" value="true" <c:if test="${context.gender == 'true'}">checked="checked"</c:if>/><label for="male">Male</label>
				<input type="radio" name="gender" id="female" value="false" <c:if test="${context.gender == 'false'}">checked="checked"</c:if>/><label for="female">Female</label>
			</td>
			<td>Marital Status</td>
			<td>
				<input type="hidden" id="maritalStatus" name="maritalStatus" value="${context.maritalStatus.id}"/>
				<span id="maritalStatus-span">${context.maritalStatus.name}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/maritalStatus?popup&target=maritalStatus');">Select</a>
			</td>
		</tr>
		<tr>
			<td>Nationality</td>
			<td>
				<input type="hidden" id="nationality" name="nationality" value="${context.nationality.id}"/>
				<span id="nationality-span">${context.nationality.name}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/nationality?popup&target=nationality');">Select</a>
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