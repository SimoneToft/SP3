import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Series {
    private String mediaTitle;
    private String[] mediaCategory;
    private String mediaRating;
    private String mediaReleaseYear;

    private String[] seriesSeasons;

    public Series(String mediaTitle, String mediaReleaseYear, String[] mediaCategory, String mediaRating, String[] seriesSeasons) {
        this.mediaCategory = mediaCategory;
        this.mediaTitle = mediaTitle;
        this.mediaRating = mediaRating;
        this.mediaReleaseYear = mediaReleaseYear;
        this.seriesSeasons = seriesSeasons;
    }
    public String getMediaTitle() {
        return mediaTitle;
    }

    public static void titleSearchSeries(String search) {
        List<Series> seriesSearch = new ArrayList<>();
        int number = 1;
        if (search.matches("0")) {
            mainMenu.runMainMenu();

        } else {
            for (Series p : createMedia.series) {
                if (p.getMediaTitle().toLowerCase().contains(search.toLowerCase())) {
                    seriesSearch.add(p);
                }
            }
            for (Series p : seriesSearch) {
                System.out.println(number + ". " + p);
                number++;
            }
        }
        System.out.println("Select a movie, or press ¨0¨ to return");
        Scanner choice = new Scanner(System.in);
        int nextChoice = choice.nextInt();

        if (nextChoice == 0) {
            mainMenu.runMainMenu();

        } else if (nextChoice <= seriesSearch.size()) {
            String movieTitle = seriesSearch.get(nextChoice - 1).getMediaTitle();
            mainMenu.mediaPlayer(movieTitle, true, false);
        }
        else if (nextChoice > seriesSearch.size()||nextChoice < seriesSearch.size()){

            System.out.println("-----------------------------------------");
            System.out.println("The movie was not found, please try again");
            System.out.println("-----------------------------------------");

            titleSearchSeries(search);

        } else {
            for (Series p : createMedia.series) {
                if (p.getMediaTitle().toLowerCase().contains(search.toLowerCase())) {
                    seriesSearch.add(p);
                }
            }
            for (Series p : seriesSearch) {
                System.out.println(number + ". " + p);
                number++;
            }
        }
        System.out.println("Select a movie, or press ¨0¨ to return");
        Scanner choice = new Scanner(System.in);
        int nextChoice = choice.nextInt();

        if (nextChoice == 0) {
            mainMenu.runMainMenu();

        } else if (nextChoice <= seriesSearch.size()) {
            String movieTitle = seriesSearch.get(nextChoice - 1).getMediaTitle();
            mainMenu.mediaPlayer(movieTitle, true, false);
        }
    }


    @Override
    public String toString() {
        return "|SERIES| " + mediaTitle +
                " |CATEGORIES| " + Arrays.toString(mediaCategory).replace("[","").replace("]","")+
                " |RATING| " + mediaRating +
                " |YEAR| = " + mediaReleaseYear+
                " |SEASONS-EPISODES| "+ Arrays.toString(seriesSeasons).replace("[","").replace("]","");
    }
}
