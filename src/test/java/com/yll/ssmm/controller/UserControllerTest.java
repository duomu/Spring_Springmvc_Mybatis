package com.yll.ssmm.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 调用请求路径进行测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)//调用Spring单元测试类
@WebAppConfiguration//调用javaWEB的组件，比如自动注入ServletContext Bean等等  
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-springmvc.xml"})//加载Spring配置文件
public class UserControllerTest {
	private static Logger logger = Logger.getLogger(UserControllerTest.class); 
	
	@Autowired
	private WebApplicationContext  wac;
	
	@Autowired
	UserController userController;
	
	@Autowired
	ServletContext context;
	
	MockMvc mockMvc;//SpringMVC提供的Controller测试类
	@Before
	public void setup(){//初始化userController的单元测试环境
		mockMvc=webAppContextSetup(this.wac).build();
		//mockMvc=MockMvcBuilders.standaloneSetup(userController).build();//要模拟真实使用环境，只通过url和必要的参数即可测试
	}
	
	@Test
	public void testAddUser() throws Exception {
		//准备参数
		ResultActions resultActions=this.mockMvc.perform(MockMvcRequestBuilders.post("/user/addUser")
				.param("userName", "kkk")
				.param("password", "123"))
				.andExpect(status().isOk())
				.andDo(print());
		MvcResult mvcResult=resultActions.andReturn();
//		String result=mvcResult.getResponse().getContentAsString();//返回给客户端的数据，在response里面
		Object result=mvcResult.getRequest().getAttribute("message");//返回给客户端的数据，在request里面
		logger.info("message: "+result);
	}

	@Test
	public void testQueryUser() throws Exception {
		//准备参数
		ResultActions resultActions=this.mockMvc.perform(MockMvcRequestBuilders.post("/user/queryUser")
				.param("userId", "1"))
				.andExpect(status().isOk())
				.andDo(print());//输出信息
		MvcResult mvcResult=resultActions.andReturn();
		Object result=mvcResult.getRequest().getAttribute("message");//返回给客户端的数据，在request里面
		logger.info("message: "+result);
	}

	@Test
	public void testAlterUser() throws Exception {
		//准备参数
		ResultActions resultActions=this.mockMvc.perform(MockMvcRequestBuilders.post("/user/alterUser")
				.param("userName", "1")
				.param("userName", "kkk")
				.param("password", "123"))
				.andExpect(status().isOk())
				.andDo(print());
		MvcResult mvcResult=resultActions.andReturn();
		Object result=mvcResult.getRequest().getAttribute("message");//返回给客户端的数据，在request里面
		logger.info("message: "+result);
	}

	@Test
	public void testDeleteUser() throws Exception {
		//准备参数
		ResultActions resultActions=this.mockMvc.perform(MockMvcRequestBuilders.post("/user/deleteUser")
				.param("userId", "1"))
				.andExpect(status().isOk())
				.andDo(print());//输出信息
		MvcResult mvcResult=resultActions.andReturn();
		Object result=mvcResult.getRequest().getAttribute("message");//返回给客户端的数据，在request里面
		logger.info("message: "+result);
	}

}
