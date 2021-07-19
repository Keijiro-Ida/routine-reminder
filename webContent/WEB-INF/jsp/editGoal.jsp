<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Goal,java.sql.Timestamp,java.time.LocalDateTime" %>
<% 	Goal goal = (Goal) session.getAttribute("goal");
	Timestamp time = goal.getRemindTime();
	LocalDateTime localDateTime = time.toLocalDateTime();
	String remindTime = localDateTime.toLocalTime().toString();
	Timestamp now = new Timestamp(System.currentTimeMillis());
%>
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
			<input type="button" class="btn_left" onClick="location.href='/GetGoalListServlet'" value="cancel">
			<input type="button" class="btn_right" value="delete" onclick="func1()">
			reminder
	    </div>
		<div id="main_editGoal">
			<p>Edit</p>
			<form action="/UpdateGoalServlet" method="post" id="id">
				<textarea class="center" rows="5" cols="20" name="text"><%= goal.getText()%></textarea>
				<br>
				<br>
					<p>remind time:<input type="time" value="<%= remindTime %>" name="remindTime"></p>
				<br>
				<input class="btn_update" type="submit" value="update" onClick="return Check()">
			</form>
		</div>
	</div>
	
	<script>
	
	function func1() {
		var check = confirm("削除します。よろしいでしょうか？");
		if(check == true) {
			window.location.href="/DeleteGoalServlet";
		} 
	}
	
	function Check() {
		var checked = confirm("更新します。よろしいでしょうか？");
			if(checked == true){
				return true;
			} else {
				return false;
			}
	}
	
	</script>
	
	
</body>
</html>