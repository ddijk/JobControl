/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.event;

import java.io.Serializable;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Dick
 */
@Model
public class EventBacking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String name;
	
	@Inject
	Event<NoJobRunningEvent> jobEvent;
	
	public void triggerEvent() {
		System.out.println("name is "+ name);
		jobEvent.fire(new NoJobRunningEvent());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
