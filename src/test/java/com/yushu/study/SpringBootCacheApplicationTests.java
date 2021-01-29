package com.yushu.study;

import com.yushu.study.bean.UserLog;
import com.yushu.study.cache.UserLogCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {
	@Autowired
	private UserLogCache userLogCache;


	@Test
	public void select() {
		UserLog result = userLogCache.selectById(2);
		System.out.println(result);
		UserLog result2 = userLogCache.selectById(2);
		System.out.println(result2);
	}

}
