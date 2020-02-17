package com.cnblogs.yjmyzz.spring.cloud.study.event;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationEvent;

import lombok.Data;

@Data
public class DemoEvent extends ApplicationEvent {
	
	private String type;
	private List<Map> msg;

	public DemoEvent(Object source, String type, List<Map> msg) {
		super(source);
		this.type = type;
		this.msg = msg;
	}

}
