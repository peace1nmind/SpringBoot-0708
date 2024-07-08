<!-- 
[ 


-->


<%@ page import="com.peace1nmind.d0708.dto.PhoneDto" %>
<%@ page import="com.peace1nmind.d0708.dto.EmailDto" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Modify</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

<script type="text/javascript" src="/resources/js/join.js"></script>

</head>
<body>
	
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
				<form action="modifyOk" name="joinForm" method="post" onsubmit="return joinCheck()">
					<table border="0" cellspacing="0" cellpadding="15">
						<tr>
							<td class="content_item">
								<span class="content_text">아이디 </span> 
							</td>
							<td>
								<input class="input_box" type="text" name="id" value="${mdto.id }" readonly="readonly">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">비밀번호 </span> 
							</td>
							<td>
								<input class="input_box" type="password" name="pw" value="${mdto.pw }">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">비밀번호 확인 </span> 
							</td>
							<td>
								<input class="input_box" type="password" name="pwOk" value="${mdto.pw }">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">이름 </span> 
							</td>
							<td>
								<input class="input_box" type="text" name="name" value="${mdto.name }">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">닉네임 </span> 
							</td>
							<td>
								<input class="input_box" type="text" name="nickname" value="${mdto.nickname }">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">연락처 </span> 
							</td>
							<td>
								<select name="phone1" class="input_phone">
									<% 
										PhoneDto phone = (PhoneDto) request.getAttribute("phone"); 
										String phone1 = phone.getPhone1();
									%>
									<option value="010" <%= "010".equals(phone1) ? "selected" : "" %>>010</option>
									<option value="011" <%= "011".equals(phone1) ? "selected" : "" %>>011</option>
									<option value="016" <%= "016".equals(phone1) ? "selected" : "" %>>016</option>
									<option value="017" <%= "017".equals(phone1) ? "selected" : "" %>>017</option>
								</select>
								- <input class="input_phone" type="text" name="phone2" value="${phone.phone2 }">
								- <input class="input_phone" type="text" name="phone3" value="${phone.phone3 }">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">이메일 </span> 
							</td>
							<td>
								<input class="input_email" type="text" name="emailUser" value="${email.emailUser }">
								<select name="emailDomain" class="input_email ">
									<%
										EmailDto email = (EmailDto) request.getAttribute("email");
										String emailDomain = email.getEmailDomain();
									%>
									<option value="@google.com" <%= "@google.com".equals(emailDomain) ? "selected" : "" %>>@google.com</option>
									<option value="@naver.com" <%= "@naver.com".equals(emailDomain) ? "selected" : "" %>>@naver.com</option>
									<option value="@daum.net" <%= "@daum.com".equals(emailDomain) ? "selected" : "" %>>@daum.net</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input class="button" type="reset" value="초기화" onclick="idCur()">
								<input class="button" type="submit" value="수정완료">
								<input class="button" type="button" value="취소" onclick="window.location.history.go(-1)">
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

