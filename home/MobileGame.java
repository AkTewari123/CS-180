public class MobileGame extends VideoGame implements Downloadable {
    private double downloadSize;
    public MobileGame(String title, double price, double rating, double downloadSize) {
        super(title, price, rating);
        this.downloadSize = downloadSize;
    }

    public String getPlatform() {
        return "Mobile";
    }

    public double getDownloadSize() {
        return this.downloadSize;
    }

    public String toString() {
        String ret = "Title: " + this.getTitle() + "\n";
        ret+="Platform: Mobile\n";
        ret+=String.format("Price: %.2f", this.getPrice()) + "\n";
        ret+="Rating: " + this.getRating() + "\n";
        ret+="Download Size: " + this.downloadSize + " GB";

        return ret;
    }

    public boolean equals(Object o) {
        if (o instanceof MobileGame mobile) {
            boolean equals = true;
            double delta = 0.0001;
            equals = Math.abs(this.downloadSize - mobile.getDownloadSize()) < delta && equals;
            equals = Math.abs(this.getPrice() - mobile.getPrice()) < delta && equals;
            equals = this.getTitle().equals(mobile.getTitle()) && equals;
            equals = Math.abs(this.getRating() - mobile.getRating()) < delta && equals;

            return equals;
        }
        return false;
    }




}
