
function Login() {
	id = document.getElementById('id').value;
	password = document.getElementById('password').value;
	console.log(id);
	$.ajax(
		{
			url: "/userController/loginCheck"
			, type: "GET"
			, data: {
				id: id
				, password: password
				, contentType: "application/x-www-form-urlencoded; charset=UTF-8"
			}
			,
			success: function(data) {
				if (data.length == 0) {
					alert("로그인실패입니다. 아이디와 비밀번호를 확인해주세요.");
				}
				else {
					alert("로그인 성공 " + data[0].name + "님 반갑습니다.");
					console.log(data[0].userId);
					sessionStorage.setItem("userId", data[0].userId);
					sessionStorage.setItem("userName", data[0].name);
					location.href = "/lectureController/viewAll";
				}

			}
			,

			error: function(e) {
				console.log(e);
			}


		});

}