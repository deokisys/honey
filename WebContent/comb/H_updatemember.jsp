<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="honey.HoneyBean" %>
<jsp:useBean id="member" class="honey.HoneyBean" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>허니::나의정보수정</title>
<link rel="stylesheet" href="/honey/comb/css/HoneyStyle.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
function sendIt(){
	var str2 = document.getElementById('pwd');
	var str3 = document.getElementById('name');  		

	if( str2.value.search(/\W|\s/g) > -1 ){
	alert( '비밀번호에 특수문자 또는 공백을 입력할 수 없습니다.' );
	str.focus();
	exit;
	}
	if( str3.value.search(/[^(가-힣a-zA-Z0-9)]/) > -1 ){
	alert( '이름에 특수문자 또는 공백을 입력할 수 없습니다.' );
	str.focus();
	exit;
	}
	document.up.submit();
}


</script>
</head>
<body>
<div class="w3-display-topmiddle w3-card-8 w3-round-large w3-sand w3-padding-16" style="margin: 150px 0px 0px 0px; width: 1000px; height: 800px">
  <form name="up" method="post" action="/honey/HoneyControl"> 
  <ul class="w3-navbar w3-center w3-round-xxlarge w3-margin">
  	<li style="width:100%">
    	<ul class="w3-navbar w3-center">
    		<li class="w3-pale-yellow w3-padding-16" style="width:40%">
    			<b>아이디</b>
    		</li>
    		<li class="w3-white w3-padding-16" style="width:60%">
    			<b><%=member.getMember_id() %></b>
    		</li>
 	 	</ul>
  	</li>
  	<li style="width:100%">
    	<ul class="w3-navbar  w3-yellow w3-center">
    		<li class="w3-padding-16" style="width:40%">
            	<b>변경할 비밀번호</b>
            </li>
    		<li style="width:60%">
            	<input type="password" class="w3-input w3-white w3-padding-16" placeholder="New password"id="pwd" name="member_pwd1">
            </li>
  		</ul>
    </li>
  	<li style="width:100%">
    	<ul class="w3-navbar  w3-amber w3-center">
    		<li class="w3-padding-16" style="width:40%">
            	<b>변경할 비밀번호 확인</b>
            </li>
    		<li style="width:60%"><input type="password" class="w3-input w3-white w3-padding-16" placeholder="Reinput new password" name="member_pwd2">
            </li>
  		</ul>
    </li>
    <li style="width:100%">
    	<ul class="w3-navbar  w3-orange w3-center">
    		<li class="w3-padding-16" style="width:40%">
            	<b>닉네임</b>
            </li>
    		<li style="width:60%"><input type="text" class="w3-input w3-white w3-padding-16" id="name" name="member_name" value="<%=member.getMember_name() %>">
            </li>
  		</ul>
    </li>
  </ul>
  <input type="hidden" name="action" value="updatemember">
  <input class="w3-btn w3-center w3-round-jumbo w3-green w3-margin" style="width:90%" onclick="sendIt()" value="변경하기">
  </form>
</div> 
		<%if(session.getAttribute("member_id")==null){ %>
<%@ include file="Menubar_logout.jsp"%>
<%} else {%>
<%@ include file="Menubar_login.jsp"%>
<%} %>



</body>
</html>