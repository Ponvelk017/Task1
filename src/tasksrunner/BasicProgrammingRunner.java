package tasksrunner;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.BasicProgramming_FileTask;
import task.BasicProgramming_PropertiesTask;

public class BasicProgrammingRunner {

	private Logger logger = Logger.getLogger(BasicProgrammingRunner.class.getName());

	public void taskrunner() {
		try (Scanner scanner = new Scanner(System.in);) {
			BasicProgramming_FileTask fileTask = new BasicProgramming_FileTask();
			BasicProgramming_PropertiesTask propertiesTak = new BasicProgramming_PropertiesTask();
			try {
				logger.info("To creating a new file , enter the location : ");
				String location = scanner.next();
				logger.info("To creating a new file , enter the filename : ");
				String filename = scanner.next();
				fileTask.createFile(location, filename);
				logger.info("Enter the File location to write in the file : ");
				String filelocation = scanner.next();
				scanner.nextLine();
				logger.info("Enter the data to write in the file : ");
				fileTask.writeInFile(filelocation, scanner.nextLine());
				logger.info("The file contains : \n" + fileTask.readInFile(filelocation));

				Properties newProperties = propertiesTak.createProperties();
				logger.info("Enter the Properties value");
				int loop = 3;
				while ((loop--) > 0) {
					newProperties = propertiesTak.addValuesToProperty(newProperties, scanner.next(), scanner.next());
				}
				logger.info("To store the properties values enter the file location and filename : ");
				String properties_FileLocation = scanner.next();
				String properties_FileName = scanner.next();
				fileTask.createFile(properties_FileLocation, properties_FileName);
				logger.info("Enter the File location to write properties data in the file : ");
				properties_FileLocation = scanner.next();
				propertiesTak.storeProperties(properties_FileLocation, newProperties);
				logger.info("The Properties file contains : " + fileTask.readInFile(properties_FileLocation));
				logger.info("Reading the properties file and print using the Properties : ");
				propertiesTak.readFromFile(properties_FileLocation);
				logger.info("To creating a directory, enter the location and directory name : ");
				String directoryLocation = scanner.next();
				String directoryName = scanner.next();
				fileTask.createDirectory(directoryLocation, directoryName);
				logger.info(
						"To add the creted files to destination directory , enter the file location and directory location");
				fileTask.putFileInLocation(scanner.next(), scanner.next());

			} catch (IOException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			} catch (InvalidInputException e) {
				logger.log(Level.INFO, "An Exception Occured", e);
			}
		}

	}
}
