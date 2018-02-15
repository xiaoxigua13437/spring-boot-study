package com.fzy.learn;

import com.fzy.learn.bean.User;
import com.fzy.learn.dao.mybatis.UserMapper;
import com.fzy.learn.dao.mybatis.UserXmlMapper;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserXmlMapper userXmlMapper;

	@Test
	public void insert() {
		User user = new User();
		user.setName("测试");
		user.setCreateTime(new Date());
		int result = userMapper.insert(user);
		System.out.println(result);
	}

	@Test
	public void select(){
		List<User> list=userXmlMapper.select();
		for (User item:list){
			System.out.println(item.getName());
		}
	}

}
