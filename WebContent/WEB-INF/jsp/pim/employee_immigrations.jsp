<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Employee Immigration</legend>
	<form:form action="${pageContext.request.contextPath}/pim/saveimmigrations" method="post" modelAttribute="context">
	<table>
		<tr>
			<td>Document</td>
			<td>
				<input type="hidden" id="immigrationType" name="immigrationType" value="${context.immigrationType.id}"/>
					<span id="immigrationType-span">${context.immigrationType.name}</span>
					<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/immgirationType?popup&target=immigrationType');">Select</a>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Number</td>
			<td><input type="text" name="number" value="${context.number}"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Issued Date</td>
			<td><input type="text" size="7" name="issuedDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.issuedDate}" />" readonly/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Expiry Date</td>
			<td><input type="text" size="7" name="expiryDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.expiryDate}" />" readonly/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Eligibility Status</td>
			<td><input type="text" name="eligibilityStatus" value="${context.eligibilityStatus}"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Issued By</td>
			<td>
				<input type="hidden" id="country" name="country" value="${context.country.id}"/>
					<span id="country-span">${context.country.name}</span>
					<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/country?popup&target=country');">Select</a>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Eligibility Review Date</td>
			<td><input type="text" size="7" name="eligibilityReviewDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.eligibilityReviewDate}" />" readonly/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Comments</td>
			<td><input type="text" size="7" name="comments" value="${context.comments}"/></td>
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
		<td>Document</td>
		<td>Number</td>
		<td>Issued Date</td>
		<td>Expiry Date</td>
		<td>Eligibility Status</td>
		<td>Issued By</td>
		<td>Eligbility Review Date</td>
		<td>Comments</td>
	</tr>
<c:forEach items="${immigrationsList}" var="img">
	<tr>
		<td>
			[<a href="<%=request.getContextPath()%>/pim/immigrations/${employee.id}/edit/${img.id}">Edit</a>]
			[<a href="<%=request.getContextPath()%>/pim/immigrations/${employee.id}/delete/${img.id}">Delete</a>]
		</td>
		<td>${img.immgirationType.name}</td>
		<td>${img.number}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${img.issuedDate}" /></td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${img.expiryDate}" /></td>
		<td>${img.eligibilityStatus}</td>
		<td>${img.country.name}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${img.eligibilityReviewDate}" /></td>
		<td>${img.comments}</td>
	</tr>
</c:forEach>	
</table>