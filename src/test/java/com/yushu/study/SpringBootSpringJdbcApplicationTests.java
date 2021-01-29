package com.yushu.study;

import com.yushu.study.bean.User;
import com.yushu.study.dao.UserDao;
import com.yushu.study.util.base.Page;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSpringJdbcApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void insert() {
		User entity = new User();
		entity.setName("fzy");
		entity.setCreateTime(new Date());
		userDao.insert(entity);
	}

	@Test
	public void delete() {
		userDao.deleteById(1);
	}

	@Test
	public void update() {
		User entity = new User();
		entity.setId(2);
		entity.setName("无境2");
		entity.setCreateTime(new Date());
		userDao.updateById(entity);
	}

	@Test
	public void select() {
		User result = userDao.selectById(2);
		System.out.println(result);
	}



	// 分页
	@Test
	public void queryForPage() {
		Page<User> result = userDao.queryForPage(1,2,"fzy");
		System.out.println(result.getTotalCount());
	}

}
