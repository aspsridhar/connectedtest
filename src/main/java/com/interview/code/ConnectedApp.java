package com.interview.code;

import com.interview.Utils.Helper;
import com.interview.Utils.Messages;

/**
 * 
 * @author arishnapallisridhar
 *
 */
public class ConnectedApp {

	public static void main(String[] args) throws Exception {
		
		if (args.length == 3) {
			Connected.connected(args);
		} else {
			Helper.appUsage(Messages.ERROR_MSG);
		}
		

	}

}
