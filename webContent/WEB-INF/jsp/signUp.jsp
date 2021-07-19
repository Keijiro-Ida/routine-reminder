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
			<form action="/SignUpServlet" method="post">
				<table>
				<tr>
				<th>メールアドレス:</th><th><input type="email" name="mail"></th>
				</tr>
				<tr>
				<th>パスワード(8文字):</th><th><input type="password" name="pass"></th>
				<tr>
				<th>パスワード(確認):</th><th><input type="password" name="pass2"></th>
				</tr>
				</table>
				<br>
			<input type="submit" class="btn_sign" value="新規登録">
			<br>
			<br>
			<a href="/index.jsp" >Top</a>
			</form>
		</div>
	</div>
</body>
</html>