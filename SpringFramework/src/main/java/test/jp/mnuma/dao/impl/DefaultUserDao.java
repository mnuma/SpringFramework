package test.jp.mnuma.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.jp.mnuma.dao.UserDao;
import test.jp.mnuma.entity.UserEntity;
import test.jp.mnuma.mapper.UserMapper;

@Repository("userDao")
public class DefaultUserDao implements UserDao{
	
	//マッパー呼び出し
	@Autowired
	private UserMapper userMapper;

	public int count(UserEntity userEntity) {
		int count = userMapper.count(userEntity);
		return count;
	}
}
