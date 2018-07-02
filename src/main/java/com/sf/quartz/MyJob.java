package com.sf.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.sf.component.SayComponent;

public class MyJob implements Job {
    
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
