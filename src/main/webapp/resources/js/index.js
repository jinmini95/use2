
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
					alert("�α��ν����Դϴ�. ���̵�� ��й�ȣ�� Ȯ�����ּ���.");
				}
				else {
					alert("�α��� ���� " + data[0].name + "�� �ݰ����ϴ�.");
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