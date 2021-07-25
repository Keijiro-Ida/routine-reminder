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
			<h3>習慣リマインダー</h3>
			<form id="login" action="/LoginServlet" method="post">
				<table>
				<tr>
				<th>メールアドレス:</th><th><input type="email" name="mail"></th>
				</tr>
				<tr>
				<th>パスワード:</th><th><input type="password" name="pass"></th>
				<tr>
				</table>
				<input type="submit" class="btn_login" value="Login">
			</form>
			<p>テストユーザー: abcdef@aaa.co.jp</p>
			<p>パスワード: 11223344</p>
			<p>習慣形成、目標確認、学習記憶など</p>
			<p>登録した内容を、設定した時間に</p>
			<p>毎日リマインドメールを送るアプリです。</p>
			<a href="/SignUpServlet">新規登録</a>
		</div>
	</div>
	
</body>
</html>