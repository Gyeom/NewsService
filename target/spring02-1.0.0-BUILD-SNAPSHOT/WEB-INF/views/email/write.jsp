<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>이메일에 파일 첨부하기</h2>
<form method="post" action="${path}/email/send.do">
이메일 주소 <br><input name="receiveMail"><br>
<!-- 제목 <br> <input name="subject"><br>
내용 <br> <textarea rows="5" cols="80" name="message"></textarea> -->
<br>
<input type="submit" value="전송">
</form>
<span style="color:red;">${message}</span>

</body>
</html>



















