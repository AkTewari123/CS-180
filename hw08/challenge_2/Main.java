package challenge_2;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game("Minecraft|2011|Sandbox|250");
            Game g1 = new Game("Minecraft|2011|Sandbox|350");

            GameLibrary lib = new GameLibrary();
            
            lib.addGame(game);
            lib.addGame(g1);
            lib.writeLibraryBin("games.dat");
            
            
            GameLibrary newLib = new GameLibrary();

            newLib.readLibraryBin("games.dat");

            IO.println(newLib);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
