package tasksrunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.Circle;

public class CircleRunner {
	private Logger logger = Logger.getLogger(CircleRunner.class.getName());

	public void taskRunner() {
		Circle circle;
		String fileName = "Properties.log";
		FileHandler logFileHandler;
		try {
			logFileHandler = new FileHandler(fileName, true);
			logger.addHandler(logFileHandler);
		} 
		catch (IOException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}

		try {
			circle = new Circle("2*3.14*radius", 10);
			logger.info(circle.toString());
			circle = new Circle();
			circle.setFormula("2*3.14*radius");
			circle.setRadius(5);
			logger.info(circle.getFormula() + " " + circle.getRadius());

		} 
		catch (InvalidInputException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		} 

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String individualLine = "";
			while ((individualLine = bufferedReader.readLine()) != null) {
				logger.info(individualLine);
			}
		} 
		catch (FileNotFoundException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		} 
		catch (IOException e) {
			logger.log(Level.INFO, "An Exception Occured", e);
		}
	}
}
