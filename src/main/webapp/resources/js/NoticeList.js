 var num = 1;
function moreList() {
	$.ajax({
		url: "/lectureController/getNoticeList",
		type: "GET",
		data: {
			num: parseInt(num++)
			, contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		}
		,
		success: function(data) {
			console.log(data);
			var content = "";
			for (var i = 0; i < data.length; i++) {
				content +=
					"<tr>" +
						"<td>" +
							"<a href='/lectureController/viewDetail?noticeId="+ data[i].noticeId  + "'>"
								+ data[i].userName
							+ "</a>"
						+ "</td>"
						+ "<td>" +data[i].title+"</td>"
						+ "<td type='date'>" +data[i].createDate+"</td>";
			}
		content+="<tr id='addbtn'><td colspan='5'><div class='btns'><a href='javascript:moreList();' class='btn'>´õº¸±â</a></div>  </td></tr>";
			$('#addbtn').remove();//remove btn
			$(content).appendTo("#table");
			
		}, error: function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
};

 