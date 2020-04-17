package StudentSystem;

public interface Command {
    void execute(StudentRepository repository, String[] args);
}
