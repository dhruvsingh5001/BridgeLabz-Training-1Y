class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String managerLevel;

    public Manager(int employeeID, String department, double salary, String managerLevel) {
        super(employeeID, department, salary);
        this.managerLevel = managerLevel;
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Manager Level: " + managerLevel);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "IT", 50000);
        emp.displayEmployeeDetails();

        emp.setSalary(60000);
        System.out.println("\nUpdated Salary: " + emp.getSalary());

        Manager mgr = new Manager(201, "HR", 80000, "Senior Manager");
        System.out.println("\nManager Details:");
        mgr.displayManagerDetails();
    }
}
