package use.user.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import use.user.model.UserModel;
import use.user.service.UserServiceI;

@RestController
@RequestMapping("/userController")
public class UserController {
	private UserServiceI userService;

	public UserServiceI getuserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/addUser/{userLoginId}/{userLoginPwd}/{name}")
	public void addUser(@PathVariable String userLoginId, @PathVariable String userLoginPwd,
			@PathVariable String name) {
		UserModel sendUser = new UserModel();
		String id = UUID.randomUUID().toString();

		sendUser.setUserId(id);
		sendUser.setUserLoginId(id);
		sendUser.setUserLoginPwd(id);
		sendUser.setName(id);

		userService.insert(sendUser);
		  
	}
	

	@GetMapping("/{userLoginId}")
	public boolean idCheck(@PathVariable String userLoginId) {
		return userService.idCheck(userLoginId);
	}
	@GetMapping("/hello")
	public boolean idCheck() {
		System.out.println("들어옴");
		return true;
	}
}
