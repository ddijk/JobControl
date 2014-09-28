/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.event.state;

import javax.inject.Named;
import nl.cdi.JobQueue;
import nl.event.NoJobRunningEvent;

/**
 *
 * @author Dick
 */
@Named
public class IdleState extends AbstractState {

	JobQueue jobq;

	private static IdleState instance = new IdleState();

	public static IdleState getInstance() {
		return instance;
	}

	@Override
	public void processNoJobsRunningEvent(StateManager sm, NoJobRunningEvent njre) {

		sm.setState(ProcessingState.getInstance());
		System.out.println("Get Job from q and process it");
		jobq.processJob();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException ex) {
			System.err.println("Error while sleeping");
		}
		sm.setState(IdleState.getInstance());

	}

	public void setQueue(JobQueue q) {
		jobq = q;
	}

}
