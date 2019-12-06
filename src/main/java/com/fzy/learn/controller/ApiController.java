package com.fzy.learn.controller;

import com.fzy.learn.bean.UserLog;
import com.fzy.learn.service.UserLogService;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private UserLogService userLogService;

	//配置跨域 还有其他的方式见/util/configuration
//	@CrossOrigin(origins = "http://localhost:8080")
	@ApiIgnore
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}

	@ApiOperation(value = "查找", notes = "查找日志")
	@RequestMapping(value = "user_log",method = RequestMethod.GET)
	public UserLog getUserLog(){
		UserLog userLog=new UserLog();
		userLog.setIp("127.0.0.1");
		userLog.setName("fzy");
		userLog.setId(1);
		userLog.setCreateTime(new Date());
		return userLog;
	}

	@PostMapping(value = "logs")
	public UserLog addUserLog(@RequestBody UserLog userLog){
		UserLog log=userLogService.insert(userLog);
		return log;
	}

	@GetMapping
	public void getLogs(){
		List<UserLog> list=userLogService.findByIds(Arrays.asList(new Integer[]{2,3}));
		System.out.println(list.size());
	}

}
