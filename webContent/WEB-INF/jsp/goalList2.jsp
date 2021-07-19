<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Goal,java.time.format.DateTimeFormatter,java.sql.Timestamp" %>
<% 	List<Goal> goalList = (List<Goal>) session.getAttribute("goalList");
	
	String[] goalTime = new String[goalList.size()];
	String[] remindTime = new String[goalList.size()];
	DateTimeFormatter dtm = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm");
	DateTimeFormatter dtm2 = DateTimeFormatter.ofPattern("HH:mm");

	for(int i = 0; i < goalList.size(); i++) {
		goalTime[i] = dtm.format(goalList.get(i).getGoalTime().toLocalDateTime());
		remindTime[i] = dtm2.format(goalList.get(i).getRemindTime().toLocalDateTime().toLocalTime());
	}
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
			<input type="button" class="btn_main" onclick="location.href='/MainServlet'" value="Main">
			reminder
			<input type="button" class="btn_right" onclick="location.href='/UpdateUsersServlet'" value="Setting">
	    </div>
		<div id="main_list">
			<% if(goalList.size() <= 10 ){ %>
				<% for(int i = 5; i < goalList.size(); i++) { %>
					<div id="goal">
						<form name=MyForm action="/EditGoalServlet" method="post">
							<p><%= goalTime[i] %> 
							<%= goalList.get(i).getText() %>
							<button class="btn_edit" type='submit' name='Edit<%= i %>' value='Edit<%= i %>'>Edit</button>
							</p>
							<p>remind time <%= remindTime[i] %></p>
						</form>
					</div>
				<% } %>
				
			<% }else {%>
				<% for(int i = 5; i < 10; i++) { %>
					<div id="goal">
						<form name=MyForm action="/EditGoalServlet" method="post">
							<p><%= goalTime[i] %>
							<%= goalList.get(i).getText() %>
							<button class="btn_edit" type='submit' name='Edit<%= i %>' value='Edit<%= i %>'>Edit</button>
							</p>
							<p>remind time <%= remindTime[i] %></p>
						</form>
					</div>
				<% } %>
			<% } %>
			<br>
			<div id="page">
			<a href="/GetGoalListServlet" >前のページへ</a>	
			</div>
		</div>	
	</div>
</body>