package test.jp.mnuma.mapper;

import test.jp.mnuma.entity.CommentEntity;

public interface CommentMapper {
	
	int post (CommentEntity commentEntity);	
	
	CommentEntity getAll (CommentEntity commentEntity);
}
