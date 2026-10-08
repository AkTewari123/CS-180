public class ConsoleGame extends VideoGame {
    private String console;
    public ConsoleGame(String title, double price, double rating, String console) {
        super(title, price, rating);
        this.console = console;
    }

    public String getPlatform() {
        return console;
    }

    public String toString() {
        String ret = "Title: " + this.getTitle() + "\n";
        ret+="Platform: " + this.console + "\n";
        ret+=String.format("Price: %.2f", this.getPrice()) + "\n";
        ret+="Rating: " + this.getRating();

        return ret;
    }

    public boolean equals(Object o) {
        if (o instanceof ConsoleGame otherConsole) {
            boolean equals = true;
            double delta = 0.0001;
            if (Math.abs(this.getPrice() - otherConsole.getPrice()) >= delta) {
                return false;
            } else if (!this.getTitle().equals(otherConsole.getTitle())) {
                return false;
            } else if (!this.console.equals(otherConsole.getPlatform())) {
                return false;
            } else if (Math.abs(this.getRating() - otherConsole.getRating()) >= delta) {
                return false;
            }
            return equals;
        }
        return false;
    }




}
