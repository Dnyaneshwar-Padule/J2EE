package com.tca.entity;

import java.io.Serializable;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionEvent;

public class User implements Serializable, HttpSessionBindingListener, HttpSessionActivationListener{
		
	private static final long serialVersionUID = 9219926106261419486L;
	private String name;
	private Integer age;
	
	public User() {
		name = null;
		age = null;
	}
	
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("I am added to the session:" + event.getSession().getId()  +  ", time to load data from the disk.");
	} 
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Session is destroyed or I am removed from the session, time to sync data to the disk");
	}
	
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("I am ready to be saved on disk (or to be merged on different JVM)");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("I am being reloaded from the disk.....");
	}

}
