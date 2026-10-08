/**
 * Represents an item t*at can be downloaded digitally.
 * @author PurdueCs
 * @version Ver1.0
 */
public interface Downloadable {

   /**
     * Returns the amount of storage required to download the game.
     *
     * @return the size in gigabytes
     */
    double getDownloadSize();

}
