package com.yushu.study.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author yushu.zhao
 * @date 2018/2/8
 */
@Controller
@RequestMapping("")
public class WebController {
	
	private static final Logger logger =  LoggerFactory.getLogger(WebController.class);
	
	@RequestMapping("index_test")
	public String index(ModelMap map,HttpSession httpSession,Boolean flag){
		logger.info("这里是controller");
		logger.info("sessionID=" + httpSession.getId());
//		if (flag){
//			throw new RuntimeException("ceshilsjfdo");
//		}
//		map.put("title", "hello world");
		return "templates/index";
	}

}

