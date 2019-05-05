<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- views/include/menu.jsp -->
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>

<a href="${path}">HOME</a> |
<%-- <a href="${path}/member/address.do">도로명주소</a> | 
<a href="${path}/memo/list.do">메모장</a> | --%>
<a href="${path}/news/list.do">LIVE NEWS</a> |  
<a href="${path}/board/list.do">BOARD</a> | 
<a href="https://github.com/Gyeom">GitHUB</a> |  
<%-- <a href="${path}/chart/chart2.do">구글차트(db)</a> | --%>
<a href="https://developer-pi.tistory.com/">BLOG</a> |  
<%-- <a href="${path}/upload/uploadForm">업로드 테스트</a> | 
<a href="${path}/upload/uploadAjax">업로드(Ajax)</a> | 
<a href="${path}/shop/product/list.do">상품목록</a> |

<c:if test="${sessionScope.userid != null}">
	<a href="${path}/shop/cart/list.do">장바구니</a> | 
</c:if> --%>
<c:if test="${sessionScope.admin_userid != null}">
	<a href="${path}/chart/chart2.do">DashBoard</a> | 
</c:if>


<div style="text-align:right;">
	<c:choose>
		<c:when test="${sessionScope.userid == null }">
			<!-- 로그인하지 않은 상태 -->
			<a href="${path}/member/login.do">로그인</a> | 
			<a href="${path}/member/join.do">회원가입</a> | 
			<a href="${path}/admin/login.do">관리자 로그인</a>
		</c:when>
		<c:otherwise>
			<!-- 로그인한 상태 -->
			${sessionScope.name}님이 로그인중입니다.
			<a href="${path}/member/logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div> 
<hr>  















