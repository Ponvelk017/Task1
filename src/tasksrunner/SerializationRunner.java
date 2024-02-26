package tasksrunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.Employee;
import task.Serialization;

public class SerializationRunner {

	private static Logger logger = Logger.getLogger(CircleRunner.class.getName());

	public void taskRunner() throws InvalidInputException {
		try (Scanner scanner = new Scanner(System.in)) {
			Serialization task = new Serialization();
			logger.info("Enter the file name and File location to create : ");
			task.createFile("SerializedFile.ser" , "/home/ponvel-pt-7323/CodingTasks");
			int loop = 3;
				logger.info("Enter the Employee details to write in the file : ");
				List <Employee> list = new ArrayList<Employee>();
			while(loop-- > 0) {
				Employee employee = new Employee();
				logger.info("Enter the name, mobile number, email, department");
				scanner.nextLine();
				employee.setId(scanner.nextInt());
				employee.setName(scanner.next());
				employee.setMobile(scanner.next());
				employee.setEmail(scanner.next());
				employee.setDepartment(scanner.next());
				list.add(employee);
			}
			logger.info("to write the Employee details in the File enter the file location" );
			task.writeObjects(list, scanner.next());
			logger.info("Printing all data in the file \n Enter the file location :");
			list =task.readObjects(scanner.next());
			for(Employee employee : list) {
				System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getMobile() + " "
						+ employee.getEmail() + " " + employee.getDepartment());
			}

		}
			catch (IOException e) {
			throw new InvalidInputException("AN exception occured" , e);
		}
	}
}

//  /home/ponvel-pt-7323/CodingTasks/SerializedFile.ser
