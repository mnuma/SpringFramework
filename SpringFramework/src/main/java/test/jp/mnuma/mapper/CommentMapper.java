package test.jp.mnuma.mapper;


import java.util.List;

import test.jp.mnuma.entity.CommentEntity;

public interface CommentMapper {
	
	int post(CommentEntity commentEntity);	
	
	List<CommentEntity> getAll();
}