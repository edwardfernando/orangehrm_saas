<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<fieldset>
	<legend>Contact Details</legend>
	
	<form:form action="${pageContext.request.contextPath}/pim/savecontactdetails" method="post" modelAttribute="context">
		<table>
			<tr>
				<td>Contact Details Type</td>
				<td>
					<input type="hidden" id="contactDetailsType" name="contactDetailsType" value="${context.contactDetailsType.id}"/>
					<span id="contactDetailsType-span">${context.contactDetailsType.name}</span>
					<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/contactDetailsType?popup&target=contactDetailsType');">Select</a>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Address Street 1</td>
				<td><input type="text" name="addressStreet1" value="${context.addressStreet1}"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Address Street 2</td>
				<td><input type="text" name="addressStreet2" value="${context.addressStreet2}"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" value="${context.city}"/></td>
				<td>State/Province</td>
				<td><input type="text" name="stateProvince" value="${context.stateProvince}"/></td>
			</tr>
			<tr>
				<td>Country</td>
				<td>
					<input type="hidden" id="country" name="country" value="${context.country.id}"/>
					<span id="country-span">${context.country.name}</span>
					<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/country?popup&target=country');">Select</a>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Home Telephone</td>
				<td><input type="text" name="homeTelephone" value="${context.homeTelephone}"/></td>
				<td>Mobile</td>
				<td><input type="text" name="mobile" value="${context.mobile}"/></td>
			</tr>
			<tr>
				<td>Work Email</td>
				<td><input type="text" name="workEmail" value="${context.workEmail}"/></td>
				<td>Other Email</td>
				<td><input type="text" name="otherEmail" value="${context.otherEmail}"/></td>
			</tr>
		</table>
		<input type="submit" value="Save"/>
	</form:form>
</fieldset>

<table border="1" width="100%">
	<tr>
		<td>#</td>
		<td>Type</td>
		<td>Address</td>
		<td>City</td>
		<td>State Province</td>
		<td>Country</td>
		<td>Home Telephon</td>
		<td>Mobile</td>
		<td>Work Email</td>
		<td>Other Email</td>
	</tr>
<c:forEach items="${contactDetailsList}" var="cd">
	<tr>
		<td>
			[<a href="<%=request.getContextPath()%>/pim/contactdetails/${employee.id}/edit/${cd.id}">Edit</a>]
			[<a href="<%=request.getContextPath()%>/pim/contactdetails/${employee.id}/delete/${cd.id}">Delete</a>]
		</td>
		<td>${cd.contactDetailsType.name}</td>
		<td>${cd.addressStreet1} - ${cd.addressStreet2}</td>
		<td>${cd.city}</td>
		<td>${cd.stateProvince}</td>
		<td>${cd.country}</td>
		<td>${cd.homeTelephone}</td>
		<td>${cd.mobile}</td>
		<td>${cd.workEmail}</td>
		<td>${cd.otherEmail}</td>
	</tr>
</c:forEach>	
</table>