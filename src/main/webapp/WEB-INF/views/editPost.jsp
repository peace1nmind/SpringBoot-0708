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

<title>Edit Post</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

<script type="text/javascript" src="/resources/js/board.js"></script>

</head>
<body onload="titleCur()">
	
	<c:if test="${idCheckFlag == false }">
		<script type="text/javascript">
			alert("글 수정은 작성자만 가능합니다.");
			history.back();
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
				<form action="editPostOk" name="writeForm" method="post" onsubmit="return writeCheck()">
				<input type="hidden" name="boardnum" value="${bdto.boardnum }">
				<table border="0" cellspacing="0" cellpadding="15">
					
					<tr>
						<td class="content_item">
							<span class="content_text">닉네임 </span> 
						</td>
						<td>
							<input class="input_box" type="hidden" name="nickname" value="${bdto.nickname }">${bdto.nickname }
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">작성자 </span> 
						</td>
						<td>
							<input class="input_box" type="hidden" name="writer" value="${bdto.writer }">${bdto.writer }
						</td>
					</tr>
					
					
					<tr>
						<td class="content_item">
							<span class="content_text">제목 </span> 
						</td>
						<td>
							<input class="input_box02" type="text" name="title" value="${bdto.title }">
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">내용 </span> 
						</td>
						<td>
							<textarea rows="10" cols="40" name="content" value="${bdto.content }">${bdto.content }</textarea>
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">조회수 </span>
						</td>
						<td align="center">${bdto.hit }</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">작성일 </span>
						</td>
						<td align="center">${bdto.postdate }</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">최종 수정일 </span>
						</td>
						<td align="center">${bdto.editdate }</td>
					</tr>
					
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					
					<tr>
						<td>
						<td align="center">
							<input class="button" type="submit" value="수정 완료">
							<input class="button" type="button" value="취소" onclick="window.history.back()">
							<!--  
							<input class="button" type="button" value="글 삭제" onclick="window.location.href='deletePost?boardnum=${bdto.boardnum }'">
							-->
							<input class="button" type="button" value="글 목록" onclick="window.location.href='board'">
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

