/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.cdi;

import java.util.concurrent.LinkedBlockingQueue;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import nl.Job;

/**
 *
 * @author Dick
 */
@Named
@ApplicationScoped
public class JobQueue {

	String name = "job-queue-";
	int MAX_QUEUE_LENGTH = 20;
	LinkedBlockingQueue<Job> queue = new LinkedBlockingQueue<>(MAX_QUEUE_LENGTH);

	private static int id;

	@PostConstruct
	void init() {
		id++;
	}

	//@Produces
	public String getQueueName() {
		return name + id;
	}

	public void processJob() {
		System.out.println("About to process job");

		Job job;
		try {
			job = queue.take();
			job.execute();
			System.out.println("Job done");
		} catch (InterruptedException ex) {
			System.out.println("Interrupted while blocked on q");
		}

	}

	public void addJob(Job job) {
		queue.add(job);
	}
}
