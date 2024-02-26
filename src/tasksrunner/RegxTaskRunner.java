package tasksrunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;

import inputcheck.InvalidInputException;
import task.RegxTask;

public class RegxTaskRunner {
	
	private Logger logger = Logger.getLogger(RegxTask.class.getName());
	RegxTask task10 = new RegxTask();
	
	public void taskRunner() throws InvalidInputException {
		try(Scanner scanner = new Scanner(System.in)){
			logger.info("Enter the Phone Number : ");
			String phoneNumber = "9090909090";
			logger.info("does it have 10 digits : " + task10.phoneNumberOperations(phoneNumber));
			logger.info("Enter a string to check for alpha numeric : "+task10.alphaNumeric("helloW12"));
			logger.info("Enter two string to check whether it starts with, ends with : "+task10.twoStringCheck("hello","hello World"));
			ArrayList<String> list = new ArrayList<String>();
			list.add("hello");
			list.add("HeLLo");
			list.add("hello world");
			logger.info("Whether the String matches with the list of strings : ");
			task10.matchingString(list,"Hello");
			logger.info("Email Verification : " +task10.emailVerification("Hello@llo.com"));
			task10.checkLengeth(list, 1, 6);
			logger.info("Index of the element which matches in list1 :");
			ArrayList<String> list2 = new ArrayList<String>();
			list2.add("hello");
			list2.add("hello world");
			list2.add("hello");
			list2.add("hello world");
			list2.add("HeLLo");
			list2.add("hello");
			list2.add("hello world");
			list2.add("hello");
			Map<String, Integer> matchedStringIndex = task10.containsString(list2 , list);
			for(Map.Entry<String, Integer> e : matchedStringIndex.entrySet()) {
				logger.info(e.getKey() +" "+e.getValue());
			}
			logger.info("The tags in html code is: ");
			Matcher matcher = task10.extractingTagsFromHTML("<p>The <code>President</code> of India is the first\n"
					+ "citizen of our country.</p>");
			while(matcher.find()) {
				logger.info(matcher.group());
			}
		}
	}
}
