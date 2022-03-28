
function signUpCheck() {
	id = document.getElementById('id').value;
	password = document.getElementById('password').value;
	name = document.getElementById('name').value;
	var url = "userController/addUser";
	console.log(url)
	$.ajax(
		{
			url: url
			, type: "POST"
			, data: {
				id: id
				, password: password
				, name: name
			}
			,
			success: function(data) {
				console.log(data)
				if(data=="ม฿บน")
				{
					alert(data);	
				}
				else
				{
					alert(data);
					location.href="index.jsp"	
				}
				
				
			},
			error: function(e) {
				console.log(e);
			}
		})


}