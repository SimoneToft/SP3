import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Movie {
    private String mediaTitle;
    private String[] mediaCategory;
    private String mediaRating;
    private String mediaReleaseYear;

    public Movie(String mediaTitle, String mediaReleaseYear, String[] mediaCategory, String mediaRating) {
        this.mediaCategory = mediaCategory;
        this.mediaTitle = mediaTitle;
        this.mediaRating = mediaRating;
        this.mediaReleaseYear = mediaReleaseYear;
    }

       public static void titleSearch(String search) {
            List<Movie> movieSearch = new ArrayList<>();
            int number = 1;
            if (search.matches("0")) {
                mainMenu.runMainMenu();

            } else {
                for (Movie p : createMedia.movies) {
                    if (p.mediaTitle.toLowerCase().contains(search.toLowerCase())) {
                        movieSearch.add(p);
                    }
                }
                for (Movie p : movieSearch) {
                    System.out.println(number + ". " + p);
                    number++;
                }
            }

                if (movieSearch.size()<=0) {
               System.out.println("----------------------------------------------");
               System.out.println("There are no matching movies, please try again");
               System.out.println("----------------------------------------------");
               mainMenu.runMainMenu();
           }

                System.out.println("Select a movie, or press '0' to return");
                Scanner choice = new Scanner(System.in);
                try {
                    int nextChoice = choice.nextInt();

                    if (nextChoice == 0) {
                        mainMenu.runMainMenu();

                    } else if (nextChoice <= movieSearch.size()) {
                        String movieTitle = movieSearch.get(nextChoice - 1).getMediaTitle();
                        mainMenu.mediaPlayer(movieTitle, true, false);
                    }
                    else if (nextChoice > movieSearch.size()||nextChoice < movieSearch.size()){

                        System.out.println("-----------------------------------------");
                        System.out.println("The movie was not found, please try again");
                        System.out.println("-----------------------------------------");

                        titleSearch(search);

                    }
                }
                catch (Exception e){
                    System.out.println("------------------------------");
                    System.out.println("Please input a number instead");
                    System.out.println("------------------------------");
                    titleSearch(search);
                }
            }
    public static void categorySearch() {
        System.out.println("1. Action\n" +
                "2. Adventure\n" +
                "3. Animation\n" +
                "4. Biography\n" +
                "5. Comedy\n" +
                "6. Crime\n" +
                "7. Documentary\n" +
                "8. Drama\n" +
                "9. Family\n" +
                "10. Fantasy\n" +
                "11. Film-Noir\n" +
                "12. History\n" +
                "13. Horror\n" +
                "14. Musical\n" +
                "15. Mystery\n" +
                "16. Romance\n" +
                "17. Sci-fi\n" +
                "18. Sport\n" +
                "19. Talk-show\n" +
                "20. Thriller\n" +
                "21. War\n" +
                "22. Western");
        System.out.println("Select a category or press '0' to return to main menu");
        String[] categoryChoice = {"Action","Adventure","Animation","Biography","Comedy","Crime","Documentary","Drama","Family","Fantasy","Film-Noir","History","Horror","Musical","Mystery","Romance","Sci-fi","Sport","Talk-show","Thriller","War","Western"};
        Scanner catChoice = new Scanner(System.in);
        int input = catChoice.nextInt();
        int choiceNumber = -1+input;
        ArrayList<Movie> foundMovies = new ArrayList<>();
        int movieNumber = 1;
        if(input==0) {
            mainMenu.runMainMenu();
        }
        for(Movie p : createMedia.movies) {
            for(String s : p.mediaCategory) {
                if(s.contains(categoryChoice[choiceNumber])) {
                    foundMovies.add(p);
                }
            }
        }
        if(foundMovies.size()>0) {
            for(Movie p : foundMovies) {
                System.out.println(movieNumber+". "+p);
                movieNumber++;
            }
            System.out.println("Select a movie, or press '0' to return");
            Scanner choice = new Scanner(System.in);
            int nextChoice = choice.nextInt();

            if (nextChoice == 0) {
                mainMenu.runMainMenu();

            } else if (nextChoice <= foundMovies.size()) {
                String movieTitle = foundMovies.get(nextChoice - 1).getMediaTitle();
                mainMenu.mediaPlayer(movieTitle, true, false);
            }
        }
        else {
            System.out.println("---------------------------------------------------------");
            System.out.println("No movies were found in that category, type '0' to return");
            System.out.println("---------------------------------------------------------");
            Scanner choice = new Scanner(System.in);
            int nextChoice = choice.nextInt();

            if (nextChoice == 0) {
                categorySearch();
            }
            else if (nextChoice!=0){
                categorySearch();
            }
        }
    }
    public String getMediaTitle() {
        return mediaTitle;
    }

    @Override
    public String toString() {
        return "|MOVIE| " + mediaTitle +
                " |CATEGORIES| " + Arrays.toString(mediaCategory).replace("[","").replace("]","")+
                " |RATING| " + mediaRating +
                " |YEAR| = " + mediaReleaseYear;
    }


}
