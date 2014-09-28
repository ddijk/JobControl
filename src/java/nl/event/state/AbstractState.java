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
public abstract class AbstractState {

	public abstract void processNoJobsRunningEvent(StateManager sm, NoJobRunningEvent njre);
}
