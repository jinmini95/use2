<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
<script src="${path}/resources/js/NoticeList.js"  charset="UTF-8"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
		<input type='number' style="display:none;" id='num' value=0/>
		<button onclick="location.href = '/lectureController/noticeWrite'">글쓰기</button>
			<table id = "table" summary="목록">
				<caption>
					<span>목록</span>
				</caption>
				<thead>
					<tr>
						<th>작성자</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<!-- 리스트의 값이 없을 경우 '현재 데이터가 없습니다'라는 문구를 보여줌 -->
				<c:if test="${list.size() == 0 }">
					<tfoot>
						<tr>
							<td colspan="3">현재 데이타가 없습니다.</td>
						</tr>
					</tfoot>
				</c:if>
				<tbody>
					<c:forEach items="${list}" var="lec">
						<tr>
							<td>
							<a href="/lectureController/viewDetail?noticeId=${lec.noticeId}" >
							${lec.userName}
							</a>
							</td>
							<td>${lec.title}</td>
							<td type="date">${lec.createDate}</td>
						</tr>
					</c:forEach>
					<tr id='addbtn'><td colspan="5"><divclass="btns"><a href="javascript:moreList();" class="btn btn-primary">더보기</a></div></td></tr>
				</tbody>
			</table>
			
					
		</div>
	</div>
	<script type="text/javascript">

var idleTime = 0;

$(document).ready(function () { //Increment the idle time counter every minute.

 var idleInterval = setInterval(timerIncrement, 60000); // 1 minute

 //일정시간 움직임이 있으면 초기화

 $(this).mousemove(function (e) { idleTime = 0; });

 $(this).keypress(function (e) { idleTime = 0; }); });

} }

 function timerIncrement() {

  idleTime = idleTime + 1;

  if (idleTime > 4) { // 20 minutes


   location.href ='/userController/logout';

 }

}


</script>
</body>

</html>