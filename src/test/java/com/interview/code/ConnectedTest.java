package com.interview.code;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


import com.interview.exception.ConnectedAppException;

/*

import org.junit.Test; */



public class ConnectedTest {

	@Test
	//@Test(expected = ConnectedAppException.class)
	public  void testConnected() throws ConnectedAppException   {
		Connected connected = new Connected();
		String[] args = {"filename.txt" ,"Boston" ,"Croton-Harmon"};  
		boolean condition = connected.connected(args);
		assertTrue(condition);
	}
	
	@Test
	public  void testConnectedFail() throws ConnectedAppException {
		Connected connected = new Connected();
		String[] args = {"filename.txt" ,"Test" ,"Croton-Harmon"};  
		boolean condition = connected.connected(args);
		assertFalse(condition);
	}

}
