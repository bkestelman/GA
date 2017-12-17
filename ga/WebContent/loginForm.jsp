<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="login.js"></script>
</head>
<form class="loginForm" action="javascript:void(0);">
	<input type="text" value="Username" id="username" /> <input
		type="password" value="Password" id="password" /> <a href="#"
		onclick="login();" id="login">Login</a> <input type="button"
		value="Create New Account" id="newAccount" onclick="newAcc();" />
	<div id="confirmDiv">
		<div>Confirm password:</div><div><input type="password" value="Password" id="confirm" /></div>
		<a href="#"
		onclick="register();">Register</a>
	</div>
	<div id="loginError" class="hidden">
	<p>Error logging in. Invalid username or password.</p>
	</div>
	<input type="submit" style="display: none;" onclick="login();" />
</form>