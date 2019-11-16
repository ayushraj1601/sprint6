<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<form action="/RMSprint6/getname" method="post">
		Enter UCI <input type="text" name="uci" /><br />
		<input type="submit" value="WELCOME" />
	</form>
	<a href="additi">hello</a>
	<jsp:include page="/menu"/>

</body>
</html>
