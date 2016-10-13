package com.yll.ssmm.controller;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.yll.ssmm.model.User;

/**
 * 直接调用Controller方法进行测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-springmvc.xml"})//加载Spring配置文件
public class UserControllerTest2 {
	private static Logger logger = Logger.getLogger(UserControllerTest2.class); 
	
	 // 模拟request,response    
    private MockHttpServletRequest request;    
    private MockHttpServletResponse response;     
        
    // 注入userController    
    @Autowired    
    private UserController userController ; 
    
    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setup(){
    	request=new MockHttpServletRequest();
    	request.setCharacterEncoding("utf-8");
    	response=new MockHttpServletResponse();
    }
    
    /**
     * 测试添加用户，参数为pojo
     */
	@Test
	public void testAddUser() {
		User user=new User();
		user.setUserName("qwe");
		user.setPassword("123");
		ModelAndView result=userController.addUser(user);
		logger.info("jsp: "+result.getViewName());//获取逻辑视图名
		logger.info("message: "+result.getModel());//获取通过modelAndView.addObject()写入的数据
	}

	/**
	 * 测试查询用户，参数为基本数据类型
	 */
	@Test
	public void testQueryUser() {
		ModelAndView result=userController.queryUser(1);
		logger.info("jsp: "+result.getViewName());//获取逻辑视图名
		logger.info("message: "+result.getModel());//获取通过modelAndView.addObject()写入的数据
	}
	
	/**
	 * 测试查询用户，参数为pojo
	 */
	@Test
	public void testAlterUser() {
		User user=new User();
		user.setUserId(1);
		user.setUserName("qwe");
		user.setPassword("123");
		ModelAndView result=userController.alterUser(user);
		logger.info("jsp: "+result.getViewName());//获取逻辑视图名
		logger.info("message: "+result.getModel());//获取通过modelAndView.addObject()写入的数据
	}
	
	/**
	 * 测试删除用户，参数为基本数据类型
	 */
	@Test
	public void testDeleteUser() {
		ModelAndView result=userController.deleteUser(14);
		logger.info("jsp: "+result.getViewName());//获取逻辑视图名
		logger.info("message: "+result.getModel());//获取通过modelAndView.addObject()写入的数据
	}

}
