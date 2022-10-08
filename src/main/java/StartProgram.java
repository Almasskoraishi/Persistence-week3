import java.util.List;
import java.util.Scanner;
import controller.EmployeeListHelper;
import model.EmployeeList;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static EmployeeListHelper elh = new EmployeeListHelper();
	
	private static void addEmployee() {
		// TODO Auto-generated method stub
		System.out.print("Enter an employee first name: ");
		String empFirstName = in.nextLine();
		System.out.print("Enter an employee last name: ");
		String empLastName = in.nextLine();
		EmployeeList toAdd = new EmployeeList(empFirstName, empLastName);
		elh.insertEmp(toAdd);

	}
	
	private static void deleteEmployee() {
		// TODO Auto-generated method stub
		System.out.print("Enter employee first name to delete: ");
		String empFirstName = in.nextLine();
		System.out.print("Enter employee last name to delete: ");
		String empLastName = in.nextLine();
		EmployeeList toDelete = new EmployeeList(empFirstName, empLastName);
		elh.deleteEmpployee(toDelete);

	}
	
	private static void editEmployee() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to edit? ");
		System.out.println("1 : Edit by Employee first name");
		System.out.println("2 : Edit by Employee last name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<EmployeeList> foundEmployee;
		if (searchBy == 1) {
			System.out.print("Enter the employee first name: ");
			String empFirstName = in.nextLine();
			foundEmployee = elh.searchForEmpLastNameByEmpLastName(empFirstName);
		} else {
			System.out.print("Enter the employee last name: ");
			String empLastName = in.nextLine();
			foundEmployee = elh.searchForEmpLastNameByEmpLastName(empLastName);

		}

		if (!foundEmployee.isEmpty()) {
			System.out.println("Found Results.");
			for (EmployeeList l : foundEmployee) {
				System.out.println(l.getEmpId() + " : " + l.toString());
			}
			System.out.print("Which employee ID to edit: ");
			int idToEdit = in.nextInt();

			EmployeeList toEdit = elh.searchForEmpFirstNameById(idToEdit);
			System.out.println("Retrieved " + toEdit.getEmpLastName() + " from " + toEdit.getEmpLastName());
			System.out.println("1 : Update employee first name");
			System.out.println("2 : Update employee last name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New employee first name: ");
				String newEmpFirstName = in.nextLine();
				toEdit.setEmpFirstName(newEmpFirstName);
			} else if (update == 2) {
				System.out.print("New employee last name: ");
				String newEmpLastName = in.nextLine();
				toEdit.setEmpLastName(newEmpLastName);
			}

			elh.updateEmpFirstName(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome Employee list! ---");
		while (goAgain) {
			System.out.println("  Select an Employee:");
			System.out.println("  1 -- Add an employee");
			System.out.println("  2 -- Edit an employee");
			System.out.println("  3 -- Delete an employee");
			System.out.println("  4 -- View the employee list");
			System.out.println("  5 -- Exit the program");
			System.out.print("  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addEmployee();
			} else if (selection == 2) {
				editEmployee();
			} else if (selection == 3) {
				deleteEmployee();
			} else if (selection == 4) {
				viewEmployeeList();
			} else {
				elh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}


	private static void viewEmployeeList() {
		// TODO Auto-generated method stub
		List<EmployeeList> allEmps = elh.showAllEmp();
		for (EmployeeList singleEmp : allEmps) {
			System.out.println(singleEmp.empDetails());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

}