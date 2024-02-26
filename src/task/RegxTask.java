package task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import inputcheck.InvalidInputException;
import util.Util;

public class RegxTask {

	private Logger logger = Logger.getLogger(RegxTask.class.getName());

	public boolean phoneNumberOperations(String phoneNumber) throws InvalidInputException {
		Util.checkNull(phoneNumber);
		String regex = "^[7-9]+[0-9]{9}+$";
		return Pattern.matches(regex, phoneNumber);
	}

	public boolean alphaNumeric(String input) throws InvalidInputException {
		Util.checkNull(input);
		String regex = "[a-zA-Z0-9]+$";
		return Pattern.matches(regex, input);
	}

	public boolean twoStringCheck(String input1, String input2) throws InvalidInputException {
		Util.checkNull(input1);
		Util.checkNull(input2);
		 String regexStartsWith = "^"+input2+".*";
		 String regexEndsWith = ".*"+input2+"$";
		 Pattern patternStartsWith = Pattern.compile(regexStartsWith);
		 Pattern patternendsWith = Pattern.compile(regexEndsWith);
		 Matcher matcherstartswith = patternStartsWith.matcher(input1);
		 Matcher matcherendswith = patternStartsWith.matcher(input1);
		 if(matcherstartswith.matches() && matcherendswith.matches()) {
			 if(Pattern.compile(input2).matcher(input1).find()) {
				 return Pattern.matches(input1, input2);
			 }
		 }
		 return false;
	}

	public void matchingString(List<String> input, String matchingString) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(matchingString);
		Pattern pattern = Pattern.compile(("^" + matchingString + "$"), Pattern.CASE_INSENSITIVE);
		for (String individualString : input) {
			Matcher matcher = pattern.matcher(individualString);
			logger.info("The " + individualString + " matches " + matchingString + " : " + matcher.find());
		}
	}

	public boolean emailVerification(String input) throws InvalidInputException {
		Util.checkNull(input);
		String regx = "^[^@.]+[a-zA-Z0-9]@[^@.]+[a-zA-Z0-9].[^@.]";
		Pattern patter = Pattern.compile(regx + "+$");
		Matcher matcher = patter.matcher(input);
		return matcher.matches();
	}

	public boolean checkLengeth(List<String> input, int minLength, int maxlength) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkLength(maxlength, minLength);
		boolean result = true;
		String regex = ".{" + minLength + "," + maxlength + "}";  //.{1,6}
		for (String individualString : input) {
			logger.info("the Length of the string " + individualString + " is bewtween " + minLength + " " + maxlength
					+ ": " + Pattern.matches(regex, individualString));
		}
		return result;
	}

	public Map<String, Integer>containsString(List<String> list1, List<String> list2)
			throws InvalidInputException {
		Util.checkNull(list1);
		Util.checkNull(list2);
		Map<String, Integer> matchedStringIndex = new HashMap<String, Integer>();
		String pat = String.join(" ", list2);
		Pattern pattern = Pattern.compile(pat);
		int size = list1.size();
		for (int i = 0; i < size; i++) {
			if((pattern.matcher(list1.get(i)).find())) {
				matchedStringIndex.put(list1.get(i),i);
			}
		}
		return matchedStringIndex;
	}

	public Matcher extractingTagsFromHTML(String htmlCode) throws InvalidInputException {
		Util.checkNull(htmlCode);
		String regex = "<[A-za-z/]+>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(htmlCode);
		return matcher;
	}
	
	public boolean passwordValidation(String input) throws InvalidInputException {
		Util.checkNull(input);
		String regex = "(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-z0-9])(?=.*{8})"; //.*[A-Z].*[0-9].*[^A-Za-z0-9].{8}
		return Pattern.matches(regex, input);
	}
}
