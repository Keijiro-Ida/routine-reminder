<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reminder</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	
	<div id="pagebody">
		<div id="header">
			reminder
	    </div>
		<div id="main">
			<c:out value="${errorMsg }" /><br>
			<br>
			<a href="/index.jsp" >TOP</a>
		</div>
	</div>
</body>
</html>