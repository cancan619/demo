package com.jk.service;

import java.util.LinkedHashMap;
import java.util.List;

import com.jk.pojo.User;

public interface TestService {

	List<LinkedHashMap<String, Object>> findTest();

	void deleteUser(Integer id);

	void saveuser(User usr);

	User updatetoUser(Integer id);

	void updateUser(User usr);

	String queryCookMenu(User user, Integer pageSize, Integer start);

}
