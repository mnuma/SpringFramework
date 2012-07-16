package test.jp.mnuma.web.controller;

import javax.servlet.http.HttpSession;

import test.jp.mnuma.form.LoginForm;
import test.jp.mnuma.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mnuma
 *
 */
@Controller
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", new LoginForm());
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpSession httpSession, LoginForm userForm) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("loginForm", userForm);
		
		//serviceの呼び出し
		if(UserService.userLogin(userForm)){
			System.out.println("login success");
			modelAndView.setViewName("home");
		}else{
			System.out.println("login failed");	
		}
		
		return modelAndView;
	}
}
