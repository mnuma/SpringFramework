package test.jp.mnuma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.jp.mnuma.dao.UserDao;
import test.jp.mnuma.entity.UserEntity;
import test.jp.mnuma.form.LoginForm;
import test.jp.mnuma.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService{
	
	@Autowired
	private UserDao userDao;

	public boolean userLogin(LoginForm loginForm) {
		
		System.out.println(loginForm.toString());
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(loginForm.getUserName());
		userEntity.setUserPassword(loginForm.getUserPassword());
		
		//Daoの呼び出し
		return userDao.count(userEntity) > 0;
	}

}
