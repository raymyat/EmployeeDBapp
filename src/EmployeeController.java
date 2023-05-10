import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
	EmployeeView view;
	EmployeeDAO dao;
	
	public EmployeeController(EmployeeView view, EmployeeDAO dao) {
		this.view = view;
		this.dao = dao;
	}
	/* Display all employee */
	public void displayAllEmployees() {
		List<Employee> employeeList = null;
		employeeList = dao.getEmployees();
		view.displayEmployeeList(employeeList);
	}
	/* Display employee by ID */
	public void displayEmployee() {
		int empId = view.getEmployeeID();
		Employee employeeList = null;
		employeeList = dao.getEmployeeById(empId);
		view.displayEmployee(employeeList);
	}
	/* Filter employee by age */
	public void displayEmployeesFilteredByAge() {
		int[] ageRange = view.getAgeRange();
		List<Employee> employeeList = null;
		employeeList = dao.getEmployeesFilteredByAge(ageRange);
		view.displayEmployeeList(employeeList);
	}
	
	/* Add employee */
	public void addEmployee() {
		Employee em = view.getEmployeeDetails();
		dao.addEmployee(em.getId(), em.getName(), em.getAge());
	}
	
	/* Update employee age */
	public void updateEmployee() {
		int id = view.getEmployeeID();
		int age = view.getAge();
		dao.updateEmployee(id, age);
	}
	
	/* Delete employee */
	public void deleteEmployee() {
		int id = view.getEmployeeID();
		dao.deleteEmployee(id);
	}
	
	public Boolean closeSystem() throws SQLException {
		view.systemEnd();
		dao.endConnection();
		return false;
	}

}
