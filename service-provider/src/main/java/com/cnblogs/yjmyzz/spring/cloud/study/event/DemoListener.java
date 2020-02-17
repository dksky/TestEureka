package com.cnblogs.yjmyzz.spring.cloud.study.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Async
	@Override
	public void onApplicationEvent(DemoEvent event) {
		log.info("接收到Publisher的消息");
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("类型：{}, 消息内容：{}, TheadLocal内容：{}", event.getType(), event.getMsg(), TestController.threadLocal.get());
	}

}
