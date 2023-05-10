import java.util.List;
import java.util.Scanner;

public class EmployeeView {
	Scanner sc;

	public EmployeeView(Scanner sc) {
		this.sc = sc;
	}

	public void displayEmployeeList(List<Employee> employees) {
		if (employees.size() != 0) {
			for (Employee e : employees) {
				System.out.println(e);
			}			
		} else {
			System.out.println("No employees found.");
		}
	}

	public void displayEmployee(Employee employee) {
		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("No employee found.");
	}
	
	public int getEmployeeID() {
		System.out.print("Please provide the employee ID: ");
		int id = sc.nextInt();
		return id;
	}

	public int[] getAgeRange() {
		int[] ageRange = new int[2];
		System.out.println("Please provide the age range: ");
		System.out.print("Minimum age: ");
		ageRange[0] = sc.nextInt();;
		System.out.print("Maximum age: ");
		ageRange[1] = sc.nextInt();;
		return ageRange;
	}
	
	public int displayMenu() {
		int userInput;
		System.out.println("===============Employee System===============");
		System.out.println("1. Display all employee");
		System.out.println("2. Display employee detail");
		System.out.println("3. Search employee by age range");
		System.out.println("4. Add an employee");
		System.out.println("5. Update an employee age");
		System.out.println("6. Delete an employee");
		System.out.println("7. Exit program");
		userInput = sc.nextInt();
		if(userInput < 1 || userInput >7) {
			System.out.println("Please enter valid option 1-6");
			userInput = sc.nextInt();
		}
		return userInput;
	}
	
	public int getAge() {
		System.out.print("Please provide new age: ");
		int age = sc.nextInt();
		return age;
	}
	public Employee getEmployeeDetails() {
		boolean isValid = false;
		String strId = "", name = "", strAge = "";
		int id = 0, age = 0;
		do {
			System.out.println("Please enter the id of the new employee: ");
			try {
				id = sc.nextInt();
				isValid = true;
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input! Please enter an integer.");
			}
		} while(!isValid);
		
		isValid = false;
		do {
			System.out.println("Please enter the name of the new employee: ");
			name = sc.next();
			name = name.replaceAll("[^A-za-z]", " ");
			if (name.length() == 0) {
				System.out.println("Invalid input! Please enter at least one alphatic character.");
			}
			isValid = true;
		} while(!isValid);
		
		
		isValid = false;
		do {
			System.out.println("Please enter the age of the new employee: ");
			try {
				age = sc.nextInt();
				age = Math.abs(age);
				isValid = true;
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input! Please enter an integer.");
			}
		} while(!isValid);
		
	
		
		Employee em = new Employee(id, name, age);
		return em;
	}
	public void systemEnd() {
		System.out.print("============System close============");
	}

	
}