package com.tca.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionTracker
 *
 */

/*
 <listener>
 	<listener-class>
 		com.example.BeerSessionCounter
 	</listener-class>
 </listener>
  */
@WebListener
public class SessionTracker implements HttpSessionListener {
	
	private Long activeUsers;
	
	
    public SessionTracker() {
    	activeUsers = 0l;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	activeUsers++;
    	System.out.println("One more session created : " + se.getSession().getId());
    	System.out.println("Current active Users : " + activeUsers);
    	System.out.println("-------------------------------------------");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        activeUsers--;
        System.out.println("Session destroyed : " + se.getSession().getId());
        System.out.println("Current active users : " + activeUsers);
    	System.out.println("-------------------------------------------");
    }
	
}
