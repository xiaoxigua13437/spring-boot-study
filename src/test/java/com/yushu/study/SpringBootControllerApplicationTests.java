package com.yushu.study;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yushu.study.controller.IndexController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootControllerApplicationTests {

	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder request = get("/index");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("hello world"));

		request = get("http://127.0.0.1:8080/index/get").param("name", "无境");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("{\"name\":\"无境\",\"title\":\"hello world\"}"));
	}

}
