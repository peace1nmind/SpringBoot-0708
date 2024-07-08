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
<link rel="stylesheet" href="/resources/css/board.css">

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
				<table border="0" cellspacing="0" cellpadding="15" width="90%">
					<tr>
						<th class="board_item" width="8%">번호</th>
						<th class="board_item" width="10%">아이디</th>
						<th class="board_item" width="10%">작성자</th>
						<th class="board_item" width="47%">제목</th>
						<th class="board_item" width="10%">조회수</th>
						<th class="board_item" width="15%">등록일</th>
					</tr>
					
					<tr align="center">
						<td class="board_content">1</td>
						<td class="board_content">tiger</td>
						<td class="board_content">홍길동</td>
						<td class="board_content">ㅎㅇ</td>
						<td class="board_content">0</td>
						<td class="board_content">24/07/08</td>
					</tr>
					
					<%-- 
					<c:forEach items="" var="">
					<tr align="center">
						<td class="board_content"></td>
						<td class="board_content"></td>
						<td class="board_content"></td>
						<td class="board_content"></td>
						<td class="board_content"></td>
						<td class="board_content"></td>
					</tr>
					</c:forEach>
					--%>
					
					<tr>
						<td colspan="6" align="right">
							<input class="button" type="button" value="글쓰기" onclick="window.location.href='write'">
						</td>
					</tr>
				</table>
			</td>
		</tr>		
	</table>
	</div>

	<%@ include file="include/footer.jsp" %>
	
	
</body>
</html>

