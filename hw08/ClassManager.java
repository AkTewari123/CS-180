package hw08;
import java.io.*;
import java.util.ArrayList;

class ClassManager {
    public static void writeStudent(String name, int age, String program, String fileName) throws Exception {
        try {
            Student student = new Student(name, age, program);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(student);

            oos.close();

        } catch (Exception e) {
            throw new Exception();
        }

    } 
    public static Student[] readStudents(String fileName) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

        ArrayList<Student> students = new ArrayList<Student>();
        Student s = null;
        while ((s = (Student) ois.readObject()) != null) {
            students.add(s);
        }

        return (Student[]) students.toArray();


    }

    public static void main() { 
        try {
            ClassManager.writeStudent("Henry", 18, "Princeton University", "henrycantor.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}