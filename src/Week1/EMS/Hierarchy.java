package Week1.EMS;

import java.util.*;

public class Hierarchy {
    private Map<Integer, Employee> employees;  // Map to store employees by their ID

    // Constructor
    public Hierarchy() {
        this.employees = new HashMap<>();
    }

    // Method to build hierarchy from a list of employees
    public void buildHierarchy(List<Employee> employeeList) {
        for (Employee emp : employeeList) {
            employees.put(emp.getId(), emp);
            if (emp.getSupervisor() != null) {
                emp.getSupervisor().addEmployee(emp);
            }
        }
    }

    // Method to update hierarchy with a new or updated employee
    public void updateHierarchy(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    // Method to find the supervisor of a given employee
    public Employee findSupervisor(int employeeId) {
        Employee employee = employees.get(employeeId);
        return employee != null ? employee.getSupervisor() : null;
    }

    // Method to find subordinates of a given employee
    public List<Employee> findSubordinates(int supervisorId) {
        Employee supervisor = employees.get(supervisorId);
        return supervisor != null ? supervisor.getSubordinates() : Collections.emptyList();
    }

/*
    // Method to promote an employee
    public void promoteEmployee(int employeeId, String newPosition, double newSalary) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            employee.promote(newPosition, newSalary);
        }
    }

    // Method to transfer an employee to a new department
    public void transferEmployee(int employeeId, String newDepartment) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            employee.changeDepartment(newDepartment);
        }
    }

    // Method to terminate an employee
    public void terminateEmployee(int employeeId) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            Employee supervisor = employee.getSupervisor();
            if (supervisor != null) {
                supervisor.removeEmployee(employee);
            }
            employees.remove(employeeId);
        }
    }
*/

    // Method to analyze the structure of the hierarchy
    public void analyzeStructure() {
        for (Employee emp : employees.values()) {
            System.out.println(emp);
        }
    }

    // Method to calculate the depth of the hierarchy
    public int calculateHierarchyDepth() {
        int maxDepth = 0;
        for (Employee emp : employees.values()) {
            int depth = calculateDepth(emp);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        return maxDepth;
    }

    // Helper method to calculate depth of a specific employee
    private int calculateDepth(Employee emp) {
        int depth = 0;
        while (emp.getSupervisor() != null) {
            depth++;
            emp = emp.getSupervisor();
        }
        return depth;
    }

    // Helper method to print subordinates of a given employee
    public void printSubordinates(int employeeId) {
        List<Employee> subordinates = findSubordinates(employeeId);
        for (Employee subordinate : subordinates) {
            System.out.println(subordinate);
        }
    }
}
