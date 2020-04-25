package salaryIncrease;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() > 30) {
            double newSalary = getSalary() + getSalary()  * bonus / 100;
            setSalary(newSalary);
        } else {
            double newSalary = getSalary()  + getSalary()  * bonus / 200;
            setSalary(newSalary);
        }
    }

    @Override
    public String toString() {
        //DecimalFormat format = new DecimalFormat("#.#");
        return String.format("%s %s gets %s leva",
                this.firstName,
                this.lastName,
                this.salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
