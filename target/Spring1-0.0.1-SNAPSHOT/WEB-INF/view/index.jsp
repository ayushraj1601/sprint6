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
	<form action="" method="post">
		Enter Num1 <input type="number" name="num1" /><br /> Enter Num2 <input
			type="number" name="num2" /><br /> <input type="submit" value="ADD"
			formaction="bow/addition" /> <input type="submit" value="BAKCHODI"
			formaction="meow/addition1" />
	</form>

</body>
</html>
