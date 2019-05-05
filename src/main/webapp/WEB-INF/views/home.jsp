<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 세션을 사용하지 않는 옵션 -->
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<!-- 세션변수가 존재하면 
if( session.getAttribute("userid") != null )
-->
<c:if test="${sessionScope.userid != null }">
	<h2>
		${sessionScope.name}
		(${sessionScope.userid})님의 방문을 환영합니다.
	</h2>
</c:if>	
 <h3>안녕하세요! 'IT신기술 뉴스서비스 LIVE NEWS'입니다.</h3>
<img src="http://jewel1067.com/wp-content/uploads/news.jpg" style="width:100%; height:50%;">
<h4> 1. 이 서비스는 Crawling을 활용하여 실시간으로 해외뉴스를 제공합니다. </h4>
<h4> 2. '해시태그'를 통해 원하는 키워드 주제의 신기술 뉴스 서비스를 체험할 수 있습니다.</h4>
<h4> 3. '영어↔한글' 번역 기능을 제공합니다.</h4>
<h4> 4. '이메일 전송' 기능을 통해, 원하는 뉴스기사를 PDF파일 형식으로 송부할 수 있습니다.</h4>
<h4> 5. 관리자는 대시보드에서 제공하는 차트를 통해, '회원관리' 및 '키워드 검색 추이 현황'을 모니터링 할 수 있습니다.</h4>	
    


	<%-- <h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P> --%>
	<!-- 실제로 서비스되는 디렉토리(배포 디렉토리) -->
	<%//=application.getRealPath("/WEB-INF/views/images/") %>
</body>
</html>





