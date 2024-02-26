package task;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import inputcheck.InvalidInputException;
import util.Util;

//Coding to the interface in Java - Design patterns
public class ArrayListTask {
	
	
	public <T> List<T> createList() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		
		Class<?> arrayListClass = Class.forName("java.util.ArrayList");
		Constructor<?> arrayListConstructor = arrayListClass.getDeclaredConstructor();
		return (List<T>) arrayListConstructor.newInstance();
	}

	public <T> List<T> createList(T input[])  throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InvalidInputException {
		Util.checkNull(input);
		Class<?> arrayListClass = Class.forName("java.util.ArrayList");
		Constructor<?> arrayListConstructor = arrayListClass.getDeclaredConstructor(Array.class);
		return (List<T>) arrayListConstructor.newInstance(input);
	}

	public <T> int findLength(List<T> input) throws InvalidInputException {
		Util.checkNull(input);
		return input.size();
	}

	public <T> List<T> appenToList(List<T> input, T toAppend) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(toAppend);
		input.add(toAppend);
		return input;
	}

	public <T> List<T> addElementAtPosition(List<T> input, T toAdd, int indexToAdd) throws InvalidInputException {
		Util.checkRange(findLength(input), indexToAdd);
		Util.checkNull(toAdd);
		input.add(indexToAdd, toAdd);
		return input;
	}

	public <T> List<T> trimList(List<T> input, int statrPosition, int endPosition) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkOutOfBound(statrPosition, endPosition);
		return input.subList(statrPosition, endPosition);
	}

	public <T> Iterator<T> printUsingIterator(List<T> input) throws InvalidInputException {
		Util.checkNull(input);
		Iterator<T> iterator = input.iterator();
		return iterator;
	}

	public <T> T findElementAtIndex(List<T> input, int positionOfElement) throws InvalidInputException {
		Util.checkRange(findLength(input), positionOfElement);
		return input.get(positionOfElement);
	}

	public <T> T findFirstIndex(List<T> input, T targetElement) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(targetElement);
		return input.get(input.indexOf(targetElement));
	}

	public <T> T findLastIndex(List<T> input, T targetElement) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(targetElement);
		return input.get(input.lastIndexOf(targetElement));
	}

	public <T> List<T> deleteAtindex(List<T> input, int position) throws InvalidInputException {
		Util.checkRange(findLength(input), position);
		input.remove(position);
		return input;
	}

	public <T> List<T> mergeList(List<T> input1, List<T> input2) throws InvalidInputException {
		Util.checkNull(input1);
		Util.checkNull(input2);
		input1.addAll(input2);
		return input1;
	}
	
	public <T> List<T> deleteElementsWhichPresent(List<T> input1, List<T> input2) throws InvalidInputException {
		Util.checkNull(input1);
		Util.checkNull(input2);
		input1.retainAll(input2);
		return input1;
	}

	public <T> List<T> deleteElementsWhichNotPresent(List<T> input1, List<T> input2) throws InvalidInputException {
		Util.checkNull(input1);
		Util.checkNull(input2);
		input1.removeAll(input2);
		return input1;
	}
	
	public <T> List<T> removeElementsInRange(List<T> input, int statrPosition, int endPosition)
			throws InvalidInputException {
		Util.checkNull(input);
		Util.checkOutOfBound(statrPosition, endPosition);
		input.removeAll(input.subList(statrPosition, endPosition));
		return input;
	}

	public <T> boolean checkIfPresent(List<T> input1, T toCheck) throws InvalidInputException {
		Util.checkNull(input1);
		Util.checkNull(toCheck);
		return input1.contains(toCheck);
	}

}
