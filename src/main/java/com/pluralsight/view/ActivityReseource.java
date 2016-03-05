package com.pluralsight.view;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityReseource {
	
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	public Activity createActivity(Activity activity) {
		System.out.println(activity.getDescription());
		return activity;
	}
	
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON })
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		return null;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON })
	public List<Activity> getAllActivities() {
		return this.activityRepository.findAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON })
	@Path("{activityId}")
	public Activity getActivity(@PathParam ("activityId") String activity) {
		return this.activityRepository.findActivity(activity);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON })
	@Path("{activityId}/user")
	public User getUserByActivity(@PathParam ("activityId") String activity) {
		return this.activityRepository.findActivity(activity).getUser();
	}

}
