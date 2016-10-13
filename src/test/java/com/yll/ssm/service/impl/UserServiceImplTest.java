package com.yll.ssm.service.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yll.ssmm.model.User;
import com.yll.ssmm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"}) 
public class UserServiceImplTest {
	private static Logger logger = Logger.getLogger(UserServiceImplTest.class); 
	@Autowired
	private UserService userService=null;
	
	@Test
	public void testGetUserById() throws Exception {
		User user=userService.getUserById(1);
		if(user!=null){
			logger.info("查询成功！");
		}else{
			logger.info("查询失败！");
		}
	}

	@Test
	public void testInsertUser() throws Exception {
		User user =new User();
		user.setUserName("linlin");
		user.setPassword("123");
		if(userService.getUserByName("linlin")==null){
			int rs=userService.insertUser(user);
			if(rs==1){
				logger.info("插入成功！");
			}else{
				logger.info("插入失败！");
			}
			
		}else{
			logger.info("已存在该用户，请重置用户名！");
		}
	}

	@Test
	public void testDeleteUser() throws Exception {
		int rs=userService.deleteUser(7);
		if(rs==1){
			logger.info("删除成功！");
		}else{
			logger.info("删除失败！");
		}
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user=userService.getUserById(1);
		user.setUserName("aaa");
		user.setAddress("111");
		int rs=userService.updateUser(user);
		if(rs==1){
			logger.info("更新成功！");
		}else{
			logger.info("更新失败！");
		}
	}

}
