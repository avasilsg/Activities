package com.pluralsight.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityClientTest {

	private static ActivityClient client = new ActivityClient();
	
	
	@Test
	public void testPutMethod() {
		Activity activity = new Activity();
		activity.setDescription("Yoga");
		activity.setDuration(60);
		activity.setId("224");
		
		activity = client.update(activity);
		
	}
	
	@Test
	public void testPostMethod() {
		Activity activity = new Activity();
		activity.setDescription("Gym");
		activity.setDuration(60);
		
		User user = new User();
		user.setId("222");
		user.setName("Stephan");
		
		activity.setUser(user);
		
		activity = client.createActivity(activity);
		
		assertNotNull(activity);
		
	}
	
	@Test
	public void testGet() {		
		Activity activity = client.get("1234");
		
		System.out.println(activity.getDescription());
		
		assertNotNull(activity);
	}
	
	@Test
	public void getList()
	{		
		List<Activity> list = client.getList();
		
		assertNotNull(list);
	}

	@Test(expected = RuntimeException.class)
	public void getBadReuqest() {
		
		client.get("000");
	}
}
