package com.interview.Utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class HelperTest {

	@Test
	public void testIsNumeric() {
		String value="10";
	    boolean numeric = Helper.isNumeric(value);
	    assertTrue(numeric);
	}

	@Test
	public void readFile() {
		
		String fileName="filename.txt";
		List<Set> listOfLinkedCities = Helper.readFile(fileName);
		assertFalse(listOfLinkedCities.isEmpty());
		

	}

   

}
