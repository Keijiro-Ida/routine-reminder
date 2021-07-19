<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<input type="button" class="btn_list" onclick="location.href='GetGoalListServlet'" value="≡">
			reminder
			<input type="submit" class="btn_right" form="create" value="Save" >
	    </div>
		<div id="main">
			<form id="create" action="/MainServlet" method="post">
			<textarea class="center" rows="3" cols="20" name="text"></textarea>
			<br><br>
			<p>Remind time:
			<input type="time" value="12:00" name="remindTime"></p>
			<br>
			</form>
			<a href="/LogoutServlet">Logout</a>
		</div>
	</div>
</body>
</html>