<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype HTML>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="${path}/resources/js/index.js"  charset="UTF-8"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
		<div class="main-wrap">
	 <input id="id" type="text" placeholder="아이디를 입력해 주세요">
		<div id="emailError" class="error"></div>
		<div class="password">
			<input id="password" type="password" placeholder="비밀번호를 입력해 주세요.">
			<div id="passwordError" class="error"></div>
    <input type="submit" onclick="Login()" value="로그인">  <input type="reset" value="다시입력">
		</div>
		<div class="main-wrap">
		<button onclick="location.href = 'signOn.jsp'">Sign on</button>
		</div>
	</div>
	
</body>