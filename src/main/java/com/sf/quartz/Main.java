package com.sf.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:applicationContext-scheduler.xml");
	}

}
