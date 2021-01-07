package com.yushu.learn;

import com.yushu.learn.component.RedisComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Autowired
	private RedisComponent redisComponent;

	@Test
	public void set() {
		redisComponent.set("fzy", "hello world");
	}

	@Test
	public void get() {
		System.out.println(redisComponent.get("fzy"));
	}

	@Test
	public void del() {
		redisComponent.del("fzy");
	}

}
