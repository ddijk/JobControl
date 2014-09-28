/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl;

import java.util.Date;

/**
 *
 * @author Dick
 */
public class Job {

	String id;

	public Job(String id) {
		this.id = id;
	}

	public void execute() {
		System.out.println("Executing job " + id + " at " + new Date());
	}

}
