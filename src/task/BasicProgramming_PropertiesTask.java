package task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import util.Util;

public class BasicProgramming_PropertiesTask {
	private final Logger logger = Logger.getLogger(BasicProgramming_PropertiesTask.class.getName());
	
	BasicProgramming_FileTask fileTask = new BasicProgramming_FileTask();

	public Properties createProperties() {
		return new Properties();
	}

	public Properties addValuesToProperty(Properties properties, String key, String Value)
			throws InvalidInputException, FileNotFoundException {
		Util.checkNull(properties);
		Util.checkNull(key);
		Util.checkNull(Value);
		properties.setProperty(key, Value);
		return properties;
	}

	public void storeProperties(String inputFile, Properties properties) throws InvalidInputException, IOException {
		Util.checkNull(inputFile);
		Util.checkNull(properties);
		try (FileOutputStream fileOutputStream = new FileOutputStream(inputFile);) {
			properties.store(fileOutputStream, "The Stored Properties");
		} 
	}

	public void readFromFile(String fileLocation) throws InvalidInputException, IOException {
		Util.checkNull(fileLocation);
		Properties properties = new Properties();
		try (FileReader fileReader = new FileReader(fileLocation);) {
			properties.load(fileReader);
			fileTask.readInFile(fileLocation);
			printProperties(properties);
		}
	}

	public void printProperties(Properties properties) throws InvalidInputException {
		Util.checkNull(properties);
		for (Entry entry : properties.entrySet()) {
			logger.info(entry.getKey() + " " + entry.getValue());
		}
	}
}
