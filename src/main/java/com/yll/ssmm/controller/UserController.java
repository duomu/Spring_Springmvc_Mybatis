package com.yll.ssmm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yll.ssmm.model.User;
import com.yll.ssmm.service.UserService;

/**
 * <P>Tiltle:UserControllerAnnotation</p>
 * <p>Description:注解的Controller,对应注解的映射器和适配器</p>
 * @author Administrator
 * @date 2016年7月12日 下午2:44:19
 */
@Controller
@RequestMapping("/user")//根路径,相当于struts中，action的namespace
public class UserController {//而UserController相当于UserAction
	private static Logger logger = Logger.getLogger(UserController.class); 
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addUser")//子路径,相当于struts中，action的name
	public ModelAndView addUser(User user){
		ModelAndView modelAndView=new ModelAndView();
		try {
			if(userService.getUserByName(user.getUserName())==null){
				userService.insertUser(user);
				modelAndView.addObject("message", "添加成功");//相当于 request.setAttribute(key,value)
			}else{
				modelAndView.addObject("message", "添加失败，该用户名已被使用！");
			}
			//若在xml中配置映射器时指定了前缀和后缀，则此处url不再写前缀和后缀
			//modelAndView.setViewName("/views/success.jsp");
			modelAndView.setViewName("success");//设置逻辑视图名,相当于原来在struts.xml中配置的action和视图的映射关系
		} catch (Exception e) {
			logger.error("Exception in addUser: "+e.getMessage());
			modelAndView.addObject("message", "添加失败！");
			modelAndView.setViewName("error");
		}
		return modelAndView;//相当于struts中的return SUCCESS、return ERROR等
	}
	
	@RequestMapping("/queryUser")//子路径
	public ModelAndView queryUser(Integer userId){
		ModelAndView modelAndView=new ModelAndView();
		try {
			User user = userService.getUserById(userId);
			modelAndView.addObject("message", "查询用户为"+user.getUserName());
			modelAndView.setViewName("success");//设置逻辑视图名
		} catch (Exception e) {
			logger.error("Exception in queryUser: "+e.getMessage());
			modelAndView.addObject("message", "查询失败");
			modelAndView.setViewName("error");//设置逻辑视图名
		}
		return modelAndView;
	}
	
	@RequestMapping("/alterUser")//子路径
	public ModelAndView alterUser(User user){
		ModelAndView modelAndView=new ModelAndView();
		try {
			if(userService.getUserByName(user.getUserName())==null){
				userService.updateUser(user);
				modelAndView.addObject("message", "修改成功");
			}else{
				modelAndView.addObject("message", "修改失败，该用户名已被使用！");
			}
			modelAndView.setViewName("success");//设置逻辑视图名
		} catch (Exception e) {
			logger.error("Exception in alterUser: "+e.getMessage());
			modelAndView.addObject("message", "更新失败");
			modelAndView.setViewName("error");//设置逻辑视图名
		}
		return modelAndView;
	}
	
	@RequestMapping("/deleteUser")//子路径
	public ModelAndView deleteUser(Integer userId){
		ModelAndView modelAndView=new ModelAndView();
		try {
			userService.deleteUser(userId);
			modelAndView.addObject("message", "删除成功");
			modelAndView.setViewName("success");//设置逻辑视图名
		} catch (Exception e) {
			logger.error("Exception in deleteUser: "+e.getMessage());
			modelAndView.addObject("message", "删除失败");
			modelAndView.setViewName("error");//设置逻辑视图名
		}
		return modelAndView;
	}
}
