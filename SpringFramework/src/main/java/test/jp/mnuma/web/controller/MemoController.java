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
	
	@Autowired
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
		
		ModelAndView modelAndView = new ModelAndView();
		
		//TODO 投稿を作る
		commentService.post(memoForm);
		
		List<CommentEntity> list = commentService.getAll();
		modelAndView.addObject("list", list);
		
		modelAndView.addObject("memoForm", new MemoForm());
		modelAndView.setViewName("memo");
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView doDelete(HttpSession httpSession, MemoForm memoForm) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//TODO 削除を作る
		commentService.delete(memoForm.getCommentId());
		
		// 表示
		List<CommentEntity> list = commentService.getAll();
		modelAndView.addObject("list", list);
		
		modelAndView.addObject("memoForm", new MemoForm());
		modelAndView.setViewName("memo");
		return modelAndView;
	}
}
