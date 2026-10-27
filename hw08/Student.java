import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public int age;
    public String program;

    public Student(String name, int age, String program) {
        this.name = name;
        this.age = age;
        this.program = program;
    }
    
    @Override
    public String toString() {
        return String.format("Name: %s, age: %d, program: %s", name, age, program);
    }
}