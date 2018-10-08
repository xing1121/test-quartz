package com.sf.wdx.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sf.wdx.component.SayComponent;

/**
 * 描述：自定义任务
 * @author 80002888
 * @date   2018年10月8日
 */
public class MyJob implements Job {
    
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:spring-quartz.xml");
	}
	
	@Autowired
	private SayComponent sayComponent;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("######################MyJob...execute######################");
		System.out.println("调度器：" + context.getScheduler());
		System.out.println("任务名称：" + context.getJobDetail().getKey().getName());
		System.out.println("触发器是：" + context.getTrigger().getKey().getName());
		
		ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContext");
        System.out.println("获取到的Spring容器是： " + applicationContext);
        
        sayComponent.say("Year~~~");
	}

}
