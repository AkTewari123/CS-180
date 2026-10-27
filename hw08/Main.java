import java.io.*;

/**
 * Rain report: reads rain.txt (one day's rainfall per line, in millimetres),
 * and writes rain-report.txt with the count, total, average and wettest day.
 * If rain.txt is missing, prints one line saying so and writes nothing.
 *
 * @author your name, your lab section
 * @version the date you finished
 */
public class Main {
    public static void main(String[] args) {

        try {
        BufferedReader br = new BufferedReader(new FileReader("rain.txt"));

        String line = br.readLine();
        double avg = 0;
        double total = 0;
        double wettest = 0;
        int count = 0;


        while (line != null) {
            IO.println(line);
            double doubLine = Double.parseDouble(line);
            total += doubLine;
            if (doubLine > wettest) {
                wettest = doubLine;
            }
            ++count;
            line = br.readLine();
        }

        avg = total / count;
        br.close();

        PrintWriter pw = new PrintWriter(new FileOutputStream("rain-report.txt", true));

        pw.println(String.format("Days: %d", count));
        pw.println(String.format("Total: %.1f mm", total));
        pw.println(String.format("Average: %.2f mm", avg));
        pw.print(String.format("Wettest: %.1f mm", wettest));

        pw.close();
        } catch (FileNotFoundException e) {
            IO.println(e.getMessage());
        } catch (IOException e) {
            IO.println(e.getMessage());

        }


    }
}