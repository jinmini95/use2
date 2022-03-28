<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<script src="${path}/resources/js/signOn.js"  charset="UTF-8"></script>
<title>회원가입 페이지</title>`
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>

<body>
	<div class="wrapper">
		<div class="title">
			<h1 style="font-size: 21px;">회원가입</h1>
		</div>

	</div>

	<div class="id">
		<input id="id" type="text" placeholder="아이디를 입력해 주세요">
		<div id="emailError" class="error"></div>
		<div class="password">
			<input id="password" type="password" placeholder="비밀번호를 입력해 주세요.">
			<div id="passwordError" class="error"></div>
		</div>
		<div class="name">
			<input id="name" type="text" placeholder="이름을 입력해 주세요.">
			<div id="nameError" class="error"></div>
		</div>
		<div class="line">
			<hr>
		</div>
		<div class="signUp">
			<button id="signUpButton" onclick="signUpCheck()">가입하기</button>
			<button id="backButton" onclick="history.back()">취소하기</button>
		</div>
	</div>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
%>

</body>

</html>