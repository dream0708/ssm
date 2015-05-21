package org.jee.ssm.cms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.jee.ssm.cms.model.User;
import org.jee.ssm.cms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@RequestMapping("/save")
	public String saveUser(User user){
		
		userService.addUser(user);
		return "user/login" ;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public User listUsers(String username){
		User user  = userService.getUserByUsername(username);
		return user;
	}
	@RequestMapping("/lists")
	@ResponseBody
	public List<User> listAllUsers(){
		List<User> users  = userService.getAllUsers();
		return users;
	}
	/**
	 * 分页显示
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public List<User> listAllUsers(int pageSize , int currentPage){
		List<User> users  = userService.getUsersByPage(currentPage, pageSize);
		return users;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET  )
	public String toLoginPage(){
		return "user/login";
	}
	
	@RequestMapping(value = "/center" )
    public String loginSuccess(HttpServletRequest req, Model model) {
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("success", username + " 登陆成功");
        return "user/success";
    }

	
	/**
	 * 登陆过滤器action
	 * @param req
	 * @param model
	 * @return
	 */
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
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}



}
