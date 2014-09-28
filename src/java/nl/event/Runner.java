/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.event;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import nl.cdi.JobQueue;
import nl.event.state.AbstractState;
import nl.event.state.IdleState;
import nl.event.state.StateManager;

/**
 *
 * @author Dick
 */
@Singleton
@Startup
public class Runner implements StateManager {

	@Inject
	JobQueue jobq;

	AbstractState currentState = IdleState.getInstance();

	@PostConstruct
	void init() {
		IdleState.getInstance().setQueue(jobq);
	}

	public void handleEvent(@Observes NoJobRunningEvent njre) {

		currentState.processNoJobsRunningEvent(this, njre);

	}

	@Override
	public void setState(AbstractState newState) {
		currentState = newState;
	}

}
