package com.cnblogs.yjmyzz.spring.cloud.study.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DemoListener2 {
	
	@Autowired
	private EventService eventService;

	@EventListener
	public void onApplicationEvent(DemoEvent event) {
		log.info("通过注解接收到Publisher的消息");
		eventService.testService();
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("通过注解接收到消息。类型：{}, 消息内容：{}, TheadLocal内容：{}", event.getType(), event.getMsg(), TestController.threadLocal.get());
	}

}
