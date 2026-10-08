public class Movie {
    private String title;
    private int runtime;
    public Movie(String title, int runtime) {
        this.title = title;
        this.runtime = runtime;
    }  
    public String getTitle() {
        return title;
    }
    public int getRuntime() {
        return runtime;
    }
    @Override 
    public boolean equals(Object param) {
        if (param instanceof Movie otherMovie) {
            return this.title.equals(otherMovie.getTitle()) && this.runtime == otherMovie.getRuntime();
        }
        return false;
    }
}