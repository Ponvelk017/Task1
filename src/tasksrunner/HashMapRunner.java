package tasksrunner;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.HashMapTask;

public class HashMapRunner {

	private Logger logger = Logger.getLogger(HashMapRunner.class.getName());

	public void taskRunner() {
		try (Scanner scanner = new Scanner(System.in);) {
			try {
				HashMapTask task7 = new HashMapTask();
				Map<String, String> stringHashMap = task7.createHashMap();
				logger.info("Enter the String Key and String Value to insert");
				for (int i = 0; i < 3; i++) {
					stringHashMap = task7.appendInMap(stringHashMap, scanner.next(), scanner.next());
				}
				logger.info("The New HashMap is : " + stringHashMap);
				logger.info("The size of HashMap is : " + task7.findLength(stringHashMap));

				Map<Integer, Integer> intHashMap = task7.createHashMap();
				logger.info("Enter the integer Key and integer Value to insert");
				scanner.nextLine();
				for (int i = 0; i < 3; i++) {
					intHashMap = task7.appendInMap(intHashMap, scanner.nextInt(), scanner.nextInt());
				}
				logger.info("The New HashMap is : " + intHashMap);
				logger.info("The size of HashMap is : " + task7.findLength(intHashMap));

				Map<String, Object> nullValueHashMap = task7.createHashMap();
				logger.info("Enter the String Key to insert null ");
				scanner.nextLine();
				for (int i = 0; i < 3; i++) {
					nullValueHashMap = task7.appendInMap(nullValueHashMap, scanner.next(), null);
				}
				logger.info("The New HashMap is : " + nullValueHashMap);

				Map<Object, Object> nullKeyHashMap = task7.createHashMap();
				logger.info("Enter the String value to insert null in null key ");
				scanner.nextLine();
				for (int i = 0; i < 3; i++) {
					nullKeyHashMap = task7.appendInMap(nullKeyHashMap, null, scanner.next());
				}
				logger.info("The New HashMap is : " + nullKeyHashMap);
				logger.info("If the Key 1 exist in the Integer Hashmap : "
						+ (task7.checkIfKeyPresents(intHashMap, 1) ? "yes" : "no"));
				logger.info("If the value 11 exist in the Integer Hashmap : "
						+ (task7.checkIfValuePresents(intHashMap, 1) ? "yes" : "no"));
				List<String> values = Arrays.asList(new String[] { "hi", "hello", "bye" });
				logger.info("Changing all values in String Hashmap : "
						+ task7.replaceConsecutiveValues(stringHashMap, values, 3));
				logger.info("Get the value of a existing key in integer hashmap : "
						+ task7.findElementByKey(intHashMap, 1));
				logger.info("Get the value of a existing value in integer hashmap : "
						+ task7.findElementByKey(intHashMap, 1));
				logger.info("Return “Zoho” as a value for a given non existing key in integer map : "
						+ task7.returnCustomIfNoKey(intHashMap, 1000, "ZOHO"));
				logger.info("Remove an existing key : " + task7.removeKeys(intHashMap, 1));
				logger.info("Remove an existing key only if it’s value matches : "
						+ task7.removeIfMatches(intHashMap, 2, 22));
				logger.info("Replace the value of an existing key in a HashMap : "
						+ task7.replaceValues(intHashMap, 3, 12));
				logger.info("Replace the value of an existing key in a HashMap if matches with value: "
						+ task7.replaceIfMatches(intHashMap, 3, 12, 222));
				for (int i = 1; i <= 3; i++) {
					intHashMap = task7.appendInMap(intHashMap, i, 22);
				}
				Map<Integer, Integer> intHashMap2 = task7.createHashMap();
				for (int i = 1; i <= 3; i++) {
					intHashMap2 = task7.appendInMap(intHashMap2, i, 22);
				}
				logger.info("Merging two Map" + task7.mergeTwoMaps(intHashMap, intHashMap2));
				logger.info("Remove all entries : " + task7.removeAll(intHashMap2));

			} catch (InvalidInputException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			} catch (ClassNotFoundException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			} catch (NoSuchMethodException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			} catch (InstantiationException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			} catch (IllegalAccessException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			} catch (InvocationTargetException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			}
		}
	}
}
