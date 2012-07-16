package test.jp.mnuma.web.controller;

import javax.servlet.http.HttpSession;

import test.jp.mnuma.entity.UserEntity;
import test.jp.mnuma.form.LoginForm;
import test.jp.mnuma.form.MemoForm;
import test.jp.mnuma.service.CommentService;
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
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", new LoginForm());
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpSession httpSession, LoginForm loginForm) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
				
		//serviceの呼び出し
		if(userService.userLogin(loginForm)){
			System.out.println("login success");
			
			httpSession.setAttribute("user", new UserEntity(loginForm.getUserId(),loginForm.getUserName(),loginForm.getUserPassword()));
			
			String msg = "aaaaaa";
			modelAndView.addObject("msg", msg);
			
			String resultMsg = "ログインしました";
			modelAndView.addObject("resultMsg", resultMsg);
			modelAndView.addObject("loginForm", new LoginForm());
			modelAndView.addObject("memoForm", new MemoForm());
			modelAndView.setViewName("memo");
			
		}else{
			System.out.println("login failed");	
		}
		
		return modelAndView;
	}
}
