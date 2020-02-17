package com.cnblogs.yjmyzz.spring.cloud.study.event;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventService {

	@Async
	public void testService() {
		log.info("EventService, ThreadLocal: {}", TestController.threadLocal.get());
	}
}
