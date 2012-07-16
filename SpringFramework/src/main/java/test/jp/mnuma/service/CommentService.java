package test.jp.mnuma.service;

import java.util.ArrayList;
import java.util.List;

import test.jp.mnuma.entity.CommentEntity;
import test.jp.mnuma.form.MemoForm;

/**
 * @author mnuma
 *
 */
public interface CommentService {

	int post(MemoForm memoForm);

	List<CommentEntity> getAll();	
}

