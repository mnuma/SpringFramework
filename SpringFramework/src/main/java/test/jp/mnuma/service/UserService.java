package test.jp.mnuma.service;

import test.jp.mnuma.form.LoginForm;

/**
 * @author mnuma
 *
 */
public interface UserService {
	//ユーザのログイン
	boolean userLogin(LoginForm userForm);
}

