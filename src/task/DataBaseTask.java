package task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import inputcheck.InvalidInputException;
import util.DBConnection;
import util.Util;

public class DataBaseTask {

	private Connection connection = DBConnection.getConnection();
	public final int limit = 50;

	public boolean createTable() throws InvalidInputException {
		boolean result = false;
		String creationQuery = "create table Employees (Id int auto_increment, Name varchar(20) ,Mobile varchar(10) ,Email varchar(30) ,Department varchar(20),primary key(Id))";
		try (PreparedStatement tableCreation = connection.prepareStatement(creationQuery);) {
			result = tableCreation.execute();
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}

	public boolean createDependantTabel() throws InvalidInputException {
		boolean result = false;
		String createTableQuery = "create table DependentTabel (Id int auto_increment, EmployeeId int , Name varchar(20) , Age int , RelationShip varchar(10) ,primary key(Id),"
				+ "foreign key(EmployeeId) references Employees(Id) on delete cascade)";
		try (PreparedStatement tableCreation = connection.prepareStatement(createTableQuery);) {
			result = tableCreation.execute();
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}

	public boolean insertRecords(Employee employee) throws InvalidInputException {
		Util.checkNull(employee);
		boolean result = false;
		String insertQuery = "insert into Employees(Name,Mobile,Email,Department) values(?,?,?,?)";
		try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery);) {
			insertStatement.setString(1, employee.getName());
			insertStatement.setString(2, employee.getMobile());
			insertStatement.setString(3, employee.getEmail());
			insertStatement.setString(4, employee.getDepartment());
			result = insertStatement.execute();
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}

	public boolean insertDepandentRecord(DependantDetail additionalInformation) throws InvalidInputException {
		Util.checkNull(additionalInformation);
		boolean result = false;
		String insertQuery = "insert into DependentTabel(EmployeeId,Name,Age,Relationship) values(?,?,?,?)";
		try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery);) {
			insertStatement.setInt(1, additionalInformation.getEmployeeId());
			insertStatement.setString(2, additionalInformation.getName());
			insertStatement.setInt(3, additionalInformation.getAge());
			insertStatement.setString(4, additionalInformation.getRelationship());
			result = insertStatement.execute();
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}

	public int modifyRecords(String coloum, String newRecord, int id) throws InvalidInputException {
		Util.checkNull(coloum);
		Util.checkNull(newRecord);
		int rowsAffected = 0;
		String modifingQuery = "update Employees set " + coloum + " = ? where Id = ?";
		try (PreparedStatement modifyStatement = connection.prepareStatement(modifingQuery)) {
			modifyStatement.setString(1, newRecord);
			modifyStatement.setInt(2, id);
			rowsAffected = modifyStatement.executeUpdate();
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return rowsAffected;
	}

	public boolean deleteRecords(int id) throws InvalidInputException {
		boolean result = false;
		String deleteQuery = "delete from Employees where Id = ?";
		try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
			deleteStatement.setInt(1, id);
			result = deleteStatement.execute();
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}

	public List<Employee> retrivingRecords(PreparedStatement statement) {
		List<Employee> result = new ArrayList<Employee>();
		try (ResultSet retrivalResultSet = statement.executeQuery();) {
			while (retrivalResultSet.next()) {
				Employee individualRecord = new Employee();
				individualRecord.setId(retrivalResultSet.getInt("Id"));
				individualRecord.setName(retrivalResultSet.getString("Name"));
				individualRecord.setMobile(retrivalResultSet.getString("mobile"));
				individualRecord.setEmail(retrivalResultSet.getString("Email"));
				individualRecord.setDepartment(retrivalResultSet.getString("Department"));
				result.add(individualRecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Employee> employeeRecord(int id) throws InvalidInputException {
		List<Employee> result = new ArrayList<Employee>();
		String retrivalQuery = "select * from Employees where id = ? ";
		try (PreparedStatement retrivalStatement = connection.prepareStatement(retrivalQuery)) {
			retrivalStatement.setInt(1, id);
			result = retrivingRecords(retrivalStatement);
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}

	public List<Employee> employeesRecord(String orderByColumn, String order, int limit) throws InvalidInputException {
		Util.checkNull(order);
		Util.checkNull(orderByColumn);
		List<Employee> result = new ArrayList<Employee>();
		String retrivalQuery = "select * from Employees order by " + orderByColumn + " " + order + " limit " + limit;
		try (PreparedStatement retrivalStatement = connection.prepareStatement(retrivalQuery)) {
			result = retrivingRecords(retrivalStatement);
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	} 

	public String getEmployeesId(int limit) {
		StringBuilder result = new StringBuilder("(");
		String query = "select Id from Employees limit " + limit;
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					result.append(resultSet.getInt("Id") + ",");
				}
				result.replace(result.length() - 1, result.length(), ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public Map<Integer, ArrayList<DependantDetail>> employeeInformation(int limit) throws InvalidInputException {/// ???Must check -Swami
		String retrivalQuery = "select * from DependentTabel where EmployeeId in " + getEmployeesId(limit);
		Map<Integer, ArrayList<DependantDetail>> result = new TreeMap<Integer, ArrayList<DependantDetail>>();
		try (PreparedStatement retrivalStatement = connection.prepareStatement(retrivalQuery);) {
			try (ResultSet retrivalResultSet = retrivalStatement.executeQuery();) {
				while (retrivalResultSet.next()) {
					int employeeId = retrivalResultSet.getInt("EmployeeId");
					ArrayList<DependantDetail> temp = result.get(employeeId);
					if (temp == null) {
						temp = new ArrayList<DependantDetail>();
						result.put(employeeId, temp);
					}
					DependantDetail individualRecord = new DependantDetail();
					individualRecord.setId(retrivalResultSet.getInt("Id"));
					individualRecord.setEmployeeId(retrivalResultSet.getInt("EmployeeId"));
					individualRecord.setName(retrivalResultSet.getString("Name"));
					individualRecord.setAge(retrivalResultSet.getInt("Age"));
					individualRecord.setRelationship(retrivalResultSet.getString("Relationship"));
					temp.add(individualRecord);
					result.put(retrivalResultSet.getInt("EmployeeId"), temp);
				}
			}
		} catch (SQLException e) {
			throw new InvalidInputException("Some error Occured", e);
		}
		return result;
	}
}
