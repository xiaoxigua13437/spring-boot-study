package com.yushu.learn;

import com.yushu.learn.component.MailComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {

	@Autowired
	private MailComponent mailComponent;


	@Test
	public void sendMail() {
		mailComponent.sendMail("yushu.zhao2@163.com");
	}

}
