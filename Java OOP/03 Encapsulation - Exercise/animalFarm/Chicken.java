package animalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public double productPerDay() {

        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private double calculateProductPerDay() {
        if (this.getAge() < 6) {
            return 2;
        }
        if (this.getAge() >= 6 && this.getAge() < 12){
            return 1;
        }
        else {
            return 0.75;
        }
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be 1 character.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
