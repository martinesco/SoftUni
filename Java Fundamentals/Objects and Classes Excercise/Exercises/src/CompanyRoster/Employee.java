package CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    public Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}

