package com.yushu.study.controller;

import java.util.Date;
import java.util.HashMap;

import com.yushu.study.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yushu.zhao
 * @date 2018/2/8
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

	private final static Logger logger= LoggerFactory.getLogger(IndexController.class);

	@Value(value = "${custom.secret}")
	private String secret;

	@Value(value = "${custom.number}")
	private int id;

	@Value(value = "${custom.desc}")
	private String desc;

	@RequestMapping
	public String index() {
		return "hello world";
	}

	// @RequestParam 简单类型的绑定，可以出来get和post
	@RequestMapping(value = "/get")
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
//		map.put("secret", secret);
//		map.put("id", id);
//		map.put("desc", desc);
		return map;
	}

	// @PathVariable 获得请求url中的动态参数
	@RequestMapping(value = "/get/{id}/{name}")
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setCreateTime(new Date());
		return user;
	}

}
