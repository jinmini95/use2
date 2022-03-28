<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>

<div class="row" style="margin-bottom: 20px; margin-left: 1px;">
	<div class="col-lg-12">
		<h1 class="page-header">상세 페이지</h1>
	</div>
</div>

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
								<td>${model.userName}</td>
							</tr>
							<tr>
								<th class="active">제목</th>
								<td>${model.title}</td>
							</tr>
							<tr>
								<th class="active"><textarea readonly style="resize: none;">내용</textarea>
								</th>
								<td>${model.content}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="margin-left: 1px;">
					<button id="backButton" onclick="history.back()">목록</button>
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

 $(this).mousemove(function (e) { idleTime = 0;});

 $(this).keypress(function (e) { idleTime = 0;});
 
 });



 function timerIncrement() {

  idleTime = idleTime + 1;

  if (idleTime > 0) { // 20 minutes

	alert('장시간 움직임이 감지되지 않아 로그아웃합니다.')
   location.href ='/userController/loginOut';

 }

}


</script>
