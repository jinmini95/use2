package use.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import use.user.model.UserModel;
import use.user.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {

	private UserServiceI userService;

	@Autowired
	public UserController(UserServiceI userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/addUser", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String addUser(@RequestParam("id") String id, @RequestParam("password") String password, @RequestParam("name") String name) {
		
		List<UserModel> model = userService.idCheck(id);
		if(!model.isEmpty()) 
		{
			System.out.println("bad");
			return "중복";
		}
		UserModel sendUser = new UserModel();
		String user_id = UUID.randomUUID().toString();
		sendUser.setUserId(user_id);
		sendUser.setUserLoginId(id);
		sendUser.setUserLoginPwd(password);
		sendUser.setName(name);
		
		int i = userService.insert(sendUser);
		System.out.println(i);
		return "가입성공";

	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) {
		System.out.println("로그아웃중");
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		return "../../index";
	}

	@GetMapping(value = "/loginCheck")
	@ResponseBody
	public List<UserModel> loginCheck(HttpSession session,@RequestParam("id") String id, @RequestParam("password") String password) {
		List<UserModel> um;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userLoginId", id);
		map.put("userLoginPwd", password);
		um = userService.login(map);
		if(um.size() !=0) 
		{
			session.setAttribute("userId",um.get(0).getUserId());
			session.setAttribute("userName",um.get(0).getName());
		}
		return um;
	}

}
