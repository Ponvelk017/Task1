package task;

import inputcheck.InvalidInputException;
import util.Util;

public class StringBuilderTask {

    public StringBuilder createStringBuilder() {
        StringBuilder newStringBuilder = new StringBuilder();
        return newStringBuilder;
    }

    public StringBuilder createStringBuilder(String input) throws InvalidInputException {
        Util.checkNull(input);
        StringBuilder newStringBuilder = new StringBuilder(input);
        return newStringBuilder;
    }

    public int findLength(StringBuilder input) throws InvalidInputException {
        Util.checkNull(input);
        return input.length();
    }

    public StringBuilder append(StringBuilder input, String toAppend) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(toAppend);
        input.append(toAppend);
        return input;
    }

    public StringBuilder appendStringAtPosition(StringBuilder input, String insertString, int position) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(insertString);
        Util.checkRange(findLength(input), position);
        input.insert(position, insertString);
        return input;
    }

    public StringBuilder deleteInStringBuilder(StringBuilder input, int startPosition, int endPosition) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkOutOfBound( startPosition , endPosition);
        return input.delete(startPosition, endPosition);
    }

    public StringBuilder replaceUsingIndex(StringBuilder input,String toReplace, int startPosition, int endPosition) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(toReplace);
        Util.checkOutOfBound( startPosition , endPosition);
        return input.replace(startPosition, endPosition, toReplace);   
    }

    public StringBuilder replaceUsingString(StringBuilder input, String toGetReplaced ,String toReplace) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(toReplace);
        Util.checkNull(toGetReplaced);
        int length = toReplace.length();
        int index = input.indexOf(toGetReplaced);
        while (index != -1) {
            input.replace(index, index+length, toReplace);                
            index = input.indexOf(toGetReplaced);
        }
        return input;     
    }
    
    public StringBuilder reverseInStringBuilder(StringBuilder input) throws InvalidInputException {
        Util.checkNull(input);
        return input.reverse();
    }

    public int firstIndexInStringBuilder(StringBuilder input, String indexString) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(indexString);
        return input.indexOf(indexString);
    }

    public int lastIndexInStringBuilder(StringBuilder input, String indexString) throws InvalidInputException {
        Util.checkNull(input);
        Util.checkNull(indexString);
        return input.lastIndexOf(indexString);
    }

}
