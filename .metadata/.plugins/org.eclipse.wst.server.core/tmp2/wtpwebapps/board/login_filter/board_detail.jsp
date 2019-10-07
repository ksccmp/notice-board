<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, board.dto.Board, java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%
	Board board = (Board)session.getAttribute("board");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String regdate = format.format(board.getRegdate());
%>
<body>
	<h1>게시판 상세 페이지</h1>
	
	<form method="post" action="../board_update" id="detailform">
		<table border="1">
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
			
			<tr>
				<td><input type="text" name="num" id="num" value="${board.num }" readonly="readonly"></td>
				<td><input type="text" name="id" id="id" value="${board.id }" readonly="readonly"></td>
				<td><input type="text" name="title" id="title" value="${board.title }"></td>
				<td><input type="text" name="regdate" id="regdate" value="<%=regdate %>" readonly="readonly"></td>
			</tr>
			
			<tr>
				<th colspan="4">내용</th>
			</tr>
			
			<tr>
				<td colspan="4"><textarea style="width: 99%;" name="contents" id="contents">${board.contents }</textarea></td>
			</tr>
		</table>
		<c:if test="${board.id == sessionScope.IsLogin }">
			<input type="submit" value="변경하기" onclick="submitselect('update')">
			<input type="submit" value="삭제하기" onclick="submitselect('delete')">
		</c:if>
	</form>
</body>

<c:if test="${board.id != sessionScope.IsLogin }">
	<script>
		$("#title").attr("readonly", true);
		$("#contents").attr("readonly", true);
	</script>
</c:if>

<script>
	function submitselect(action) {
		if(action == "update") {
			$("#detailform").attr("action", "../board_update");
		} else if(action == "delete") {
			$("#detailform").attr("action", "../board_delete");
		}
	}
</script>
</html>