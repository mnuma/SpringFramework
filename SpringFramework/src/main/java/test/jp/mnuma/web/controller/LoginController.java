package test.jp.mnuma.web.controller;

import test.jp.mnuma.form.LoginForm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loginForm", new LoginForm());
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
