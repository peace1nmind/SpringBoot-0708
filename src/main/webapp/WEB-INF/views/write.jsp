<!-- 
[ 


-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Write</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

<script type="text/javascript" src="/resources/js/board.js"></script>

</head>
<body onload="titleCur()">
	
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
				<form action="writeOk" name="writeForm" method="post" onsubmit="return writeCheck()">
				<table border="0" cellspacing="0" cellpadding="15">
					
					<tr>
						<td class="content_item">
							<span class="content_text">닉네임 </span> 
						</td>
						<td class="content_text">
							<input class="input_box" type="hidden" name="nickname" value="${mdto.nickname }">${mdto.nickname }
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">이름 </span> 
						</td>
						<td class="content_text">
							<input class="input_box" type="hidden" name="writer" value="${mdto.name }">${mdto.name }
						</td>
					</tr>
					
					
					<tr>
						<td class="content_item">
							<span class="content_text">제목 </span> 
						</td>
						<td class="content_text">
							<input class="input_box02" type="text" name="title" oninput="limitText(this, 200)">
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">내용 </span> 
						</td>
						<td class="content_text">
							<textarea rows="10" cols="40" name="content" oninput="limitText(this, 500)"></textarea>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input class="button" type="submit" value="작성완료">
							<input class="button" type="button" value="취소" onclick="window.location.href='board'">
						</td>
					</tr>
				</table>
				</form>
			</td>
		</tr>		
	</table>
	</div>

	<%@ include file="include/footer.jsp" %>
	
	
</body>
</html>

