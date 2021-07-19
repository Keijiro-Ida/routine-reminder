<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reminder</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<body>
	<div id="pagebody">
		<div id="header">
			<input type="button" class="btn_left" onclick="location.href='/GetGoalListServlet'" value="Cancel">
			reminder
			<input type="submit" form="id" class="btn_right" value="Done" name="mybtn" onClick="return Check()">
	    </div>
		<div id="main">
			<form action="/UpdateUsersServlet" id="id" method="post">
				<table>
				<tr>
				<th>メールアドレス:</th>
				<th><input type="email" value="${users.mail}" name="mail"></th>
				</tr>
				<tr>
				<th>パスワード(8文字):</th>
				<th><input type="password" name="pass"></th>
				</tr>
				<tr>
				<th>パスワード(確認):</th>
				<th><input type="password" name="pass2"></th>
				</tr>
				</table>
			</form>
		</div>
	</div>
	
	
	
	<script>
		function Check(){
			var check = confirm('ユーザー情報を変更します。よろしいでしょうか？');
			if(check == true ) {
				return true;
			} else {
				return false;
			}
		}
	
	</script>
		
</body>
</html>