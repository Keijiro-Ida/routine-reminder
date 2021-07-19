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
			reminder
	 	</div>
		<div id="main">
			<form id="login" action="/LoginServlet" method="post">
				<table>
				<tr>
				<th>メールアドレス:</th><th><input type="email" name="mail"></th>
				</tr>
				<tr>
				<th>パスワード:</th><th><input type="password" name="pass"></th>
				<tr>
				</table>
				<br>
				<input type="submit" class="btn_login" value="Login">
				<br>
				
			</form>
			<br>
			<a href="/SignUpServlet">新規登録</a>
		</div>
	</div>
	
</body>
</html>