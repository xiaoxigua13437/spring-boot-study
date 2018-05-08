package com.fzy.learn;

import com.fzy.learn.util.configuration.MyConfig;
import javax.annotation.PostConstruct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTests {
	@Autowired
	private MyConfig myConfig;

	private static Integer i;

	/**
	 * @PostConstruct注解作用：是Java EE 5引入的注解，Spring允许开发者在受管Bean中使用它。
	 * 当DI容器实例化当前受管Bean时，@PostConstruct注解的方法会被自动触发，从而完成一些初始化工作
	 */
	@PostConstruct
	public void init(){
		i=myConfig.getCcc();
	}


	@Test
	public void getConfig() {
		System.out.println(myConfig.getAaa()+"    "+myConfig.getBbb()+"    "+myConfig.getCcc()+"   "+myConfig.getcName());
		System.out.println(i);
	}

}
