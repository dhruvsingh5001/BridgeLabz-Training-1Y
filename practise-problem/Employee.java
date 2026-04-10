import java.util.ArrayList;

class Employee{
private String name;
private int id;
private String email;

public Employee(String name, int id, String email) {
this.name = name;
this.id = id;
this.email = email;
}

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

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

@Override
public String toString() {
return "Employee{" +
"name='" + name + '\'' +
", id=" + id +
", email='" + email + '\'' +
'}';
}
}
public class EmployeeMangement {
public static void main(String[] args) {
Employee e1 = new Employee("Samar",10001, "samar@gmail.com");
Employee e2 = new Employee("Ankita",10002, "ankita@gmail.com");
Employee e3 = new Employee("Arya",10003,"arya@gmail.com");
Employee e4 = new Employee("Veer",10004,"veer@gmail.com");
ArrayList<Employee> al = new ArrayList<>();
al.add(e1);
al.add(e2);
al.add(e3);
al.add(e4);
System.out.println(al);
for (Employee e : al){
System.out.println(e);
}
Employee updatedEmp = new Employee("Arayan",10003,"weqw");
al.set(2,updatedEmp);
System.out.println(al);
}
}