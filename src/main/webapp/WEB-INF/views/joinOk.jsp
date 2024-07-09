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

<title>Join Ok</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

</head>
<body>
	<c:if test="${idCheckFlag != 0}">
		<script type="text/javascript">
			alert("중복된 아이디입니다.\n다시 확인해주세요.");
			history.go(-1);
		</script>
	</c:if>
	
	<c:if test="${nicknameCheckFlag != 0}">
		<script type="text/javascript">
			alert("중복된 닉네임입니다.\n다시 확인해주세요.");
			history.go(-1);
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
				<table border="0" cellspacing="0" cellpadding="15">
					<tr>
						<td align="center">
							<span class="content_text">
							${name }님 회원가입을 축하드립니다.<br>
							가입하신 닉네임(아이디)는 ${nickname }(${id })입니다.<br>
							로그인 하신 후 글을 작성하실 수 있습니다.
							</span>
						</td>
					</tr>
					
					<tr>
						<td></td>
					</tr>
					
					<tr>
						<th><input class="button" type="button" value="로그인" onclick="window.location.href='login'"></th>
					</tr>
					
				</table>
			</td>
		<tr>
		
			
	</table>
	</div>

	<%@ include file="include/footer.jsp" %>
	
	
</body>
</html>

