package com.interview.code;

import com.interview.Utils.Helper;
import com.interview.Utils.Messages;
import com.interview.exception.ConnectedAppException;

/**
 * 
 * @author arishnapallisridhar
 *
 */
public class ConnectedApp {

	public static void main(String[] args) {

		try {
			if (args.length == 3) {
				Connected.connected(args);
			} else {
				Helper.appUsage(Messages.ERROR_MSG);
			}
		} catch (ConnectedAppException ce) {
			System.out.println("======"+ce.getMessage());
		}

	}

}
