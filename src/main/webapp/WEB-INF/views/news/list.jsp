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

Keyword &nbsp;&nbsp;  
<a href="${path}/news/list.do?keyword=AI">#AI</a> |  
<a href="${path}/news/list.do?keyword=BigData">#BigData</a> |  
<a href="${path}/news/list.do?keyword=Cloud">#Cloud</a> |  
<a href="${path}/news/list.do?keyword=SmartFactory">#SmartFactory</a> | 
<a href="${path}/news/list.do?keyword=AR">#AR</a> | 
<a href="${path}/news/list.do?keyword=VR">#VR</a> |
<a href="${path}/news/list.do?keyword=5G">#5G</a> |
<a href="${path}/news/list.do?keyword=BlockChain">#BlockChain</a> |
<a href="${path}/news/list.do?keyword=3D Printer">#3D Printer</a> |
<a href="${path}/news/list.do?keyword=Drone">#Drone</a> |

<div style="margin-left:30%;">
<h2 style="margin-left:18%;">실시간 뉴스 TOP 3</h2>

<table border="1" width="600px">
	<tr>
		<th>NO</th>
		<th>TITLE</th>
	</tr>
	<!-- forEach var="개별데이터" items="집합데이터" -->
<c:forEach var="row" items="${list}" varStatus="status">
	<tr>
	<td><h3 style="text-align:center; padding : 20px;">${status.count}</h3></td>
	<td>
	
	<a href="${path}/news/view.do?num=${status.count}&keyword=${keyword}">
	<h2 style="text-align:center;">${row.headline}</h2>
	<img class= ".img-responsive" src = ${row.image} style="display: block; margin: 20px auto; height: 250px; width:400px;"/>
	 </a> |  
	<br>
	</td>
	<%-- <td>${row.contents}</td> --%>
	</tr>
</c:forEach>	
</table>
</div>

</body>
</html>



















