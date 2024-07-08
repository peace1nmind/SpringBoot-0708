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

<title>Header</title>

<link rel="stylesheet" href="/resources/css/header.css">

</head>
<body>
	
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr class="header_line">
			<td class="space">&nbsp;</td>
			<td class="menu"><a href="index"><span class="menu">HOME</span></a></td>
			
			<c:choose>
				<c:when test="${sessionScope.sessionId eq null }">
					<td class="menu"><a href="join"><span class="menu">JOIN</span></a></td>
					<td class="menu"><a href="login"><span class="menu">LOGIN</span></a></td>
				</c:when>
				<c:otherwise>
					<td class="menu"><a href="logout"><span class="menu">LOGOUT</span></a></td>
					<td class="menu"><a href="modify"><span class="menu">MODIFY</span></a></td>
				</c:otherwise>
			</c:choose>

			<td class="menu"><a href="profile"><span class="menu">PROFILE</span></a></td>
			<td class="menu"><a href="board"><span class="menu">BOARD</span></a></td>
			<td class="menu"><a href="contact"><span class="menu">CONTACT</span></a></td>
			<td class="menu">&nbsp;</td>
		</tr>
		<tr>
			<td class="pad" align="right" colspan="8">
				<c:if test="${sessionScope.sessionId != null }">
					<span class="loginId">
						LOGIN : <c:out value="${sessionScope.sessionNickname} 님"></c:out>
					</span>
				</c:if>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>
	
</body>
</html>

