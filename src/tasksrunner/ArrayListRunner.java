package tasksrunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.ArrayListTask;

public class ArrayListRunner {

	private final Logger logger = Logger.getLogger(ArrayListRunner.class.getName());

	public void taskRunner() {
		try(Scanner scanner = new Scanner(System.in)) {		
			ArrayListTask task6 = new ArrayListTask();
			Integer inputs[] = { 1, 2, 3, 4, 5 };
			List<Integer> tempArrayList1 = task6.createList(inputs);
			logger.info("The size of Empty Arraylist is : " + task6.findLength(tempArrayList1));
			logger.info("The elements and length of Arraylist is :" + tempArrayList1 + " "
					+ task6.findLength(tempArrayList1));
			logger.info("The index of String '4' in the Arraylist is :" + task6.findElementAtIndex(tempArrayList1, 4));
			logger.info("The Elements in the ArrayList is : ");
			Iterator<Integer> iterator = task6.printUsingIterator(tempArrayList1);
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			logger.info("The element at the index 3 is :" + task6.findElementAtIndex(tempArrayList1, 3));
			tempArrayList1 = task6.createList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
			logger.info("The element(3) at first and last position in the arraylist :"
					+ task6.findFirstIndex(tempArrayList1, 3) + " " + task6.findLastIndex(tempArrayList1, 3));
			logger.info("the ArrayList after adding element at 2nd position is : "
					+ task6.addElementAtPosition(tempArrayList1, 10, 2));
			Integer input2[] = { 1, 2, 3, 4 };
			List<Integer> tempArrayList2 = task6.createList(input2);
			List<Integer> mergedArraylist = task6.mergeList(tempArrayList2, tempArrayList1);
			logger.info("the New ArrayList is : " + task6.printUsingIterator(mergedArraylist));
			logger.info("The ArrayList from index 3 to 8 :" + task6.trimList(mergedArraylist, 3, 8));
			logger.info("The arraylist created from two different Arraylist : " + mergedArraylist);
			tempArrayList2 = task6.createList(new Integer[] { 1, 2, 3, 4 });
			logger.info("After removing elements which is present in one arraylist from another : "
					+ task6.deleteElementsWhichPresent(tempArrayList1, tempArrayList2));
			tempArrayList2 = task6.createList(input2);
			logger.info("After removing elements which is not present in one to another: "
					+ task6.deleteElementsWhichNotPresent(task6.createList(input2), tempArrayList1));
			logger.info("Check whether the element present : " + task6.checkIfPresent(mergedArraylist, 11));
			logger.info("delting all float values form ArrayList : " + task6
					.removeElementsInRange(task6.createList(new Float[] { 0.1f, 0.2f, 0.3f, 0.4f, 0.5f }), 0, 3));
			logger.info("Adding Elements of different types : "
					+ task6.createList(new Object[] { 10, 2.09f, "hello", task6 }));

		} catch (InvalidInputException e) {
			logger.log(Level.INFO, "An Exception occured", e);
		} catch (ClassNotFoundException e) {
			logger.log(Level.INFO, "An Exception occured", e);
		} catch (NoSuchMethodException e) {
			logger.log(Level.INFO, "An Exception occured", e);
		} catch (InstantiationException e) {
			logger.log(Level.INFO, "An Exception occured", e);
		} catch (IllegalAccessException e) {
			logger.log(Level.INFO, "An Exception occured", e);
		} catch (InvocationTargetException e) {
			logger.log(Level.INFO, "An Exception occured", e);
		}
	}
}
