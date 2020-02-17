package com.cnblogs.yjmyzz.spring.cloud.study.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
	@Autowired
	private ApplicationContext applicationContext;
	
	public void publish(DemoEvent demoEvent) {
		applicationContext.publishEvent(demoEvent);
	}

}
