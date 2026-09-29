public class Movie {
    private String title = "";
    private String studio = "none";
    private int runtime = -1;
    private int year = 1400;
    private char rating = 'Z';
    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }
    public Movie(String title, int runtime, char rating) {
        this.title = title;
        this.runtime = runtime;
        this.rating = rating;
    }
    public Movie(String title, int year, int runtime) {
        this(title, year);
        this.runtime = runtime;
    }
    public Movie(String title, String studio, int runtime, int year, char rating) {
        this(title, runtime, rating);
        this.year = year;
        this.studio = studio;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public int getRating() {
        return rating;
    }
    public int getRuntime() {
        return runtime;
    }
    public String getStudio() {
        return studio;
    }




}
