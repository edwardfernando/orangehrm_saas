<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/additionalFieldsDWR.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/jquery-ui.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/ui.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lib/ui.datepicker.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/crudutil.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lib/ui.all.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/css-grid.css" />

</head>
<body>
 --%>
<input type="hidden" id="default_date_format" name="default_date_format" value="${default_date_format.code}"/>
<input type="hidden" id="module_name" name="module_name" value="${type}"/>
<input type="hidden" id="model_id" name="model_id" value="${currentModel.id}"/>

<%--
IF USER PUNYA AKSES UNTUK UTAK ATIK TAMPILAN
 --%>
<input type="button" value="Save All Position" onclick="submit('${type}-form', '<%=request.getContextPath()%>/crud/${type}/save/configuration');"/>
<input type="button" value="Submit" onclick="submitWithAdditionalFields('${type}-form', '<%=request.getContextPath()%>/crud/${type}/save');"/>
<a href="<%=request.getContextPath()%>/crud/${type}">[Back]</a>

<form:form action="/OrangeHRM_SaaS/crud/${type}/save" modelAttribute="modelAttribute" name="${type}-form" id="${type}-form">

<div id="dragable-div">
<c:forEach items="${modelAttribute.attributes}" var="html">
	<c:if test="${html.value.allowInput}">
 	<div class="block draggable" style="${modelAttribute.attributes[html.value.name].style}" id="${html.value.alias}-div">
 		<label>${html.value.alias}</label>
		<c:choose>
			<c:when test="${html.value.type == 'TEXTAREA'}">
				<textarea id="${html.value.name}" name="attributes['${html.value.name}'].value">${modelAttribute.attributes[html.value.name].value}</textarea>	
			</c:when>
			<c:when test="${html.value.type == 'POPUP'}">
				<input type="hidden" id="${html.value.name}" name="attributes['${html.value.name}'].value" value="${modelAttribute.attributes[html.value.name].id}"/>
				<span id="${html.value.name}-span">${modelAttribute.attributes[html.value.name].value}</span>
				<a href="#" onclick="popup('<%=request.getContextPath()%>/crud/${html.value.name}?popup&target=${html.value.name}');">Select ${html.value.alias}</a>
			</c:when>
			<c:when test="${html.value.type == 'CHECKBOX'}">
				<c:choose>
					<c:when test="${modelAttribute.attributes[html.value.name].value}">
						<c:set var="checkBoxValue" value="true"/> 
					</c:when>
					<c:otherwise>
						<c:set var="checkBoxValue" value="false"/>
					</c:otherwise>
				</c:choose>
				
				<input type="checkbox" id="${html.value.name}" name="attributes['${html.value.name}'].value" 
				value="${checkBoxValue}" <c:if test="${modelAttribute.attributes[html.value.name].value}">checked</c:if> onclick="setFormElementValue(this, this.checked);"/>
			</c:when>
			<c:when test="${html.value.type == 'DATE'}">
				<input type="text" size="7" name="attributes['${html.value.name}'].value" id="${html.value.name}" value="${modelAttribute.attributes[html.value.name].value}" class="datepicker" readonly/>
			</c:when>
			<c:otherwise>
				<input type="${html.value.type}" id="${html.value.name}" name="attributes['${html.value.name}'].value" value="${modelAttribute.attributes[html.value.name].value}"/>	
			</c:otherwise>
		</c:choose>
		<input type="hidden" id="${html.value.alias}-position" name="${html.value.alias}-position" value="${modelAttribute.attributes[html.value.name].plainXYCoor}"/>
		<form:errors path="attributes['${html.value.name}'].value" cssClass="error"/>
	</div>		
	</c:if>
</c:forEach>
</div>
</form:form>


<form action="/OrangeHRM_SaaS/crud/${type}/additionalfields/save" name="additionalForm">
<c:forEach items="${additionalFields}" var="additional">
	<c:if test="${additional.isVisible}">
		<div class="block draggable" style="${additional.style}" id="${additional.alias}-div">
			<label>${additional.name}</label>
			<input type="${additional.type}" name="${additional.name}" value="${additional.value}" style="${additional.style}" <c:if test="${mode != 'edit'}">disabled</c:if>/>
			<input type="hidden" id="${additional.name}-position" name="${additional.name}-position" value="${additional.plainXYCoor}"/>
			<form:errors path="attributes['${html.value.name}'].value" cssClass="error"/>
		</div>
</c:if>
</c:forEach>
</form>

<%--
</html>
 --%>