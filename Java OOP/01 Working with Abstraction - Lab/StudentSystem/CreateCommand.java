package StudentSystem;

public class CreateCommand implements Command {

    public void execute(StudentRepository repo, String[] args) {

        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        if (!repo.containsStudentByName(name)) {
            Student student = new Student(name, age, grade);
            repo.registerStudent(name, student);
        }
    }
}
