package com.yushu.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//使用@WebFilter，@WebListener，@WebServlet需要用@ServletComponentScan注解进行注册
@ServletComponentScan
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
