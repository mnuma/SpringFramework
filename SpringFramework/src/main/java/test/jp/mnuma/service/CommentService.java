package test.jp.mnuma.service;

import test.jp.mnuma.entity.CommentEntity;
import test.jp.mnuma.form.MemoForm;

/**
 * @author mnuma
 *
 */
public interface CommentService {

	CommentEntity post(MemoForm memoForm);
}

