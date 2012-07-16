package test.jp.mnuma.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.jp.mnuma.dao.CommentDao;
import test.jp.mnuma.entity.CommentEntity;
import test.jp.mnuma.mapper.CommentMapper;

@Repository("commentDao")
public class DefaultCommentDao implements CommentDao {
	
	@Autowired
	private CommentMapper commentMapper;

	public int post(CommentEntity commentEntity) {
		return commentMapper.post(commentEntity);
	}

	public List<CommentEntity> getAll() {
		return commentMapper.getAll();
	}

}