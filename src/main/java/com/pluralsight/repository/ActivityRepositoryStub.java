package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	/* (non-Javadoc)
	 * @see com.pluralsight.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity act1 = new Activity();
		act1.setDescription("swimming");
		act1.setDuration(55);
		
		activities.add(act1);
		
		act1 = new Activity();
		act1.setDescription("cycling");
		act1.setDuration(100);
		
		activities.add(act1);
		
		return activities;
		
	}

	@Override
	public Activity findActivity(String activity) {

		Activity act1 = new Activity();
		act1.setDescription("swimming");
		act1.setDuration(55);
		act1.setId("1234");
		
		User user = new User();
		user.setId("456");
		user.setName("Stephan");
		
		act1.setUser(user);
		if (activity.equals(act1.getId()))
			return act1;
		return null;
	}
}
