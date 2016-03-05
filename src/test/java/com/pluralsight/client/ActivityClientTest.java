package com.pluralsight.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;

public class ActivityClientTest {

	private static ActivityClient client = new ActivityClient();
	
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

}
