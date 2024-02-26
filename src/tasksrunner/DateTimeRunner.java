package tasksrunner;

import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.DateTimeTask;

public class DateTimeRunner {
	private final Logger logger = Logger.getLogger(DateTimeRunner.class.getName());

	DateTimeTask dateTimeTask = new DateTimeTask();

	public void taskRunner() throws InvalidInputException {
		try (Scanner scanner = new Scanner(System.in);) {
			logger.info("The current date and time is : " + dateTimeTask.getCurrentDateTime());
			logger.info("The current date and time in millisecond : " + dateTimeTask.getCurrentTimeInMillSec());
			Set<String> allZoneId = dateTimeTask.allZones();
			for (String zone : allZoneId) {
				System.out.println(zone);
			}
			logger.info("The current date and time in millisecond of NewYork and London : "
					+ dateTimeTask.getZoneCurrentDateTime(scanner.next()));
			logger.info("The current date and time in millisecond of NewYork and London : "
					+ dateTimeTask.getZoneCurrentDateTime(scanner.next()));
			logger.info("The current day of the week : "
					+ dateTimeTask.getDayOfWeek(dateTimeTask.getZoneCurrentDateTime(scanner.next())));
			logger.info("The current Month of the current time: "
					+ dateTimeTask.getMonth(dateTimeTask.getZoneCurrentDateTime(scanner.next())));
			logger.info("The current year of the current time : "
					+ dateTimeTask.getYear(dateTimeTask.getZoneCurrentDateTime(scanner.next())));
		}
	}
}
