
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
	Connection con;
	
	public EmployeeDAO() throws SQLException {
		this.con = DBConnection.getConnection();
	}
	
	/* display employee by Id */
	public Employee getEmployeeById(int empId) {
		Employee employee = null;
		
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
			pst.setInt(1, empId);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next())
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return employee;
	}
	/* display employee */
	public List<Employee> getEmployees() {
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return employeeList;
	}
	
	/* display employee by age */
	public List<Employee> getEmployeesFilteredByAge(int[] ageRange) {
		Employee employee = null;
		List<Employee> filteredEmployees = new ArrayList<>();
		
		try {
			PreparedStatement pst = con.prepareStatement("SELECT * FROM employee WHERE age BETWEEN ? AND ?");
			pst.setInt(1, ageRange[0]);
			pst.setInt(2, ageRange[1]);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
				filteredEmployees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return filteredEmployees;
	}
	
	/* Update employee age */
	public void updateEmployee(int empId, int newAge){
		try {
			
			String query = "UPDATE employee SET age = ? WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, newAge);
			stmt.setInt(2, empId);
			stmt.executeUpdate();
			
			System.out.println("Employee age updated");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Add employee */
	public void addEmployee (int id, String name, int age) {
		try {
			
			PreparedStatement pstAddEmployee = con.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
			pstAddEmployee.setInt(1,id);
			pstAddEmployee.setString(2,name);
			pstAddEmployee.setInt(3,age);
			pstAddEmployee.executeUpdate();
			
			System.out.println("New employee added");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	/* Delete employee */
	public void deleteEmployee(int empId) {
		try {
			
			String query = "DELETE FROM employee WHERE ID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,empId);                                  
			stmt.executeUpdate();
			
			System.out.println("Employee deleted");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	     
		
	}
	
	public void endConnection() throws SQLException {
		con.close();
	}
	

}