package org.jee.ssm.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/index")
	public String toLoginPage(){
		return "user/login";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password, Model model){
		model.addAttribute("username", username);
		return "user/login";
	}

}
