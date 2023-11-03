package employeemanagement.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import employeemanagementsystem.Dao.DepartmentDao;
import employeemanagementsystem.Dao.EmployeeDao;
import employeemanagementsystem.Dao.ProjectDao;

public class Menu {
	
	
	
	
	
	public static String roleName; 
	static Scanner sc = new Scanner(System.in);
	int choice; 
	
	public void login() {
		try(Connection conn = Conn.createConnection()){
			Statement st = Conn.createStatement();
			System.out.println("Login....");
			System.out.println("enter email....");
			String email = sc.next();
			System.out.println("enter password...");
			String password = sc.next();
			String fetchQuery = "select role_id from employee where email=" +email +" "+" and password=" + "password +";
					ResultSet rs =st.executeQuery(fetchQuery);
			if(rs.next()) {
				int role_id = rs.getInt("role_id");
				
				String getRole ="select role_name from role where rolr_id=" + "role_id + ";
						ResultSet rs1 = st.executeQuery(getRole);
				while (rs1.next()) {
					roleName = rs1.getString("role_name");
					System.out.println("Role : " + roleName);
				}}else {
					System.out.println("Wrong credentails. Please check the email and password.");
					login();
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch(InputMismatchException e ) {
			e.printStackTrace();
		}			
						
	}
	
	public void mainMenu() {
		try {
			if(roleName.equals("Admin")) {
				addMenu();
			}else if(roleName.equals("Guest")) {
				guestMenu();
			}
		}catch(NullPointerException e) {
			System.out.println("Not Found !");
		}
	}
	public void addMenu() {
		do {
			System.out.println("Admin menu");
			System.out.println("1. View All Department \n2. Add Department\n3. Modify Department \n4. View All Employees \n5. Add Employee \n6. Modify Employee "
					+ "\n7. View All Projects \n8. Add Project \n9. Modify Project \n10. Exit\n");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : DepartmentDao.getDepartmentList();
			break; 
			case 2 : DepartmentDao.addDepartment();
			break; 
			
			case 3 : DepartmentDao.updateDepartment();;
			break; 
			
			case 4 : EmployeeDao.getEmployeeList();;
			break; 
			
			case 5 : EmployeeDao.addEmployee();
			break; 
			
			case 6 : EmployeeDao.updateEmployee();
			break; 
			
			case 7 : ProjectDao.getProjectList();;
			break; 
			
			case 8 : ProjectDao.addProject();;
			break; 
			
			case 9 : ProjectDao.updateProject();;
			break; 
			
			case 10: System.exit(0);
			break; 
			}
		}while(choice !=10);
	}
	public void guestMenu() {
		do {
			System.out.println(" Guest Menu ");

			System.out.println("1. View All Department \n2. View Department By Id \n3. View All Employees \n4. "
					+ "View Employee By Id \n5. View All Projects \n6. View Project By Id  \n7. Exit\n");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1 : DepartmentDao.getDepartmentList();
				break; 
				
				case 2 : GuestDao.getDepartmentById();
				break; 
					
				case 3 : EmployeeDao.getEmployeeList();
				break; 
				
				case 4 : GuestDao.getEmployeeById();
				break;
				
				case 5 : ProjectDao.getProjectList();
				break; 
				
				case 6 : GuestDao.getProjectById();
				break; 
			
				{
				}while(choice !=7);
				}
		}
	}
}


	
	


