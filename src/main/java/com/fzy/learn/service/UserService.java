package com.fzy.learn.service;

import com.fzy.learn.bean.User;
import com.fzy.learn.bean.UserLog;
import com.fzy.learn.dao.UserDao;
import com.fzy.learn.dao.UserLogDao;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserLogDao userLogDao;

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@Transactional
	public String register(String name, String ip) {
		// 1.添加用户
		User user = new User();
		user.setName(name);
		user.setCreateTime(new Date());
		userDao.insert(user);
		
		// 测试使用
		//boolean flag = true;
		//if (flag) {
		//	throw new RuntimeException();
		//}

		// 2.添加注册日志
		UserLog userLog = new UserLog();
		userLog.setName(name);
		userLog.setIp(ip);
		userLog.setCreateTime(new Date());
		userLogDao.save(userLog);

		return "success";
	}

}
