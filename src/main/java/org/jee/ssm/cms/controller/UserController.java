package org.jee.ssm.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET  )
	public String toLoginPage(){
		return "user/login";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST  )
    public ModelAndView showLoginForm(HttpServletRequest req, Model model) {
		ModelAndView mv = new ModelAndView("user/login");
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "UnknownAccountException";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "IncorrectCredentialsException";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        mv.addObject("error", error);
        return mv;
    }



}
