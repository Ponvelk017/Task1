package task;

import inputcheck.InvalidInputException;
import util.Util;

public class StringTask {

    public int findLength(String input) throws InvalidInputException {
        Util.checkNull(input);
        return input.length();
    }

    public char[] characterArray(String input) throws InvalidInputException {
        Util.checkNull(input);
        return input.toCharArray();
    }

    public char penultimate(String input, int position) throws InvalidInputException {
        int length = findLength(input);
        Util.checkRange(length, position);
        return input.charAt(length - position);
    }

    public int findOccurance(String input, char targetChar) throws InvalidInputException {
        int length = findLength(input);
        return length - findLength(input.replaceAll(targetChar + "", ""));
    }

    public int greatestPosition(String input, char target) throws InvalidInputException {
        Util.checkNull(input);
        return input.lastIndexOf(target);
    }

    public String LastNChar(String input, int position) throws InvalidInputException {
        int length = findLength(input);
        Util.checkRange(length, position);
        return input.substring(length - position, length);
    }

    public String firstNChar(String input, int position) throws InvalidInputException {
        int length = findLength(input);
        Util.checkRange(length, position);
        return input.substring(0, position);
    }

    public String replacingString(String input, String toReplace, String toGetReplace) throws InvalidInputException {
        Util.checkNull(toReplace);
        Util.checkNull(toGetReplace);
        return input.replaceAll(toReplace, toGetReplace);
    }

    public boolean startingWith(String input, String target) throws InvalidInputException {
        int inputLength = findLength(input);
        int targetLength = findLength(target);
        Util.checkLength(inputLength, targetLength);
        return input.startsWith(target);
    }

    public boolean endingWith(String input, String target) throws InvalidInputException {
        int inputLength = findLength(input);
        int targetLength = findLength(target);
        Util.checkLength(inputLength, targetLength);
        return input.endsWith(target);
    }

    public String convertCase(String input, boolean toConvert) throws InvalidInputException {
        Util.checkNull(input);
        if (toConvert) {
            return input.toUpperCase();
        } else {
            return input.toLowerCase();
        }
    }

    public String reversingString(String input) throws InvalidInputException {
        int length = findLength(input);
        char stringArray[] = input.toCharArray();
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char temp = stringArray[i];
            stringArray[i] = stringArray[j];
            stringArray[j] = temp;
        }
        return String.valueOf(stringArray);
    }

    public String[] multipleString(String input, String splitWith) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(splitWith);
        return input.split(splitWith);
    }

    public String singleString(String input, String changeWith, String changeTo) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(changeWith);
        Util.checkNull(changeTo);
        return input.replaceAll(changeWith, changeTo);
    }

    public String mergeString(String input[], String replaceWith) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(replaceWith);
        return String.join(replaceWith, input);
    }

    public boolean stringEquals(String input1, String input2) throws InvalidInputException {
        Util.checkNull(input1);
        Util.checkNull(input2);
        return input1.equals(input2);
    }

    public boolean stringEqualsCaseIn(String input1, String input2) throws InvalidInputException {
        Util.checkNull(input1);
        Util.checkNull(input2);
        return input1.equalsIgnoreCase(input2);
    }

    public String removeSpaces(String input) throws InvalidInputException {
        Util.checkNull(input);
        return input.trim();
    }
}
