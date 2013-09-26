<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
	<legend>Job</legend>
	<form:form action="${pageContext.request.contextPath}/pim/savejob" method="post" modelAttribute="context">
		<table>
			<tr>
				<td>Job Title</td>
				<td>
					<input type="hidden" id="jobTitle" name="jobTitle" value="${context.jobTitle.id}"/>
						<span id="jobTitle-span">${context.jobTitle.name}</span>
						<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/jobTitle?popup&target=jobTitle');">Select</a>
				</td>
				<td>Employment Status</td>
				<td>
					<input type="hidden" id="employmentStatus" name="employmentStatus" value="${context.employmentStatus.id}"/>
						<span id="employmentStatus-span">${context.employmentStatus.name}</span>
						<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/employmentStatus?popup&target=employmentStatus');">Select</a>
				</td>
			</tr>
			<tr>
				<td>Job Category</td>
				<td>
					<input type="hidden" id="jobCategory" name="jobCategory" value="${context.jobCategory.id}"/>
						<span id="jobCategory-span">${context.jobCategory.name}</span>
						<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/jobCategory?popup&target=jobCategory');">Select</a>
				</td>
				<td>Joined Date</td>
				<td><input type="text" size="7" name="joinDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.joinDate}" />" readonly/></td>
			</tr>
			<tr>
				<td>Sub Unit</td>
				<td>
					<input type="hidden" id="organizationUnitStructure" name="organizationUnitStructure" value="${context.organizationUnitStructure.id}"/>
						<span id="organizationUnitStructure-span">${context.organizationUnitStructure.name}</span>
						<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/organizationUnitStructure?popup&target=organizationUnitStructure');">Select</a>
				</td>
				<td>Location</td>
				<td>
					<input type="hidden" id="workLocation" name="workLocation" value="${context.workLocation.id}"/>
						<span id="workLocation-span">${context.workLocation.address}</span>
						<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/workLocation?popup&target=workLocation');">Select</a>
				</td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><input type="text" size="7" name="startDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.startDate}" />" readonly/></td>
				<td>End Date</td>
				<td><input type="text" size="7" name="endDate" class="datepicker" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${context.endDate}" />" readonly/></td>
			</tr>
		</table>
		<input type="submit" value="Save"/>	
	</form:form>
</fieldset>

<table border="1" width="100%">
	<tr>
		<td>#</td>
		<td>Job Title</td>
		<td>Employment Status</td>
		<td>Job Category</td>
		<td>Joined Date</td>
		<td>Sub Unit</td>
		<td>Location</td>
		<td>Start Date</td>
		<td>End Date</td>
	</tr>
<c:forEach items="${jobList}" var="job">
	<tr>
		<td>
			[<a href="<%=request.getContextPath()%>/pim/job/${employee.id}/edit/${job.id}">Edit</a>]
			[<a href="<%=request.getContextPath()%>/pim/job/${employee.id}/delete/${job.id}">Delete</a>]
		</td>
		<td>${job.jobTitle.name}</td>
		<td>${job.employmentStatus.name}</td>
		<td>${job.jobCategory.name}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${job.joinDate}" /></td>
		<td>${job.organizationUnitStructure.name}</td>
		<td>${job.workLocation.address}</td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${job.contractStartDate}" /></td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${job.contractEndDate}" /></td>
	</tr>
</c:forEach>	
</table>