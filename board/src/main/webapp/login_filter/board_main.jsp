<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 페이지</h1>
	<form method="post" action="/board/login_filter/board_write.jsp">
		<input type="submit" value="작성하기"> <br>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		
		<c:forEach items="${boards }" var="board">
			<tr>
				<td>${board.num }</td>
				<td>${board.id }</td>
				<td>${board.title }</td>
				<td>${board.regdate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach items="${pageStartList }" var="pageStart" varStatus="status">
		<a href="board_main?start=${pageStart }">${status.index+1 }</a>
	</c:forEach>
	
</body>
</html>