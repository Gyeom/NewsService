<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>

<script>
$(function(){ 
	$("#btnPDF").click(function(){
		location.href="${path}/pdf/list.do?keyword=${keyword}&num=${num}";
	});
	
	$("#btnList").click(function(){
		location.href="${path}/news/list.do?keyword=${keyword}";
	});
	$("#convertKor").click(addKorConvert);
	function addKorConvert(e){
	e.preventDefault();
var text = {
				"data" : $("#beforeX").text()
		};
		
	$.ajax({
		type : "POST",
		url : "${path}/papago/PapagoAPI",
		data : text, //json을 보내는 방법
		success : function(data) { //서블렛을 통한 결과 값을 받을 수 있습니다.
			console.log(data);
			//alert(data);

			//string의 값을 object 형식으로 변환합니다.
			var resulut_obj = JSON.parse(data);
			
			//결과값을 textarea에 넣기 위해서
			$("#afterX").text(
					resulut_obj.message.result.translatedText);
		},
		error : function(e) {
			console.log(e);
		
		}
	}); 


	
	$("#convertEng").attr("type","button");
	$("#convertKor").attr("type","hidden");
		$("#before").css("display","none");
		$("#after").css("display","");
		
	}
	$("#convertEng").click(addEngConvert);
	function addEngConvert(e){
		$("#convertKor").attr("type","button");
	$("#convertEng").attr("type","hidden");
	$("#before").css("display","");
		$("#after").css("display","none");
	}
});



</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>

	<h2 style="text-align: center;">${news.headline}</h2>
	<img class=".img-responsive" src=${news.image
		} style="display: block; margin: 20px auto; height: 300px; width: 600px;" />
	<div style="margin-left:18%;'">
	
	 <article class="article">
              
                  <div class="article-header">
                      <div class="article-header-text">
                          <a href="/users/92/kimmunsu" class="article-author-name"><!-- {{writer.userId}} --></a>
                          <a href="/questions/413" class="article-header-time" title="퍼머링크">
                          <!--    {{formattedCreateDate}} -->
                              <i class="icon-link"></i>
                          </a>
                      </div>
                  </div>
                  <div class="article-doc" id="before" >
                <textArea id="beforeX" style="width: 1000px; height: 500px; font-size: 20px;">${news.contents}</textArea>
                </div>
                 <div class="article-doc" id="after"  style="display:none;">
              <textArea id="afterX" style="width: 1000px; height: 500px; font-size: 20px;">${news.contents}</textArea>
                </div>
                
              </article>
		
	</div>


</body>
<div style="margin-top: 1rem; text-align: center;">
	<div style="display: inline-block;">

		<input type="button" id="convertKor"
			class="btn btn-primary pull-center" value="한글로 번역하기" /> <input
			type="hidden" id="convertEng" class="btn btn-primary pull-center"
			value="영어로 번역하기" />
		
		<button type="button" id="btnPDF">PDF로 변환하기</button>
		<button type="button" id="btnList">목록가기</button>
	</div>

</div>

</html>



















