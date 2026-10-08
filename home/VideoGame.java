/**
 * Represents a video game sold by the store.
 *
 * VideoGame is an abstract class because there is no
 * generic type of video game. Instead, specific game
 * types such as PCGame, ConsoleGame, and MobileGame
 * will extend this class.
 *
 * Every video game has a title, price, and rating.
 * @author PurdueCs
 * @version Ver1.0
 */
public abstract class VideoGame
        implements Sellable, Reviewable {

    /**
     * The title of the game.
     */
    private String title;

    /**
     * The price of the game in dollars.
     */
    private double price;

    /**
     * The review score of the game.
     * Ratings are expected to be between 0.0 and 5.0.
     */
    private double rating;

    /**
     * Creates a new VideoGame.
     *
     * @param title the game's title
     * @param price the game's price
     * @param rating the game's review score
     */
    public VideoGame(
            String title,
            double price,
            double rating) {

        this.title = title;
        this.price = price;
        this.rating = rating;
    }

    /**
     * Returns the title of the game.
     *
     * @return the game's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the price of the game.
     *
     * @return the price in dollars
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Returns the review score of the game.
     *
     * @return the rating
     */
    @Override
    public double getRating() {
        return rating;
    }

    /**
     * Returns the platform associated with the game.
     *
     * Example return values:
     * PC
     * Xbox
     * PlayStation
     * Mobile
     *
     * @return the platform name
     */
    public abstract String getPlatform();

    /**
     * Returns a String representation of the game.
     *
     * @return a description of the game
     */
    @Override
    public abstract String toString();

    /**
     * Determines whether this game should be
     * considered equal to another object.
     *
     * @param o the object being compared
     * @return true if the objects are equal,
     *         false otherwise
     */
    @Override
    public abstract boolean equals(Object o);

}
