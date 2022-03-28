<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<head>
<meta charset="UTF-8">
<script src="${path}/resources/js/NoticeWrite.js" charset="UTF-8"></script>
<title>글작성 페이지</title>`
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>

<div class="row" style="margin-bottom: 20px; margin-left: 1px;">
	<div class="col-lg-12">
		<h1 class="page-header">상세 페이지</h1>
	</div>
</div>
<body>
	<div class="panel" style="margin-left: 1px;">
		<div id="contAreaBox">
			<div class="panel">
				<div class="panel-body">
					<div class="table-responsive" style="text-align: center;">
						<table id="datatable-scroller"
							class="table table-bordered tbl_Form">
							<caption></caption>
							<colgroup>
								<col width="300px" />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th class="active">작성자</th>
									<td>${userName}</td>
									<input type="text" style="display: none" id='userId'
										value=${userId} }></input>
								</tr>
								<tr>
									<th class="active">제목:<input type="text" id='title'
										placeholder="제목을 입력하세요."></input>
									</th>
									<td></td>
								</tr>
								<tr>
									<th class="active"><textarea style="resize: none;"
											id='content' placeholder="내용을 입력하세요."></textarea></th>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div style="margin-left: 1px;">
						<button id="backButton" onclick="history.back()">취소</button>
						<button id="insertButton" onclick="javascript:noticeInsert()">작성</button>
					</div>
				</div>
			</div>
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