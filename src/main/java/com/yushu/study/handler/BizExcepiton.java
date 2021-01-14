package com.yushu.study.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * 自定义统一异常处理类
 *
 * @author yushu.zhao
 * @create 2021-01-14 16:11
 */
@ControllerAdvice
public class BizExcepiton {

	private static final Logger logger =  LoggerFactory.getLogger(BizExcepiton.class);
	
	/**
	 * 统一异常处理
	 * 
	 * @param exception
	 *            exception
	 * @return
	 */
//	@ExceptionHandler({ RuntimeException.class })
//	@ResponseStatus(HttpStatus.OK)
//	public ModelAndView processException(RuntimeException exception) {
//		logger.info("自定义异常处理-RuntimeException");
//		ModelAndView m = new ModelAndView();
//		m.addObject("exception", exception.getMessage());
//		m.setViewName("error/500");
//		return m;
//	}

	/**
	 * 统一异常处理
	 * 
	 * @param exception
	 *            exception
	 * @return
	 */
//	@ExceptionHandler({ Exception.class })
//	@ResponseStatus(HttpStatus.OK)
//	public ModelAndView processException(Exception exception) {
//		logger.info("自定义异常处理-Exception");
//		ModelAndView m = new ModelAndView();
//		m.addObject("exception", exception.getMessage());
//		m.setViewName("error/500");
//		return m;
//	}

}
