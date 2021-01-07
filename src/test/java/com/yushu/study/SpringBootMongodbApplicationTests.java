package com.yushu.learn;

import com.yushu.learn.bean.UserLog;
import com.yushu.learn.dao.UserLogMongoDao;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbApplicationTests {
	@Autowired
	private UserLogMongoDao userLogMongoDao;

	@Test
	public void insert() {
		UserLog entity = new UserLog();
		entity.setId(1);
		entity.setName("无境");
		entity.setIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogMongoDao.save(entity);
	}

	@Test
	public void delete() {
		userLogMongoDao.delete(1);
	}

	@Test
	public void update() {
		UserLog entity = new UserLog();
		entity.setId(2);
		entity.setName("无境2");
		entity.setIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogMongoDao.save(entity);
	}

	@Test
	public void select() {
		UserLog result = userLogMongoDao.findOne(1);
		System.out.println(result);
	}

	@Test
	public void select2() {
		UserLog result = userLogMongoDao.findByName("无境2");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
		// Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
		Page<UserLog> result = userLogMongoDao.findAll(pageable);
		System.out.println(result.getContent());
	}


}
