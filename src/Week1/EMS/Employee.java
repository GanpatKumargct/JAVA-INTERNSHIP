package Week1.EMS;

import java.util.List;

public class Employee {
    private String name;
    private int id;
    private String position;
    private String department;
    private double salary;
    private Employee supervisor;
    private int supervisorId;
    private  List<Employee> subordinates;
    private  List<String> performanceMetrics;






    //Constructor for Each Attributes
    public Employee(String name, int id, String position, String department,
                    double salary, int supervisorId) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.department = department;
        this.salary = salary;
        this.supervisorId = supervisorId;

    }






    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public List<String> getPerformanceMetrics() {
        return performanceMetrics;
    }



    //Method.........

    //Adding Employee
    public void addEmployee(Employee employee) {
        this.subordinates.add(employee);
        employee.setSupervisorId(supervisorId);
    }

    //Removing Employee
    public void removeEmployee(Employee employee) {
        this.subordinates.remove(employee);
        employee.setSupervisorId(0);
    }


    //Update  the Information
    public void updateInformation(String name, String position, String department, double salary) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }


    //Changing the Department
    public void changeDepartment(String newDepartment){
        this.department = newDepartment;
    }


    //Promote
    public void promote(String newPosition, double newSalary){
        this.position = newPosition;
        this.salary = newSalary;
    }

    //Demote
    public void demote(String newPosition, double newSalary){
        this.position = newPosition;
        this.salary = newSalary;
    }

    public void addPerformanceMetric(String metric) {
        this.performanceMetrics.add(metric);
    }

    public void removePerformanceMetric(String metric) {
        this.performanceMetrics.remove(metric);
    }






    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", position='").append(position).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", supervisor Id=").append(supervisorId);
        sb.append(", subordinates=").append(subordinates);
        sb.append(", performanceMetrics=").append(performanceMetrics);
        sb.append('}');
        return sb.toString();
    }
}
