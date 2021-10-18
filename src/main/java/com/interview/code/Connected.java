package com.interview.code;

import java.util.List;
import java.util.Set;

import com.interview.Utils.Helper;
import com.interview.Utils.Messages;
import com.interview.exception.ConnectedAppException;

/**
 * 
 * @author arishnapallisridhar
 * 
 *         Approach : 1. Verify Argumets length and 2. verify arguments types 3.
 *         Read file and prepare collection of list of objects of paired cities
 *         (set) 4. verify linked cities (set)
 * 
 *         Connected is main class which takes inputs and gives the results on
 *         connected cities
 */

public class Connected {

	public static boolean connected(String[] args) throws ConnectedAppException{

		ConnectedObj argParameters = new ConnectedObj();
		argParameters.setFileName(args[0]);
		argParameters.setFrom(args[1]);
		argParameters.setTo(args[2]);

		Helper.validate(argParameters);

		List<Set> pairedCities = Helper.readFile(argParameters.getFileName());

		// List<Set>
		// pairedCities=Helper.processConnectedCities(Helper.readFile(argParameters.getFileName()));

		if (Helper.isCitiesLinked(pairedCities, argParameters.getFrom(), argParameters.getTo())) {
			System.out.println("YES");
			return true;
		} else {
			System.out.println("NO");
			return false;
		}

	}

}
