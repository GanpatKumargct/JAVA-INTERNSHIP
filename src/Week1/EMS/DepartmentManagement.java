package Week1.EMS;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManagement {
    private List<Department> departments;

    public DepartmentManagement() {
        this.departments = new ArrayList<>();
    }

    public void createDepartment(Department department) {
        departments.add(department);
        System.out.println("Department created successfully.");
    }

    public void assignEmployeeToDepartment(Employee employee, Department department) {
        if (!departments.contains(department)) {
            System.out.println("Department not found.");
            return;
        }
        department.assignEmployee(employee);
        System.out.println("Employee assigned to department successfully.");
    }

    public void manageDepartmentBudget(int departmentId, double newBudget) {
        for (Department dept : departments) {
            if (dept.getId() == departmentId) {
                dept.setBudget(newBudget);
                System.out.println("Department budget updated successfully.");
                return;
            }
        }
        System.out.println("Department not found.");
    }
}
