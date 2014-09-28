/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.event;

import java.util.Date;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;

/**
 *
 * @author Dick
 */
@Singleton
@Startup
public class Runner2 {
	
	
	public void handleEvent(@Observes NoJobRunningEvent njre) {
		System.out.println("Runner2 processing NoJobRunningEVent at "+ new Date());
	}
	
}