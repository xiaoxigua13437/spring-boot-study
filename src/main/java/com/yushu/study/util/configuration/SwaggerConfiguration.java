package com.yushu.study.util.configuration;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 *
 * ****注：获取文档内容访问：http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket accessToken() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api")// 定义组
				.select() // 选择那些路径和api会生成document
				.apis(RequestHandlerSelectors.basePackage("com.yushu.study.controller")) // 拦截的包路径
				.paths(regex("/api/.*"))// 拦截的接口路径
				.build() // 创建
				.apiInfo(apiInfo()); // 配置说明
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("生成文档测试")// 标题
				.description("spring boot")// 描述
//				.termsOfServiceUrl("https://github.com/yushu.zhao/spring-boot")//
				.contact(new Contact("yushu.zhao", "https://github.com/yushu.zhao", ""))// 联系
				//.license("Apache License Version 2.0")// 开源协议
				//.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")// 地址
				.version("1.0")// 版本
				.build();
	}
}
