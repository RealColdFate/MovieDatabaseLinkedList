import java.util.Scanner;

//Andrew Merrill
public class MovieDatabaseFrontEnd {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int userInput;
        String name;
        String director;
        int rating;
        int year;
        double boxOfficeGross;
        MovieDatabase movies = new MovieDatabase();

        //main loop
        while(true){
            //user prompt to tell what actions are available
            System.out.println("\nEnter 1: To Add a Movie\n" +
                    "Enter 2: To Remove a Movie by its Title\n" +
                    "Enter 3: To search for a Title\n" +
                    "Enter 4: To search for moves by a Director\n" +
                    "Enter 5: To search for movies of a given Year\n" +
                    "Enter 6: To search for movies of a certain Rating\n" +
                    "Enter 7: To print out all movies\n" +
                    "Enter 8: To print to a database file\n" +
                    "Enter 9: To load a database file\n" +
                    "Enter 0: To quit ");
            //takes in user data
            userInput = Integer.parseInt(input.next());
            input.nextLine();
            //a switch to control user input
            switch(userInput){
                //exits the program
                case 0:
                    System.out.println("Goodbye.");
                    System.exit(0);
                    break;
                //allows the user to add a movie
                case 1:
                    System.out.println("Enter the name of the movie: ");
                    name = input.nextLine();
                    System.out.println("Enter the movie's director: ");
                    director = input.nextLine();
                    System.out.println("Enter the year the movie came out: ");
                    year = input.nextInt();
                    System.out.println("Enter the Rating of the movie: ");
                    rating = input.nextInt();
                    System.out.println("Enter the box office gross of the movie: ");
                    boxOfficeGross = input.nextDouble();
                    movies.addMovie(new Movie(name,director,rating, year,boxOfficeGross));
                    break;
                //allows the user to remove a movie by title
                case 2:
                    System.out.println("Enter the title of the movie you would like to remove from the list");
                    name = input.nextLine();
                    movies.findAndRemoveMovie(name);
                    break;
                //allows the user to search for all movies with the title
                case 3:
                    System.out.println("Enter the title of the movie you would like to search");
                    name = input.nextLine();
                    movies.searchByName(name).print();
                    break;
                //allows the user to search form movies with a given director
                case 4:
                    System.out.println("Enter the director of the movie you would like to search");
                    director = input.nextLine();
                    movies.searchByDirector(director).print();

                    break;
                //allows the user to search for movies by year
                case 5:
                    System.out.println("Enter the year of the movie you would like to search");
                    year = input.nextInt();
                    movies.searchByYear(year).print();

                    break;
                //allows the user to search for movies by rating
                case 6:
                    System.out.println("Enter the rating of the movie you would like to search");
                    rating = input.nextInt();
                    movies.searchByRating(rating).print();

                    break;
                //allows the user to print the movie database contents
                case 7:
                    movies.print();
                    break;
                //allows the user to print to a save file
                case 8:
                    movies.printToFile();
                    System.out.println("The file has been created");
                    break;
                //allows the user to load form a save file
                case 9:
                    movies.readFromFile();
                    System.out.println("The file has been loaded");
                    break;
                //this catches invalid number inputs
                default:
                    System.out.println("That is not a valid input");
                    break;

            }
        }


    }


}
