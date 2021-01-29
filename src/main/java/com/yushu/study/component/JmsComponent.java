package com.yushu.study.component;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;


/**
 * @author yushu.zhao
 * @create 2021
 */
//@Component
public class JmsComponent {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private Queue queue;

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}
	
	@JmsListener(destination = "fzy.queue")
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
	}

}
