package Week1.EMS;

import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManagement employeeManagement = new EmployeeManagement();
    private static DepartmentManagement departmentManagement = new DepartmentManagement();
    private static PerformanceTracking performanceTracking = new PerformanceTracking();
    private static Security security = new Security("encryption_key"); // Change encryption_key to your actual key

    public static void main(String[] args) {
        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    employeeManagementMenu();
                    break;
                case 2:
                    departmentManagementMenu();
                    break;
                case 3:
                    performanceTrackingMenu();
                    break;
                case 4:
                    securityMenu();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Employee Management");
        System.out.println("2. Department Management");
        System.out.println("3. Performance Tracking");
        System.out.println("4. Security Settings");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void employeeManagementMenu() {
        int choice;
        do {
            System.out.println("\nEmployee Management Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee Information");
            System.out.println("4. Change Department");
            System.out.println("5. Promote Employee");
            System.out.println("6. Demote Employee");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter the Employee Name : ");
                    String Name = scanner.nextLine();

                    System.out.print("Employee Id : ");
                    int Id = scanner.nextInt();

                    System.out.print("Enter Employee Position : ");
                    String position = scanner.next();

                    System.out.print("Enter Department : ");
                    String Dept = scanner.next();

                    System.out.print("Enter Employee Salary : ");
                    double salary = scanner.nextDouble();

                    System.out.print("Supervisor Id: ");
                    int supervisorId = scanner.nextInt();

                    Employee emp = new Employee(Name,Id,position,Dept,salary,supervisorId);
                    employeeManagement.addEmployee(emp);
                    break;
                case 2:
                    System.out.print("Employee Id : ");
                    int empid = scanner.nextInt();
                    employeeManagement.removeEmployee(empid);
                    break;
                case 3:
                    //  Update Employee Information
                    System.out.print("Enter the Employee Id : ");
                    int empId = scanner.nextInt();

                    System.out.print("Enter the Employee Name : ");
                    String empname = scanner.nextLine();

                    System.out.print("Enter new Position : ");
                    String newPosition = scanner.next();

                    System.out.print("Enter New Salary : ");
                    double newSalary = scanner.nextDouble();

                    employeeManagement.updateEmployeeInformation(empId,empname,newPosition,newSalary);

                    break;
                case 4:
                    // Change Department
                    System.out.print("Enter Employee Id : ");
                    int chEmpId = scanner.nextInt();

                    System.out.print("Enter the new Department : ");
                    String newDepartment = scanner.next();

                    employeeManagement.changeDepartment(chEmpId,newDepartment);
                    break;
                case 5:
                    // Promote Employee
                    System.out.print("Enter the Employee Id : ");
                    int pEmpid = scanner.nextInt();

                    System.out.print("Enter the new Position : ");
                    String pnewPosition = scanner.next();
                    scanner.nextLine(); // Consume newline character


                    System.out.print("Enter new salary : ");
                    double pnewsalary = scanner.nextDouble();

                    employeeManagement.promoteEmployee(pEmpid,pnewPosition,pnewsalary);
                    break;
                case 6:
                    // Demote Employee
                    System.out.print("Enter the Employee Id : ");
                    int dEmpid = scanner.nextInt();

                    System.out.print("Enter the new Position : ");
                    String dnewPosition = scanner.next();
                    scanner.nextLine(); // Consume newline character


                    System.out.print("Enter new salary : ");
                    double dnewsalary = scanner.nextDouble();

                    employeeManagement.demoteEmployee(dEmpid,dnewPosition,dnewsalary);
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...");
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void departmentManagementMenu() {
        int choice;
        do {
            System.out.println("\nDepartment Management Menu");
            System.out.println("1. Create Department");
            System.out.println("2. Assign Employee to Department");
            System.out.println("3. Manage Department Budget");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    //  Create Department
                    System.out.print("Enter the Department Name : ");
                    String depName = scanner.next();
                    scanner.nextLine(); // Consume newline character


                    System.out.print("Enter the Department ID : ");
                    int depId = scanner.nextInt();

                    System.out.print("Enter the budget : ");
                    double budget = scanner.nextDouble();


                    departmentManagement.createDepartment(new Department(depName,depId,null,budget));
                    break;
                case 2:
                    // Assign Employee to Department
                    System.out.print("Enter employee id: ");
                    int empId = scanner.nextInt();
                    System.out.print("Enter department id: ");
                    int deptId = scanner.nextInt();
                    Department department = employeeManagement.findDepartmentById(deptId); // Assuming this method exists
                    Employee employee = employeeManagement.findEmployeeById(empId); // Assuming this method exists
                    departmentManagement.assignEmployeeToDepartment(employee, department);

                    break;
                case 3:
                    //Manage Department Budget
                    System.out.print("Enter the Department Id : ");
                    int DeptId = scanner.nextInt();

                    System.out.print("Enter the Budget : ");
                    double newBudget = scanner.nextDouble();

                    departmentManagement.manageDepartmentBudget(DeptId,newBudget);
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void performanceTrackingMenu() {
        int choice;
        do {
            System.out.println("\nPerformance Tracking Menu");
            System.out.println("1. Track Employee Performance");
            System.out.println("2. Generate Performance Reports");
            System.out.println("3. Identify Top Performers");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    // Track Employee Performance
                    System.out.print("Enter employee ID to track performance: ");
                    int employeeIdToTrackPerformance = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.print("Enter performance metric: ");
                    String performanceMetric = scanner.nextLine();

                    System.out.print("Enter performance value: ");
                    int performanceValue = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    performanceTracking.trackPerformance(employeeIdToTrackPerformance, performanceMetric, performanceValue);
                    System.out.println("Employee performance tracked successfully.");
                    break;
                case 2:
                    //  Generate Performance Reports
                    System.out.print("Enter the Employee Id : ");
                    int EmploId = scanner.nextInt();

                    performanceTracking.generateReport(EmploId);
                    break;
                case 3:
                    //Identify Top Performers

                    performanceTracking.identifyTopPerformers();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void securityMenu() {
        int choice;
        do {
            System.out.println("\nSecurity Settings Menu");
            System.out.println("1. Change Credentials");
            System.out.println("2. Log Out");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    // Change Credentials
                    System.out.print("Enter User Name : ");
                    String Uname = scanner.nextLine();

                    System.out.print("Enter the new password : ");
                    String newpassword = scanner.nextLine();

                    security.changeCredentials(Uname,newpassword);

                    break;
                case 2:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }
}

