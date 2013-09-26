<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
		
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<title><tiles:insertAttribute name="title"/></title>

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

<style type="text/css">
	body{
		font-family: verdana,arial,sans-serif; 
		font-size:11px; 
		color:#333333;
	}
</style>        
</head>
<body>
	<input type="hidden" id="default_date_format" name="default_date_format" value="${default_date_format.code}"/>
	<div id="header">
	<tiles:insertAttribute name="header"/>
	</div>
	
	<div id="body">
	<tiles:insertAttribute name="body"/>
	</div>
	
	<div id="footer">
	<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>