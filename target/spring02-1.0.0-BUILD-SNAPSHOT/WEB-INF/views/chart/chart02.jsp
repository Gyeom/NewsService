<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- views/chart/chart02.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<%-- <%@ include file="../include/session_check.jsp" %> --%>
<script type="text/javascript" 
src="https://www.google.com/jsapi"></script>

<script>
	var param="regdate_list.do";
	var value="회원관리 (Line Chart)";
	function chartChange(e){
		/* alert(e.value); */
		value=e.value;
		if(e.value=="회원관리 (Line Chart)"){
			param="regdate_list.do";
		}else{
			param="keyword_list.do";
		}
		drawChart();
	}
	
	
	//구글 차트 라이브러리 로딩
	google.load("visualization","1", {
		"packages":["corechart"]
	});
	/* //라이브러리 로딩이 완료되면 drawChart 함수 호출 */
	google.setOnLoadCallback(drawChart);
	function drawChart(){
		var jsonData=$.ajax({
			url: "${path}/chart/"+param,
			dataType: "json", 
			async: false
		}).responseText;
		 var data = new google.visualization.DataTable();
		 
		 if(value=="회원관리 (Line Chart)"){
			    data.addColumn('date', '등록일');
		        data.addColumn('number', '신규회원');
			var obj = JSON.parse(jsonData);
			for( let i=0; i<obj.length; i++){
				data.addRow([new Date(obj[i].YYYY,obj[i].MM-1,obj[i].dd),obj[i].value]);
			}
		        var options = {
		          title: '신규회원 수 추이',
		          width: 1500,
		          height: 700,
		          hAxis: {
		            format: 'yyyy-MM-dd',		
		          },
		          vAxis: {
		            minValue: 0
		          }
		        };

		        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
		        chart.draw(data, options);

		 }else {
			 var jsonData=$.ajax({
					url: "${path}/chart/"+param,
					dataType: "json", 
					async: false
				}).responseText;
				 var data = new google.visualization.DataTable();
				 
					    data.addColumn('string', '키워드');
				        data.addColumn('number', '조회수');
				        /* alert(jsonData); */
					var obj = JSON.parse(jsonData);
					for( let i=0; i<obj.length; i++){
						data.addRow([obj[i].keyword,obj[i].cnt]);
					}
				        var options = {
				          title: '키워드 조회수 추이',
				          width: 1500,
				          height: 700,
				          vAxis: {
				            minValue: 0
				          }
				        };
			 if(value=="키워드 검색현황 (PI Chart)"){
				  var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
			        chart.draw(data, options);
			 }else{
				  var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
			        chart.draw(data, options);
		 }
	        
	}
	}
</script></head>
<body>
<%@ include file="../include/menu.jsp" %>

<div style="margin-left:87%;">
<select name="chart" id="chart" onchange="chartChange(this)" style="height:30px;">
<option>회원관리 (Line Chart)</option>
<option>키워드 검색현황 (PI Chart)</option>
<option>키워드 검색현황 (Bar Chart)</option>
</select>
</div>

<!-- 차트를 출력할 영역  -->
<div id="chart_div"></div>

</body>
</html>



















