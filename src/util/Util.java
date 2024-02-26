package util;

import inputcheck.InvalidInputException;

public class Util {
    private static String checkNull_error = "Input String is Null, Invalid String input";
    private static String checkRange_error = "The Entered position is not in the Range";
    private static String checkStringLength_error = "The Entered String length is larger to process ";
    private static String arrayLength_error = "The array Length is less than the Expected length";
    private static String outOfBound_error = "Provided range is out of bound";

    public static void checkNull(Object input) throws InvalidInputException {
        if (input == null) {
            throw new InvalidInputException(checkNull_error);
        }
    }

    public static void checkRange(int length, int position) throws InvalidInputException {
        if (length < position || position < 0) {
            throw new InvalidInputException(checkRange_error);
        }
    }

    public static void checkLength(int inputLength, int targetLength) throws InvalidInputException {
        if (inputLength < targetLength) {
            throw new InvalidInputException(checkStringLength_error);
        }
    }

    public static void checkArrayLength(int arrayLength, int exceptedLength) throws InvalidInputException {
        if (arrayLength > exceptedLength) {
            throw new InvalidInputException(arrayLength_error);
        }
    }

    public static void checkOutOfBound(int startPosition , int endPosition) throws InvalidInputException  {
        if (startPosition < 0 || endPosition <0 || endPosition<startPosition) {
            throw new InvalidInputException(arrayLength_error);
        }
    }

}
