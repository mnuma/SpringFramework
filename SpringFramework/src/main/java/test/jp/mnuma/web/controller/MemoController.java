package test.jp.mnuma.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import test.jp.mnuma.entity.CommentEntity;
import test.jp.mnuma.form.MemoForm;
import test.jp.mnuma.form.SearchForm;
import test.jp.mnuma.service.CommentService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import apple.awt.CMenuBar;

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
		modelAndView.addObject("searchForm", new SearchForm());
		modelAndView.addObject("memoForm", new MemoForm());
		
		List<CommentEntity> list = commentService.getAll();
		modelAndView.addObject("list", list);
		
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
		
		//ここにFormがないとだめ
		modelAndView.addObject("searchForm", new SearchForm());
		modelAndView.addObject("memoForm", new MemoForm());
		modelAndView.setViewName("memo");
		return modelAndView;
	}
	
	@RequestMapping(value="ajaxGetmemo", method=RequestMethod.GET)
    @ResponseBody
    public List<CommentEntity> jsonList(MemoForm memoForm) {
      /*
      List<TagEntity> tag = tagService.getTags(tagForm);
      */
      List<CommentEntity> comment = new ArrayList<CommentEntity>();
      CommentEntity commentent = new CommentEntity();
      commentent.setComment(memoForm.getComment() + "test");
      comment.add(commentent);
      return comment;
    }
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView doDelete(HttpSession httpSession, MemoForm memoForm) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//TODO 削除を作る
		commentService.delete(memoForm.getCommentId());
		
		// 表示
		List<CommentEntity> list = commentService.getAll();
		modelAndView.addObject("list", list);
		
		modelAndView.addObject("searchForm", new SearchForm());
		modelAndView.addObject("memoForm", new MemoForm());
		modelAndView.setViewName("memo");
		return modelAndView;
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ModelAndView doSearch(HttpSession httpSession, SearchForm searchForm) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//TODO 検索を作る
		List<CommentEntity> result = commentService.search(searchForm.getSearchQuery());
		
		// 表示
		modelAndView.addObject("result", result);
		modelAndView.addObject("searchForm", new SearchForm());
		modelAndView.setViewName("search");
		return modelAndView;
	}
}
