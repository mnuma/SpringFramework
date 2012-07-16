package test.jp.mnuma.dao;

import test.jp.mnuma.entity.CommentEntity;

public interface CommentDao {
	
	int post(CommentEntity commentEntity);
	CommentEntity getAll(CommentEntity commentEntity);
	
}
