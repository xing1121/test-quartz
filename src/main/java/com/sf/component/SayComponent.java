package com.sf.component;

import org.springframework.stereotype.Component;

@Component
public class SayComponent {

	public void say(String str){
		System.out.println("I say "+str+"...................................");
	}
	
}
