<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set value="admin" var="userid"/>
<c:choose>
	<c:when test="${userid=='hong' }">
		홍길동님 환영합니다.
	</c:when>
	<c:when test="${userid=='lim' }">
		임꺽정님 환영합니다.
	</c:when>
	<c:when test="${userid=='admin' }">
		관리자님 환영합니다.
	</c:when>
	<c:otherwise>
		미등록 사용자입니다...
	</c:otherwise>
</c:choose>
</body>
</html>