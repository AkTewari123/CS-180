/**
 * Represents an item that can be reviewed by customers.
 * @author PurdueCs
 * @version Ver1.0
 */
public interface Reviewable {

   /**
     * Returns the review score for the item.
     *
     * Ratangs will always be between 0.0 and 5.0.
     *
     * @return the rat*ng
     */
    double getRating();
}
