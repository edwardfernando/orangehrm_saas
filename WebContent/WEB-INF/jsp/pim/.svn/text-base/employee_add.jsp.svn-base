<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fieldset>
	<legend>Add Employee</legend>
	
	<form:form action="${pageContext.request.contextPath}/pim/save" method="post" modelAttribute="context">
		<table>
			<tr>
				<td rowspan="2">Full Name</td>
				<td><input type="text" name="firstName"/></td>
				<td><input type="text" name="middleName"/></td>
				<td><input type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>Middle Name</td>
				<td>Last Name</td>
			</tr>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeId"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Photograph</td>
				<td><input type="file" name="photograph"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword"/></td>
			</tr>
		</table>
		<input type="submit" value="Save"/>	
	</form:form>
</fieldset>