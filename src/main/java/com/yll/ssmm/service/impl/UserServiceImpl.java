package com.yll.ssmm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yll.ssmm.mapper.UserMapper;
import com.yll.ssmm.model.User;
import com.yll.ssmm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int id) throws Exception {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getUserByName(String name) throws Exception {
		return this.userMapper.selectByName(name);
	}

	@Override
	public int insertUser(User user) throws Exception {

		return this.userMapper.insert(user);
	}
	
	@Override
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, timeout = 10)
	public int deleteUser(int id) throws Exception {
		int rs=this.userMapper.deleteByPrimaryKey(id);
//		String str=null;
//		if(str.equals(null)){
//			int i=0;
//		}
		return rs;
	}

	@Override
	public int updateUser(User user) throws Exception {
		return this.userMapper.updateByPrimaryKey(user);
	}

}
