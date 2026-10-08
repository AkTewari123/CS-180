public class PCGame extends VideoGame implements Downloadable {
    private double downloadSize;

    public PCGame (String title, double price, double rating, double downloadSize) {
        super(title, price, rating);

        this.downloadSize = downloadSize;
    }


    public double getDownloadSize() {
        return downloadSize;
    }

    public String getPlatform() {
        return "PC";
    }

    public String toString() {
        String ret = "Title: " + this.getTitle() + "\n";
        ret+="Platform: PC\n";
        ret+=String.format("Price: %.2f", this.getPrice()) + "\n";
        ret+="Rating: " + this.getRating() + "\n";
        ret+="Download Size: " + this.downloadSize + " GB";

        return ret;

    }

    public boolean equals(Object o) {
        if (o instanceof PCGame pc) {
            double delta = 0.0001;
            if (Math.abs(this.getDownloadSize() - pc.getDownloadSize()) >= delta)  {
                return false;
            } else if (Math.abs(this.getPrice() - pc.getPrice()) >= delta) {
                return false;
            } else if (!this.getTitle().equals(pc.getTitle())) {
                return false;
            } else if (Math.abs(this.getRating() - pc.getRating()) >= delta) {
                return false;
            }

            return true;
        }
        return false;
    }



    

}
