package Week1.EMS;

import java.util.*;

public class Department {
    private String name;
    private int id;
    private Employee manager;
    private List<Employee> employees;
    private double budget;
    private Map<String, Integer> resources;

    // Constructor
    public Department(String name, int id, Employee manager, double budget) {
        this.name = name;
        this.id = id;
        this.manager = manager;
        this.employees = new ArrayList<>();
        this.budget = budget;
        this.resources = new HashMap<>();
        if (manager != null) {
            this.employees.add(manager);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    // Create department method
    public static Department createDepartment(String name, int id, Employee manager, double budget) {
        return new Department(name, id, manager, budget);
    }

    // Assign employee to department
    public void assignEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this.name);
        }
    }

    // Manage budget method
    public void manageBudget(double amount, boolean isAddition) {
        if (isAddition) {
            this.budget += amount;
        } else {
            if (amount <= this.budget) {
                this.budget -= amount;
            } else {
                System.out.println("Insufficient budget.");
            }
        }
    }

    // Analyze performance (Placeholder method, implement as needed)
    public void analyzePerformance() {
        // Placeholder for analyzing department performance
        System.out.println("Analyzing performance for department: " + this.name);
        // Perform necessary analysis here
    }

    // Add resource to department
    public void addResource(String resource, int quantity) {
        this.resources.put(resource, this.resources.getOrDefault(resource, 0) + quantity);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee getManager() {
        return manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getBudget() {
        return budget;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", manager=" + (manager != null ? manager.getName() : "None") +
                ", employees=" + employees.size() +
                ", budget=" + budget +
                ", resources=" + resources +
                '}';
    }
}
