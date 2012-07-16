package test.jp.mnuma.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import test.jp.mnuma.entity.CommentEntity;
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
public class MemoController {
	private static final Log LOG = LogFactory.getLog(MemoController.class);
	
	//TODO CommentService作る
	private CommentService commentService;
	
	@RequestMapping(value = "memo", method = RequestMethod.GET)
	public ModelAndView showMemo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memoForm", new MemoForm());
		modelAndView.setViewName("memo");
		return modelAndView;
	}
	
	@RequestMapping(value = "memo", method = RequestMethod.POST)
	public ModelAndView doSubmit(HttpSession httpSession, MemoForm memoForm) {
		
		//TODO 投稿を作る
		System.out.println(memoForm.getComment());
		commentService.post(memoForm);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memoForm", new MemoForm());
		
		modelAndView.setViewName("memo");
		return modelAndView;
	}
}
