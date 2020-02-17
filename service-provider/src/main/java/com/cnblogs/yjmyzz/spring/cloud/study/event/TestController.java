package com.cnblogs.yjmyzz.spring.cloud.study.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@Autowired
	private DemoPublisher publisher;
	
	public static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();
	private int i = 0;
	
	@RequestMapping("/testListener")
	@ResponseBody
	public String testListener() {
		threadLocal.set(i++);
		List<Map> list = new ArrayList<>();
		Map<String, String> m1 = new HashMap<>();
		m1.put("1", "2");
		Map<String, String> m2 = new HashMap<>();
		m1.put("3", "4");
		Map<String, String> m3 = new HashMap<>();
		m1.put("5", "6");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		log.info("开始发布消息：");
		publisher.publish(new DemoEvent(this, "测试消息", list));
		log.info("消息发布结束：");
		threadLocal.remove();
		return "消息发布成功";
	}
}
