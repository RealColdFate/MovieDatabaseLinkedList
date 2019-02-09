//Andrew Merrill
public class Movie {

    private String name;
    private int year;
    private int rating;//1-5
    private String Director;
    private double boxOfficeGross;
    private static final String DELIM = "\n";

    public Movie() {
        this.boxOfficeGross = 0;
        this.Director = "none";
        this.name = "none";
        this.year = 0;
        this.rating = 1;
    }

    public Movie(String aName, String aDirector, int aRating, int aYear, double aBoxOfficeGross) {
        setBoxOfficeGross(aBoxOfficeGross);
        setDirector(aDirector);
        setRating(aRating);
        setName(aName);
        setYear(aYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1875 && year <= 2019)
            this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating > 0 && rating < 6)//1-5
            this.rating = rating;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public double getBoxOfficeGross() {
        return boxOfficeGross;
    }

    public void setBoxOfficeGross(double boxOfficeGross) {
        if (boxOfficeGross >= 0)
            this.boxOfficeGross = boxOfficeGross;
    }

    //checks if the movie is equal to the given movie
    public boolean equals(Movie aMovie) {
        return aMovie != null &&
                this.getBoxOfficeGross() == aMovie.getBoxOfficeGross() &&
                this.getDirector().equals(aMovie.getDirector()) &&
                this.getName().equals(aMovie.getName()) &&
                this.getYear() == aMovie.getYear() &&
                this.getRating() == aMovie.getRating();
    }
    //checks if the name is equal to a given string name
    public boolean equals(String aName){
        return aName.equals(this.getName());
    }

    // compares the two movies
    public int compareTo(Movie aMovie) {
        if (aMovie == null)
            return 0;
        return 1;
    }

    //prints out the data from the movie
    public String toString() {
        return " Name: " + this.getName() +
                "\n Director: " + this.getDirector() +
                "\n Rating: " + this.getRating() + " stars " +
                "\n Release year: " + this.getYear() +
                "\n Box Office Gross: $" + this.getBoxOfficeGross();
    }
    //prints the file data to be parsed
    public String printForFile(){
        return DELIM +
                this.getName() + DELIM + DELIM +
                this.getDirector() + DELIM + DELIM +
                this.getRating() + DELIM + DELIM +
                this.getYear() + DELIM + DELIM +
                this.getBoxOfficeGross() + DELIM ;
    }
}
