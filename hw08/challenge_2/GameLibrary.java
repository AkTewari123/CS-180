
package challenge_2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.*;

import java.nio.file.Path;
import java.nio.file.Files;

public class GameLibrary {
    private ArrayList<Game> games;

    public GameLibrary() {
        games = new ArrayList<>();
    }

    public Game[] getGames() {
        Game[] games = new Game[this.games.size()];

        for (int i = 0; i < games.length; i++) {
            games[i] = this.games.get(i);
        }

        return games;
    }

    public int readLibraryText(String filename) throws ReadGameException {
        try {
            games.clear();
            
            List<String> lines = Files.readAllLines(Path.of(filename));

            for (String line : lines) {
                games.add(new Game(line));
            }

            return games.size();
        } catch (IOException e) {
            throw new ReadGameException();
        } catch (Exception e) {
            throw new ReadGameException();
        }
    

    }

    public int writeLibraryText(String filename) {

        int i = 0;
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
            for (Game game : games) {
                pw.println(game);
                i++;
            }

            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public int readLibraryBin(String filename) throws ReadGameException {
        games.clear();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        
            while (true) {
                Game game;
                try {
                    game = (Game) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
                // IO.println("reading: " + game); 
                games.add(game);

            } 

            ois.close();

            return games.size();



        } catch (IOException e) {
            throw new ReadGameException();
        } catch (Exception e) {
            IO.println(e.getMessage());
            throw new ReadGameException();
        }



    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public void playGame(String name, int hours) {
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (name.equals(game.getName())) {
                game.setHoursPlayed(hours + game.getHoursPlayed());
            }
        }
    }

    public void playGame(Game pGame, int hours) {
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.equals(pGame)) {
                game.setHoursPlayed(hours + game.getHoursPlayed());
            }
        }
    }
    public String toString() {
        return Arrays.toString(games.toArray());
    }

    public int writeLibraryBin(String filename) {

        int x = 0;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            for (int i = 0; i < games.size(); i++) {
                oos.writeObject(games.get(i));
                x++;
            }
    
            oos.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return x;


    }


}
