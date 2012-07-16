package test.jp.mnuma.dao;



import java.util.List;
import test.jp.mnuma.entity.CommentEntity;

public interface CommentDao {
	
	int post(CommentEntity commentEntity);
	
	List<CommentEntity> getAll();
	
	int delete(String commentId);
	
}
