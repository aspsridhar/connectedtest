package com.interview.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import com.interview.code.ConnectedObj;
import com.interview.exception.ConnectedAppException;

public class Helper {

	private static String error = "\n  ";

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		String regex = "[0-9]+[\\.]?[0-9]*";
		return Pattern.matches(regex, str);
	}

	/**
	 * It display application usage and gives error message
	 * 
	 * @param error
	 */
	public static void appUsage(String error) {

		StringBuffer sb = new StringBuffer(
				" \n Usage: \n" + "Connected <fileName.txt> <city-name1> <city-name2>" + "\n Error===: " + error);
		// IllegalArgumentException
		System.out.println(sb);
		throw new IllegalArgumentException(sb.toString());
	}

	/**
	 * validates all inputs parameters
	 * 
	 * @param argParameters
	 */
	public static void validate(ConnectedObj argParameters) throws ConnectedAppException {

		try {

			if (!argParameters.getFileName().contains(".txt"))
				appUsage("arg[0] should be file name");

			if (isNumeric(argParameters.getFrom()))
				appUsage("arg[1] should be city name");

			if (isNumeric(argParameters.getTo()))
				appUsage("arg[1] should be city name");
		} catch (IllegalArgumentException argumentException) {
			throw new ConnectedAppException(argumentException.getMessage());

		}
	}

	/**
	 * 
	 * @param pairedCities
	 * @param city1
	 * @param city2
	 * @return
	 * @throws ConnectedAppException
	 */
	public static boolean isCitiesLinked(List<Set> pairedCities, String city1, String city2)
			throws ConnectedAppException {

		try {
			List<Set> linkedCities = mergeLinkedSetOfCities(pairedCities);

			ListIterator<Set> listIterator = linkedCities.listIterator();

			while (listIterator.hasNext()) {
				Set setOfPairedCities = listIterator.next();
				if (setOfPairedCities.contains(city1) && setOfPairedCities.contains(city2)) {
					return true;
				}

			}
		} catch (ConnectedAppException appException) {
			System.out.println("=======File Not found Excpetion ========");
			throw new ConnectedAppException(appException.getMessage());
		}

		return false;
	}

	public static List<Set> readFile(String fileName) throws ConnectedAppException {
		List<Set> cities = new ArrayList<Set>();
		File file = new File(fileName);
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer tokenizer;
			while ((line = br.readLine()) != null) {
				tokenizer = new StringTokenizer(line, ",");
				Set<String> hash_Set = new HashSet<String>();
				while (tokenizer.hasMoreElements()) {
					String element = tokenizer.nextElement().toString().trim();
					hash_Set.add(element);
				}
				cities.add(hash_Set);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("=======File Not found Excpetion ========");
			throw new ConnectedAppException(fileNotFoundException.getMessage());
		} catch (IOException ioException) {
			System.out.println("=======File IO Operation Issue  ========");
			throw new ConnectedAppException(ioException.getMessage());
		} catch (Exception ex) {
			throw new ConnectedAppException(ex.getMessage());
		}

		return cities;

	}

	/**
	 * mergeLinkedSetOfCities will add all linked cities into one set by traverse
	 * through each set of cities
	 * 
	 * @param pairedCities
	 * @return List<Set>
	 */
	private static List<Set> mergeLinkedSetOfCities(List<Set> pairedCities) throws ConnectedAppException {

		List<Set> pairedCities2 = new ArrayList<Set>();

		/**
		 * this method can be improvised by using java 8 streams OR by implementing
		 * Comparator and overriding compare
		 **/
		try {
			boolean flag = false;
			for (int i = 0; i < pairedCities.size(); i++) {
				Set<String> set1 = pairedCities.get(i);

				for (int j = 1; j < pairedCities.size(); j++) {
					Set<String> set2 = pairedCities.get(j);

					for (String city1 : set1) {

						for (String city2 : set2) {
							if (city1.equalsIgnoreCase(city2)) {
								flag = true;
							}
						}
					}
					if (flag) {
						set2.addAll(set1);
						pairedCities2.add(set2);
					}
					flag = false;

				}
			}
		} catch (Exception ex) {
			throw new ConnectedAppException(ex.getMessage());
		}

		return pairedCities2;
	}

}
