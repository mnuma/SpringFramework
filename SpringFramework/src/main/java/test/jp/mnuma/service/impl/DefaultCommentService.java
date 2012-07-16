package test.jp.mnuma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.jp.mnuma.dao.CommentDao;
import test.jp.mnuma.entity.CommentEntity;
import test.jp.mnuma.form.MemoForm;
import test.jp.mnuma.service.CommentService;

@Service("commentService")
public class DefaultCommentService implements CommentService{
	
	@Autowired
	private CommentDao commentDao;

	public int post(MemoForm memoForm) {
		
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setComment(memoForm.getComment());
		commentEntity.setUserName("numa");
		return commentDao.post(commentEntity);
		
	}
}
