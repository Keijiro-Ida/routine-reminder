<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<c:choose>
				<c:when test="${users != null}">
					<p>ログインできました。</p>
					<p>メールアドレス:<c:out value="${users.mail}" /></p>
					<br>
					<a href="/MainServlet">Main</a>
				
				</c:when>
				<c:otherwise>
					<p>ログインできませんでした。</p><br>
					<a href="/index.jsp">Top</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>