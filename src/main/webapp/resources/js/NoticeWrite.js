
function noticeInsert() {
	userId = document.getElementById('userId').value;
	title = document.getElementById('title').value;
	content = document.getElementById('content').value;
	console.log('에이잭스가보자아'+userId);
	var url = "/lectureController/insertNotice";
	console.log(url)
	$.ajax(
		{
			url: url
			, type: "POST"
			, data: {
				userId: userId
				, title: title
				, content: content
			}
			,
			success: function(data) {
				console.log(data)
				alert(data);
				location.href = "/lectureController/viewAll";

			},
			error: function(e) {
				console.log(e);
			}
		})


}