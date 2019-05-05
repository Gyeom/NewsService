<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- views/member/login.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	$("#btnJoin").click(function(){
		var userid=$("#userid").val(); //태그의 value 속성값
		var passwd=$("#passwd").val();
		var passwd_check=$("#passwd_check").val();
		var name=$("#name").val();
		if(userid==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus(); //입력 포커스 이동
			return; //함수 종료
		}
		if(passwd==""){
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return;
		}
		if(passwd!=passwd_check){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
			$("#passwd_check").focus();
			return;
		}
		if(name==""){
			alert("이름을 입력하세요.")
			$("#name").focus();
			return;
		}
		//폼 데이터를 서버로 제출
		document.form1.action="${path}/member/join_check.do";
		document.form1.submit();
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>회원가입</h2>
<form name="form1" method="post">
<table border="1" width="400px">
	<tr>
		<td>아이디</td>
		<td><input name="userid" id="userid"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd" id="passwd"></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td><input type="password" name="passwd_check" id="passwd_check"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name="name" id="name"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input name="email" id="email"></td>
	</tr>
	
<tr>
		<td colspan="2" align="center">
			<input type="button" id="btnJoin" value="회원가입">

			<c:if test="${message == 'error' }">
				<div style="color:red;">
					이미 존재하는 아이디입니다.
				</div>				
			</c:if>
			
		</td>
	</tr>
</table>
</form>
</body>
</html>



















