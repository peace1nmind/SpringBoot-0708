<!-- 
[ 


-->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Board</title>

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
						<th class="board_item" width="7%">번호</th>
						<th class="board_item" width="10%">닉네임</th>
						<th class="board_item" width="10%">작성자</th>
						<th class="board_item" width="38%">제목</th>
						<th class="board_item" width="9%">조회수</th>
						<th class="board_item" width="13%">등록일</th>
						<th class="board_item_end" width="13%">수정일</th>
					</tr>

					<c:forEach items="${blist }" var="bdto">
						<tr align="center">
							<td class="board_content">${bdto.boardnum }</td>
							<td class="board_content">${bdto.nickname }</td>
							<td class="board_content">${bdto.writer }</td>
							<td class="board_content">
								<div class="tooltip_b">
								<a class="board_content" href="content?boardnum=${bdto.boardnum}">
								<c:choose>
									<c:when test="${fn:length(bdto.title) > 45 }">
											<c:out value="${fn:substring(bdto.title, 0 , 42) }"></c:out>...
											<span class="tooltiptext_b">${bdto.title}</span>
									</c:when>
									<c:otherwise>
										${bdto.title}
									</c:otherwise>
								</c:choose>
								</a>
								</div>
							</td>
							<td class="board_content">${bdto.hit }</td>
							<td class="board_content">
								<div class="tooltip_s">
								<c:out value="${fn:substring(bdto.postdate, 0, 10)}"></c:out>
								<span class="tooltiptext_s">${bdto.postdate}</span>
								</div>
							</td>
							<td class="board_content_end">
								<div class="tooltip_s">
								<c:out value="${fn:substring(bdto.editdate, 0, 10)}"></c:out>
								<span class="tooltiptext_s">${bdto.editdate}</span>
								</div>
							</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="7" align="right">
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

