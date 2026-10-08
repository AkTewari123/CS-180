public class StoreUtil {
    public static double totalPrice(VideoGame[] games) {
        double total = 0.0;

        for (var game : games) {
            total+=game.getPrice();
        }

        return total;
    }

    public static int countDownloadableVideoGames(VideoGame[] games) {
        int count = 0;

        for (var game : games) {
            if (game instanceof Downloadable down) {
                count++;
            }
        }

        return count;
    }

    public static int countUniqueGames(VideoGame[] games) {
        int count = 0;
        for (int i = 0; i < games.length; i++) {
            var game = games[i];
            boolean unique = true;
            for (int j = i + 1; j < games.length; j++) {
                if (game.equals(games[j])) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                count++;
            }
        }

        return count;
    }

    public static double averageRating(VideoGame[] games) {
        double total = 0.0;

        for (var game : games) {
            total+=game.getRating();
        }

        return total / games.length;
    }

    public static void main(String[] args) {
        PCGame blackRock = new PCGame("BlackRock", 4.0, 4.5, 2.1);
        MobileGame zelda = new MobileGame("Zelda", 2.0, 4.0, 1.4);
        ConsoleGame rocketLeague = new ConsoleGame("Rocket League", 0.0, 4.0, "XBox");
        VideoGame[] games = { blackRock, zelda, rocketLeague };

        IO.println(averageRating(games));
        IO.println(countUniqueGames(games));
        IO.println(countDownloadableVideoGames(games));
        IO.println(totalPrice(games));
    }

    
}
