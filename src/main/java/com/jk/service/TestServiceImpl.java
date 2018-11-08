package com.jk.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.TestDao;
import com.jk.pojo.User;

@Service
public class TestServiceImpl implements  TestService{

	@Autowired
	TestDao testDao;
	
	
	@Override
	public List<LinkedHashMap<String, Object>> findTest() {
		List<String> list=new ArrayList<>();
		list.add("182013052121033133083");
		list.add("182013072730040551054");
		list.add("182013072730085454643");
		return  testDao.findEmpl(list);
	}
	/**
	 * 删除
	 */
	@Override
	public void deleteUser(Integer id) {
		testDao.deleteUser(id);
	}
	/**
	 * 新增
	 */
	@Override
	public void saveuser(User usr) {
		testDao.saveuser(usr);
	}
	/**
	 * 回显
	 */
	@Override
	public User updatetoUser(Integer id) {
		 
		return testDao.updatetoUser(id);
	}
	/**
	 * 修改
	 */
	@Override
	public void updateUser(User usr) {
		 
		testDao.updateUser(usr);
	}
	/**
	 * 查询
	 */
	@Override
	public String queryCookMenu(User user, Integer pageSize, Integer start) {
		List<LinkedHashMap<String, Object>> list = testDao.queryCookMenu(user,pageSize,start);
		Long count = testDao.queryMenuCount(user);
		JSONObject object = new JSONObject();
		object.put("total", count);
		object.put("rows", list);
		return object.toString();
	}
	
}
