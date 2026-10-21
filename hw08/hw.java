package hw08;
import java.io.*;

class FavoriteMovies {
    public static String[] readMovies(String fileName) {
        try {
            
            BufferedReader counter = new BufferedReader(new FileReader(fileName));
            int i = 0;
            String line = "x";


            while ((line = counter.readLine()) != null) {
                i++;
            }

            var movies = new String[i];

            i = 0;
            counter.close();

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            while ((line = br.readLine()) != null) {
                movies[i] = line;
                i++;
            }

            br.close();

            return movies;

        } catch (Exception e) {

            e.printStackTrace();

        } 

        return new String[1];



    }
}