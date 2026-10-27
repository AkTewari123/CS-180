import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        try {
            File file = new File("log.txt");
            file.createNewFile();
            List<String> lines = Files.readAllLines(Path.of("log.txt"));
            PrintWriter pw = new PrintWriter(new FileOutputStream("log.txt", true));
            IO.println(lines.size());
            pw.println(String.format("Visit %d", lines.size() + 1));

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
