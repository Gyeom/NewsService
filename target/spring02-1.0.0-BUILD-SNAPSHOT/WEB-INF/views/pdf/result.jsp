<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>

$(function(){
	$("#back").click(function(){
		location.href="${path}/news/view.do?num=${num}&keyword=${keyword}";
	});
	$("#email").click(function(){
		location.href="${path}/email/write.do";
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>${message}</h2>
<button id="back">돌아가기</button>
<button id="email">이메일로 첨부하기</button>
</body>
</html>



















