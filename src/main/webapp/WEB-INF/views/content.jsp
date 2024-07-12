<!-- 
[ 


-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Content</title>

<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/content.css">

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
				<form action="editPost" name="writeForm" method="post">
				<input type="hidden" value="${bdto.boardnum }" name="boardnum">
				<table border="0" cellspacing="0" cellpadding="15">
				
					<tr>
						<td class="content_item">
							<span class="content_text">닉네임 </span> 
						</td>
						<td class="content_text">
							<input class="input_box" type="hidden" name="nickname" value="${bdto.nickname }">${bdto.nickname }
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">작성자 </span> 
						</td>
						<td class="content_text">
							<input class="input_box" type="hidden" name="writer" value="${bdto.writer }">${bdto.writer }
						</td>
					</tr>
					
					
					<tr>
						<td class="content_item">
							<span class="content_text">제목 </span> 
						</td>
						<td class="content_text">							
							<input style="background-color: #E8F5FF;" class="input_box02" type="text" name="title" value="${bdto.title }" readonly="readonly">
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">내용 </span> 
						</td>
						<td class="content_text">
							<textarea style="background-color: #E8F5FF;" rows="10" cols="40" name="content" value="${bdto.content }" readonly="readonly">${bdto.content }</textarea>
						</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">조회수 </span>
						</td>
						<td align="center" class="content_text">${bdto.hit }</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">작성일 </span>
						</td>
						<td align="center" class="content_text">${bdto.postdate }</td>
					</tr>
					
					<tr>
						<td class="content_item">
							<span class="content_text">최종 수정일 </span>
						</td>
						<td align="center" class="content_text">${bdto.editdate }</td>
					</tr>
					
					<!-- 댓글 기능 추가 -->
					<tr>
						<td class="content_item">
							<span class="content_text">댓글 </span>
						</td>
						<td class="content_text">
							<tr>
								<td>
									<textarea rows="3" cols="40" name="comment" oninput="limitText(this, 300)"></textarea>
								</td>
							</tr>
							<tr>
								<td><input type="submit" value="댓글 쓰기" onclick="winodw.location.href='comment?boadnum=${bdto.boardnum}'"></td>
							</tr>
						</td>
					
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					
					<tr>
						<td>
						<td align="center" >
							<input class="button" type="submit" value="글 수정" onclick="window.location.herf='editPost?boardnum=${bdto.boardnum }'">
							<input class="button" type="button" value="글 삭제" onclick="window.location.href='deletePost?boardnum=${bdto.boardnum }'">
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

