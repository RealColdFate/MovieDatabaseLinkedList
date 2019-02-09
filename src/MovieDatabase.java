import java.util.*;
import java.io.*;

//Andrew Merrill
public class MovieDatabase {
    private static final String DELIM = "\n";
    private static final String FILE_NAME = "movieDatabase.txt";

    private GenLL<Movie> movies;

    public MovieDatabase() {
        movies = new GenLL<>();
    }

    //adds the passed movie
    public void addMovie(Movie aMovie) {
        movies.insert(aMovie);
    }

    //removes the passed movie
    private void removeMovie(Movie aMovie) {
        movies.gotoItem(aMovie);
        movies.deleteCurrent();
    }

    //deletes the first movie with a matching name
    public void findAndRemoveMovie(String movieName) {
        //if the current movie has the same name as the searched movie and removes it
        while (movies.hasMore()) {
            if (movies.getCurrent().getName().equals(movieName)) {
                removeMovie(movies.getCurrent());
            }
            movies.gotoNext();
        }
        movies.resetCurrent();
    }

    //returns a list of movies that have matching names
    public GenLL<Movie> searchByName(String movieName) {
        GenLL<Movie> retMovies = new GenLL<>();
        while (movies.hasMore()) {
            if (movies.getCurrent().getName().equals(movieName)) {
                retMovies.insert(movies.getCurrent());
            }
            movies.gotoNext();
        }
        movies.resetCurrent();
        return retMovies;
    }

    //returns a list of movies that have matching directors
    public GenLL<Movie> searchByDirector(String movieDirector) {
        GenLL<Movie> retMovies = new GenLL<>();
        while (movies.hasMore()) {
            if (movies.getCurrent().getDirector().equals(movieDirector)) {
                retMovies.insert(movies.getCurrent());
            }
            movies.gotoNext();
        }
        movies.resetCurrent();
        return retMovies;
    }


    //returns a list of movies that have matching years
    public GenLL<Movie> searchByYear(int movieYear) {
        GenLL<Movie> retMovies = new GenLL<>();
        while (movies.hasMore()) {
            if (movies.getCurrent().getYear() == movieYear) {
                retMovies.insert(movies.getCurrent());
            }
            movies.gotoNext();
        }
        movies.resetCurrent();
        return retMovies;
    }

    //returns a list of movies that have matching rating
    public GenLL<Movie> searchByRating(int movieRating) {
        GenLL<Movie> retMovies = new GenLL<>();
        while (movies.hasMore()) {
            if (movies.getCurrent().getRating() == movieRating) {
                retMovies.insert(movies.getCurrent());
            }
            movies.gotoNext();
        }
        movies.resetCurrent();
        return retMovies;
    }

    //prints the movies to the console
    public void print() {
        while (movies.hasMore()) {
            System.out.println(movies.getCurrent().toString() + DELIM);
            movies.gotoNext();
        }
        movies.resetCurrent();
    }

    //prints to the database File
    public void printToFile() {
        try {
            FileWriter fileWriter = new FileWriter(new File(FILE_NAME));
            while (movies.hasMore()) {
                fileWriter.write(movies.getCurrent().printForFile() + DELIM);
                movies.gotoNext();
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;

    }

    //reads from file and updates the list
    public void readFromFile() {

        try {
            Scanner fileScanner = new Scanner(new File(FILE_NAME));
            String name = "none";
            String director = "none";
            int rating = 1;
            int year = 0;
            double boxOfficeGross = 0.0;
            int lineCount = 0;
            while (fileScanner.hasNextLine()) {
                if (!(fileScanner.nextLine().equals(DELIM))) {
                    if (lineCount == 0)
                        name = fileScanner.nextLine();
                    else if (lineCount == 1)
                        director = fileScanner.nextLine();
                    else if(lineCount == 2)
                        rating = Integer.parseInt(fileScanner.nextLine());
                    else if(lineCount == 3)
                        year = Integer.parseInt(fileScanner.nextLine());
                    else if(lineCount == 4)
                        boxOfficeGross = Double.parseDouble(fileScanner.nextLine());
                    else if(lineCount == 5) {
                        movies.insert(new Movie(name, director, rating, year, boxOfficeGross));
                        lineCount = 0;
                        continue;
                    }
                    lineCount++;

                }
            }
            //String aName, String aDirector, int aRating, int aYear, double aBoxOfficeGross
            fileScanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
