package com.yushu.study;

import com.yushu.study.bean.UserLog;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootH2ApplicationTests {
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求
	 */
	@Test
	public void getForObject() {
		UserLog bean = restTemplateBuilder.build().getForObject("http://127.0.0.1:8080/api/user_log", UserLog.class, 0);
		System.out.println(bean);

//		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build().getForObject("http://www.fzy.com", String.class);
//		System.out.println(result);

	}

	static class ProxyCustomizer implements RestTemplateCustomizer {
		@Override
		public void customize(RestTemplate restTemplate) {
			String proxyHost = "127.0.0.1";
			int proxyPort = 8080;

			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
				@Override
				public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
					System.out.println(target.getHostName());
					return super.determineProxy(target, request, context);
				}
			}).build();
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
			httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
			httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
			restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		}
	}




}
