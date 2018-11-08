package com.jk.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jk.pojo.User;
import com.jk.service.TestService;
 
@Controller
public class TestController {

	@Autowired
	TestService testService;
	
 
	@RequestMapping(value="/test")
	public  ModelAndView  test(){
			ModelAndView modelAndView = new ModelAndView("index");
			return  modelAndView;
	}
	/**
	 * 查询
	 * @param user
	 * @param pageSize
	 * @param start
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/queryCookMenu",produces = "text/html; charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String queryCookMenu(User user,Integer pageSize,Integer start,HttpServletRequest request,HttpServletResponse response){
		String str = testService.queryCookMenu(user,pageSize,start);
		return str;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteUser/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView deleteUser(@PathVariable("id")Integer id){
		testService.deleteUser(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/test");
		return modelAndView;
	}
	/**
	 * 新增跳转页面
	 */
	@RequestMapping("tiaoseve")
	public ModelAndView saveuser(){
		ModelAndView mode=new ModelAndView("addUser");
		return mode;
	}
	/**
	 * 新增
	 */
	@RequestMapping(value="seve",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView seve(User usr){
		testService.saveuser(usr);
		ModelAndView modelAndView = new ModelAndView("redirect:/test");
		return modelAndView;
	}
	/**
	 * 回显
	 * updatetoUser
	 */
	@RequestMapping(value="/updatetoUser/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView updatetoUser(@PathVariable("id")Integer id){
		Map<String, Object> map=new HashMap();
		User emp= testService.updatetoUser(id);
		map.put("emp", emp);
		return new ModelAndView("updateUser",map);
	}
	/**
	 * 修改
	 * updateUser
	 */
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateUser(User usr){
		testService.updateUser(usr);
		ModelAndView modelAndView = new ModelAndView("redirect:/test");
		return modelAndView;
	}



}
