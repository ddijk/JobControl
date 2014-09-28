/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.event.state;

import nl.event.NoJobRunningEvent;

/**
 *
 * @author Dick
 */
public class ProcessingState extends AbstractState {

	private static ProcessingState instance = new ProcessingState();

	public static ProcessingState getInstance() {
		return instance;
	}

	@Override
	public void processNoJobsRunningEvent(StateManager sm, NoJobRunningEvent njre) {
		System.out.println("Received event in ProcessingState: Ignore event");

	}

}
