
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        Student s = (Student) ois.readObject();
        IO.println(s);
        try {
            while (s != null) {
                students.add(s);
                s = (Student) ois.readObject();
            }
        } catch (Exception e) {

        }
        Student[] studentArr = new Student[students.size()];
        
        for (int i = 0; i < studentArr.length; i++) {
            studentArr[i] = students.get(i);
        }
        ois.close();
        return studentArr;
        
    }

    public static void main() { 
        try {
            ClassManager.writeStudent("Henry", 18, "Princeton University", "henrycantor.dat");
            IO.println(Arrays.deepToString(ClassManager.readStudents("henrycantor.dat")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}