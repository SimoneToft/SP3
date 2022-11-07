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
                System.out.println("Select a movie, or press ¨0¨ to return");
                Scanner choice = new Scanner(System.in);
                int nextChoice = choice.nextInt();

                if (nextChoice == 0) {
                    mainMenu.runMainMenu();

                } else if (nextChoice <= movieSearch.size()) {
                    String movieTitle = movieSearch.get(nextChoice - 1).getMediaTitle();
                    mainMenu.mediaPlayer(movieTitle, true, false);
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
