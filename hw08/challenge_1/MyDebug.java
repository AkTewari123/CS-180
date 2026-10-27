package challenge_1;

import java.io.*;

public class MyDebug {

    public static int parseAge(String age) throws StudentException {

        try {

            int input = Integer.parseInt(age);

            return input;
        } catch (NumberFormatException e) {

            throw new StudentException("Age is invalid.");

        }
    }

    public static void validateAge(int age) throws StudentException {

        if (age < 0) {
            throw new StudentException("Age cannot be negative.");
        }

        if (age > 150) {
            throw new StudentException("Age is too large.");
        }
    }

    public static String getStudentProgram(String program) throws StudentException {
        if (program.length() == 0 || program.isEmpty() || program == null) {
            throw new StudentException("Program required.");
        }

        return "CS";
    }

    public static void readStudentFile(String fileName) {

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                int age = parseAge(line);

                validateAge(age);

                IO.println("Valid Age: " + age);
            }
            
            br.close();

        } catch (FileNotFoundException e) {

            IO.println("Could not locate file.");

        } catch (StudentException e) {

            IO.println(e.getMessage());

        } catch(IOException e) {
            IO.println(e.getMessage());
        } finally {
            
            IO.println("Finished Loading");

        }
    }

    public static void main(String[] args) {

        try {

            int age = parseAge("twenty");

            validateAge(age);

            
        } catch (StudentException e) {
            
            IO.println(e.getMessage());
            
        } 
        try {
            IO.println(getStudentProgram(""));
        }  catch (StudentException e) {
            
            IO.println(e.getMessage());
            
        } 
        readStudentFile("students.txt");
    }
}