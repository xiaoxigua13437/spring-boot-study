package com.yushu.learn.util.configuration;

import com.yushu.learn.util.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomCorsConfiguration2 extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		//添加日志拦截器
		registry.addInterceptor(logInterceptor())
				//拦截路径
				.addPathPatterns("/**")
				//除去不拦截的路径
				.excludePathPatterns("/file/**");

		super.addInterceptors(registry);
	}


	/**
	 * 配置跨域
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//		registry.addMapping("/api/**").allowedOrigins("*");
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST","GET","PUT","PATCH","OPTIONS","HEAD","DELETE")
				.allowedHeaders("Authentication","Origin","X-Requested-With","Content-Type","Token").maxAge(3600L);
	}


	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	/**
	 * 将拦截器对象放入spring容器（通过该方式，可以在拦截器中注入service）
	 * @return
	 */
	@Bean
	public LogInterceptor logInterceptor(){
		return new LogInterceptor();
	}


	/**
	 * 配置访问静态资源
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/Users/yushu.zhao/Desktop/temporary_save_file/**").addResourceLocations("file:/Users/yushu.zhao/Desktop/temporary_save_file/");
		super.addResourceHandlers(registry);
	}



}
