package use.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	@GetMapping("/use")
	public String index() 
	{
		System.out.println("들어옴");
		return "/index2.jsp";
	}

}
