package com.fzy.learn;

import com.fzy.learn.bean.UserLog;
import com.fzy.learn.cache.UserLogCache;
import com.fzy.learn.dao.UserLogDao;
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
