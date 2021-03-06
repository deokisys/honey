<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="honey.Mgr_bean" import="java.util.ArrayList"%>
<jsp:useBean id="HC" class="honey.Mgr_bean" scope="session"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>허니::꿀통제작</title>
<link rel="stylesheet" href="/honey/comb/css/HoneyStyle.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function checkUrl() {
	var str1 = document.getElementById('inurl');
	
	if( str1.value.replace(/^\s*|\s*$/g,'') == "" ){
		alert("내용이 없습니다.");
	    return false;
	}
	
	return true;
}
</script>
</head>
<body>


	
	
<%
	if (HC.getHc_id() == 0) {
		session.setAttribute("mode", "create");
	}
	String mode = (String)session.getAttribute("mode");
	if (mode == null || !mode.equals("edit")) {
		mode = "create";
	}
%>




<div class="w3-display-topmiddle w3-center w3-card-8 w3-round-xlarge w3-sand w3-padding" style="margin: 150px 0px 50px 0px; width: 80%; max-width:1200px; min-width:400px; padding-bottom: 0%">

<!-- 제작 -->
<% if (!mode.equals("edit")) { %>
	<div class="w3-panel w3-text-black w3-orange" style="margin: 0px 0px 0px 0px; width: 100%; max-width:1200px; min-width:350p" >생성</div>
	<input type="button" class="w3-btn w3-text-black w3-hover-orange" style="background:rgba( 255, 179, 35, 100 )" value="꿀통 만들기" onclick="document.getElementById('HC_CREATE').style.display='block'">
<% } else {%>
<div class="w3-panel w3-text-black w3-orange" style="margin: 0px 0px 0px 0px; width: 100%; max-width:1200px; min-width:350p" >수정</div>
	<input type="button" class="w3-btn w3-text-black w3-hover-orange" style="background:rgba( 255, 179, 35, 100 )" value="꿀통 다듬기" onclick="document.getElementById('HC_CREATE').style.display='block'">
<%} %>
<div>
	<%
		Object result = session.getAttribute("result");
		if (result != null) { %>
		<br>
	<fieldset>
		<legend>결과 주소</legend>
		<textarea readonly name="result" rows="2" cols="100" onclick="this.select()"><%= (String)result %></textarea>
	</fieldset>
	<% } %>
</div>
<!-- 제작 끝 -->
<div class="w3-panel w3-text-black w3-orange" style="margin: 0px 0px 0px 0px; width: 100%; max-width:1200px; min-width:350px" >소스입력
<input type="button" class="w3-btn w3-text-black w3-hover-orange w3-middle" style="background:rgba( 255, 179, 35, 100 ); width:40px" value="?" onclick="document.getElementById('HC_GUIDE').style.display='block'">
</div>
<!-- 입력 -->
<div class="w3-panel">
<form name="url_form" action="/honey/Creator" method="post" onSubmit="return checkUrl()">		
			<input type="hidden" name="type" value="addUrl">
			<input type="hidden" name="mode" value=<%=mode%>>
			<input type="text" id="inurl" name="URL" class="w3-light-gray w3-input w3-padding-16 w3-border" placeholder="공유코드입력" style="height:38px"></li>
			<button type="submit" class="w3-btn w3-amber w3-padding">추가</button></li>
	</form>
</div>
<!-- 입력 끝 -->
<div class="w3-panel w3-text-black w3-orange" style="margin: 0px 0px 0px 0px; width: 100%; max-width:1200px; min-width:350px" >미리보기</div>
<!-- 표시 -->
<div class="w3-container w3-row" style="overflow:scroll;overflow-x:hidden;width:100%;height:400px">
		<%
		int i=0;
		ArrayList<String> list = HC.getURLs(); 
		for(String url : list) {
		%>
		<%=url%>
		<form name="del" action="/honey/Creator" method="post">
				<input type="hidden" name="type" value="delUrl">
				<input type="hidden" name="mode" value=<%=mode%>>
				<input type="hidden" name="index" value=<%=i++%>>
				<button class="w3-btn-block w3-red" style="width:590px;margin:0px 0px 20px 0px" type=submit>제거</button>
		</form>
		<%} %>
</div>
<!-- 표시 끝 -->
</div>


<!-- 제목과 비밀번호입력창 -->
<div id="HC_CREATE" class="w3-modal">
   <div class="w3-modal-content w3-card-8 w3-animate-zoom" style="max-width:600px">
    <div class="w3-center" src="/honey/comb/img/HoneyPattern.jpg"><br>
      <span onclick="document.getElementById('HC_CREATE').style.display='none'" class="w3-closebtn w3-hover-red w3-container w3-padding-8 w3-display-topright" title="Close Modal">×</span>
    </div>
    <!-- 로그인 폼 -->
    <form class="w3-container" name="url_form3" method="post" action="/honey/Creator">
      <div class="w3-section">
        <label><b>꿀통 제목</b></label>
        <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter title" name="hc_title" required>
        <label><b>꿀통 비밀번호</b></label>
        <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="hc_pwd" required>
        <input type="hidden" name="type" value="viewHC">
		<input type="hidden" name="mode" value=<%=mode%>>
        <button class="w3-btn-block w3-amber w3-section w3-padding" type="submit">확인</button>
      </div>
    </form>


  </div>
</div>
<!-- 제목과 비밀번호입력창 끝-->


<!-- 도움말 -->
<div id="HC_GUIDE" class="w3-modal">
   <div class="w3-modal-content w3-card-8 w3-animate-zoom" style="max-width:600px">
    <div class="w3-center" src="/honey/comb/img/HoneyPattern.jpg"><br>
      <span onclick="document.getElementById('HC_GUIDE').style.display='none'" class="w3-closebtn w3-hover-red w3-container w3-padding-8 w3-display-topright" title="Close Modal">×</span>
    </div>
    
      <div class="w3-section">
        <label><b><center>iframe 태그를 추가해 주십시오</center></b></label>
        	<img src="http://hcvideo.mooo.com:8081/honey/comb/img/help.PNG" style="max-width:600px">
        <button class="w3-btn-block w3-amber w3-section w3-padding" onclick="document.getElementById('HC_GUIDE').style.display='none'">확인</button>
      </div>

  </div>
</div>
<!-- 도움말 끝-->


<%if(session.getAttribute("member_id")==null){ %>
<%@ include file="/comb/Menubar_logout.jsp"%>
<%} else {%>
<%@ include file="/comb/Menubar_login.jsp"%>
<%} %>



<div style="margin: 1000px 0px 0px 0px; width:1000px; height: 200px"></div>
<script>makepan();</script>
</body>
</html>