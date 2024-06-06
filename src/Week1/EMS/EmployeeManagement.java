package Week1.EMS;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(emp -> emp.getId() == employeeId);
        System.out.println("Employee removed successfully.");
    }

    public void updateEmployeeInformation(int employeeId, String name, String position, double salary) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                emp.setName(name);
                emp.setPosition(position);
                emp.setSalary(salary);
                System.out.println("Employee information updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void changeDepartment(int employeeId, String newDepartment) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                emp.setDepartment(newDepartment);
                System.out.println("Employee department changed successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void promoteEmployee(int employeeId, String newPosition, double newSalary) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                emp.setPosition(newPosition);
                emp.setSalary(newSalary);
                System.out.println("Employee promoted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void demoteEmployee(int employeeId, String newPosition, double newSalary) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                emp.setPosition(newPosition);
                emp.setSalary(newSalary);
                System.out.println("Employee demoted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public Employee findEmployeeById(int employeeId) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                return emp;
            }
        }
        return null;
    }

//    public String findDepartmentById(int departmentId) {
//        for (Employee emp : employees) {
//            if (emp.getDepartment().getId() == departmentId) {
//                return emp.getDepartment();
//            }
//        }
//        return null;
//    }
}

