package com.tca.entity;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener{

	private String breed;

	public Dog(String breed) {
		this.breed = breed;
	}
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
//		HttpSessionBindingListener.super.valueBound(event);
		// Will be  executed while login
		System.out.println("Feched latest values from the database !");
		
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
//		HttpSessionBindingListener.super.valueUnbound(event);
		// will be executed while logout or disposing the session
		System.out.println("Synced changes to the database !");
	}
	
}
