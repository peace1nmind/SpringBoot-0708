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

<title>Login Ok</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

</head>
<body>
	<c:if test="${loginCheckFlag != 1}">
		<script type="text/javascript">
			alert("아이디 또는 비밀번호가 잘못되었습니다.\n다시 확인해 주세요.");
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
							${mdto.name }님 로그인을 축하드립니다.<br>
							${mdto.name }님의 닉네임은 ${mdto.nickname }입니다.<br>
							가입일은 ${mdto.signupdate } 입니다.<br><br>
							<input class="button" type="button" value="게시판" onclick="window.location.href='board'">
							<input class="button" type="button" value="글쓰기" onclick="window.location.href='write'">
							</span>
						</td>
					</tr>
				</table>
				</form>
			</td>
		<tr>		
	</table>
	</div>

	<%@ include file="include/footer.jsp" %>
	
	
</body>
</html>

