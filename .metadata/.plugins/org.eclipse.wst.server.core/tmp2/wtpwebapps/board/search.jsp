<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<body>
	<h1>비밀번호 찾기 페이지</h1>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="number" id="number"></td>
		</tr>
	</table>
	<input type="button" id="searchbtn" name="searchbtn" value="찾기"> &nbsp; &nbsp;
	<a href="login.jsp">로그인</a>
	<br>
	<br>
	<div id="result"></div>
</body>
<script>
	$("#searchbtn").on("click", function() {
		$.ajax({
			url: "search",
			type: "post",
			data: "id="+$("#id").val() + "&name="+$("#name").val() + "&number="+$("#number").val(),
			success: function(resData) {
				$("#result").html(resData);
			},
			error: function() {
				alert("error occur");
			}
		});
	});
</script>
</html>