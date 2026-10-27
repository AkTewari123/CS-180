
import java.io.*;
import java.util.Arrays;

class FavoriteMovies {
    public static String[] readMovies(String fileName) {
        try {
            
            BufferedReader counter = new BufferedReader(new FileReader(fileName));
            int i = 0;
            String line = "x";


            while ((line = counter.readLine()) != null) {
                i++;
                IO.println("counting = " + line + ", i: " + i);
            }

            IO.println("length: " + i);
            var movies = new String[i];

            i = 0;
            counter.close();

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                IO.println("current idx: " + i);
                IO.println("current line: " + line);
                movies[i++] = line;
            }

            br.close();

            return movies;

        } catch (Exception e) {
            // IO.println("stfu");
            e.printStackTrace();

        } 

        return new String[3];



    }

    public static int writeMovies(String fileName, String[] movies) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
            for (var movie : movies) {
                pw.println(movie);
            }

            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

        return movies.length;
    }
    public static void main(String[] args) {
        // String[] output = FavoriteMovies.readMovies("rain.txt");
        // IO.println(Arrays.deepToString(output));
        String[] arr = {"Cars 2", "Fight Club"};
        IO.println(FavoriteMovies.writeMovies("movies.txt", arr));

    }
}