
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import nl.Job;
import nl.cdi.JobQueue;

/**
 *
 * @author Dick
 */
@Path("qnow")
public class QueueNowService {

	@Inject
	JobQueue jobQueue;

	@GET
	public void queueNow(@QueryParam("job") String job) {
		System.out.println("Queue now called for q " + jobQueue.getQueueName());
		jobQueue.addJob(new Job(job));
	}
}
