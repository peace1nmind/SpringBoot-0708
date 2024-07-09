<!-- 
[ 


-->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

<script type="text/javascript" src="/resources/js/login.js"></script>

</head>
<body onload="idCur()">

	<c:if test="${modifyFlag == 1 }">
		<script type="text/javascript">
			alert("회원정보가 수정되었습니다.\n다시 로그인해주세요.")
		</script>
	</c:if>
	
	<%@ include file="include/header.jsp" %>
	
	<div class="container" align="center">
	<table border="0" cellpadding="20" cellspacing="0">
		<tr>
			<td align="center">
				<span class="title_text01">DEVELOPER HANSOL'S PROFILE</span>
			</td>
		</tr>
		<tr>
			<td align="center">
				<span class="title_text02">I'm Hansol jung, a developer who wants a development job. Please call me back.</span>
			</td>
		</tr>
		
		<tr>
			<td align="center" class="content_box">
				<form action="loginOk" name="loginForm" method="post" onsubmit="return loginCheck()">
				<table border="0" cellspacing="0" cellpadding="15">
					<tr>
						<td class="content_item">
							<span class="content_text">아이디 </span> 
						</td>
						<td>
							<input class="input_box" type="text" name="id">
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">비밀번호 </span> 
						</td>
						<td>
							<input class="input_box" type="password" name="pw">
						</td>
					</tr>
					
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input class="button" type="submit" value="로그인">
							<input class="button" type="button" value="회원가입" onclick="window.location.href='join'">
						</td>
				</table>
				</form>
			</td>
		<tr>		
	</table>
	</div>

	<%@ include file="include/footer.jsp" %>
	
	
</body>
</html>

