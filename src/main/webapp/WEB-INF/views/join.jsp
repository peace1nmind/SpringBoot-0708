<!-- 
[ 


-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Join</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

<script type="text/javascript" src="/resources/js/join.js"></script>

</head>
<body onload="idCur()">
	
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
				<form action="joinOk" name="joinForm" method="post" onsubmit="return joinCheck()">
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
							<td class="content_item">
								<span class="content_text">비밀번호 확인 </span> 
							</td>
							<td>
								<input class="input_box" type="password" name="pwOk">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">이름 </span> 
							</td>
							<td>
								<input class="input_box" type="text" name="name">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">닉네임 </span> 
							</td>
							<td>
								<input class="input_box" type="text" name="nickname">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">연락처 </span> 
							</td>
							<td>
								<select name="phone1" class="input_phone">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
								</select>
								- <input class="input_phone" type="text" name="phone2">
								- <input class="input_phone" type="text" name="phone3">
							</td>
						</tr>
						
						<tr>
							<td class="content_item">
								<span class="content_text">이메일 </span> 
							</td>
							<td>
								<input class="input_email" type="text" name="emailUser">
								<select name="emailDomain" class="input_email ">
									<option value="@google.com">@google.com</option>
									<option value="@naver.com">@naver.com</option>
									<option value="@daum.net">@daum.net</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input class="button" type="reset" value="초기화" onclick="idCur()">
								<input class="button" type="submit" value="가입완료">
								<input class="button" type="button" value="취소" onclick="history.back()">
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

