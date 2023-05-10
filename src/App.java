import java.sql.SQLException;
import java.util.Scanner;
public class App {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EmployeeView view = new EmployeeView(sc);
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeController controller = new EmployeeController(view, dao);
		
		boolean systemOn = true;
		
		do{
			int userOption = view.displayMenu();
			switch(userOption) {
				case 1:
					controller.displayAllEmployees();
					break;
				case 2:
					controller.displayEmployee();
					break;
				case 3:
					controller.displayEmployeesFilteredByAge();
					break;
				case 4:
					controller.addEmployee();
					break;
				case 5: 
					controller.updateEmployee();
					break;
				case 6:
					controller.deleteEmployee();
					break;
				case 7:
					systemOn = controller.closeSystem();
					break;
				default:
					userOption = view.displayMenu();
					
			}
			
		}while(systemOn);

	}

}
