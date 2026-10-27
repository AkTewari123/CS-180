package challenge_2;
import java.util.Serializable;

/**
 * Game.java
 * The Games for the assignment
 * @author Akshat Tewari
 * @version 10/21/26
*/
public class Game implements Serializable {
    private String name;
    private int releaseYear;
    private String genre;
    private int hoursPlayed;

    public Game(String data) throws ReadGameException {
        try {
            String[] attributes = new String[4];
            int idx = 0;
            attributes[idx] = "";
            for (int i = 0; i < data.length(); i++) {
                String s = data.substring(i, i + 1);
                if (!s.equals("|")) {
                    attributes[idx] += s;
                } else {
                    idx++;
                    attributes[idx] = "";
                }
            }
            // IO.println(Arrays.deepToString(attributes));
            if (attributes.length != 4) {
                throw new ReadGameException();
            }
            for (int i = 0; i < attributes.length; i++) {
                // IO.println("now looking at " + i);
                switch (i) {
                    case 0:
                        name = attributes[i];
                        break;
                    case 1: 
                        releaseYear = Integer.parseInt(attributes[i]);
                        break;
                    case 2:
                        genre = attributes[i];
                        break;
                    case 3:
                        hoursPlayed = Integer.parseInt(attributes[i]);
                        break;
                    default:
                        throw new ReadGameException();
                }
            }

            if (name == null || releaseYear == 0 || genre == null) {
                throw new ReadGameException();
            }

        } catch (Exception e) {
            throw new ReadGameException();
        } 
    }

    public Game(String name, int releaseYear, String genre, int hoursPlayed) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.hoursPlayed = hoursPlayed;
    }

    
    @Override
    public String toString() {
        return String.format("%s|%d|%s|%d", name, releaseYear, genre, hoursPlayed);
    }

    String getName() {
        return name;
    }
    int getReleaseYear() {
        return releaseYear;
    }
    String getGenre() {
        return genre;
    }
    int getHoursPlayed() {
        return hoursPlayed;
    }

    void setHoursPlayed(int hours) {
        hoursPlayed = hours;
    }
    @Override 
    public boolean equals(Object o) {
        if (o instanceof Game other) {
            boolean equals = name.equals(other.getName());
            equals = genre.equals(other.getGenre()) && equals;
            equals = releaseYear == other.getReleaseYear() && equals;
            return equals;
        }

        return false;
    }


}
