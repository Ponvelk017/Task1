package tasksrunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import inputcheck.InvalidInputException;
import task.DataBaseTask;
import task.DependantDetail;
import task.Employee;

public class DataBaseTaskRunner {

	private static Logger logger = Logger.getLogger(DataBaseTaskRunner.class.getName());
	
	public void taskRuner() throws InvalidInputException {
		DataBaseTask task = new DataBaseTask();
//		logger.info(task.createDependantTabel());
//		logger.info("The new Table creation Status :" +task.createTable());
		logger.info("Inserting a value :");
		Employee newrecord = new Employee();
		newrecord.setName("Karnan");
		newrecord.setMobile("9898989898");
		newrecord.setEmail("karnan@abc.com");
		newrecord.setDepartment("Design");
		task.insertRecords(newrecord);
		logger.info("The record of karnan is ");
		List<Employee> temp= task.employeeRecord(newrecord.getId());
		for(Employee individualData: temp) {
			logger.info(" "+individualData.getName()+" "+individualData.getMobile()+" "+individualData.getEmail()+" "+individualData.getDepartment());
			newrecord.setId(individualData.getId());
			newrecord.setName(individualData.getName());
			newrecord.setMobile(individualData.getMobile());
			newrecord.setEmail(individualData.getEmail());
			newrecord.setDepartment(individualData.getDepartment());
		}
		
		logger.info("Changing the value of karnan's mobile to 1020304050 ");
		task.modifyRecords("Mobile", "1020304050" , newrecord.getId());
		temp= task.employeeRecord(newrecord.getId());
		for(Employee individualData: temp) {
			logger.info(" "+individualData.getName()+" "+individualData.getMobile()+" "+individualData.getEmail()+" "+individualData.getDepartment());
		}
		
		logger.info("All records");
		temp= task.employeesRecord("Name" , "Desc" , 5);
		for(Employee individualData: temp) {
			logger.info(" "+individualData.getName()+" "+individualData.getMobile()+" "+individualData.getEmail()+" "+individualData.getDepartment());
		}
		
		logger.info("Deleting the karnan record ");
		task.deleteRecords(newrecord.getId());
		logger.info("All records");
		temp= task.employeesRecord("Id" , "" ,5);
		for(Employee individualData: temp) {
			logger.info(" "+individualData.getName()+" "+individualData.getMobile()+" "+individualData.getEmail()+" "+individualData.getDepartment());
		}
	
		logger.info("Inserting values in Additional Information table");
		DependantDetail newAdditionalRecord= new DependantDetail();
		newAdditionalRecord.setEmployeeId(3);
		newAdditionalRecord.setName("Leo");
		newAdditionalRecord.setAge(51);
		newAdditionalRecord.setRelationship("Father");
		task.insertDepandentRecord(newAdditionalRecord);
		
//		logger.info("The additional details after adding Karnan");
//		Map<Integer, DependantDetail> temp2= task.employeeInformation(1);
//		for(Entry<Integer, DependantDetail> entry : temp2.entrySet()) {
//			logger.info("Employee Name"+entry.getKey());
//			DependantDetail dependentinfo = entry.getValue();
//			logger.info("Name : "+dependentinfo.getName()+" Age : "+dependentinfo.getAge()+"Relation : "+dependentinfo.getRelationship());
//		}
		logger.info("The Joint details of first 2 employees");
		Map<Integer, ArrayList<DependantDetail>> temp3= task.employeeInformation(10); 
		for(Entry<Integer, ArrayList<DependantDetail>> entry : temp3.entrySet()) {
			logger.info("Employee Name"+entry.getKey());
			ArrayList <DependantDetail> list = entry.getValue();
			for(DependantDetail individualinfo : list) {
				logger.info("Name : "+individualinfo.getName()+" Age : "+individualinfo.getAge()+"Relation : "+individualinfo.getRelationship());
			}
		}
		task.getEmployeesId(10);
	}
	
}
