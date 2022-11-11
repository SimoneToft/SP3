import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Series extends aMedia {

    private static String[] seriesSeasons;

    public Series(String mediaTitle, String mediaReleaseYear, String[] mediaCategory, String mediaRating, String[] seriesSeasons) {
        super(mediaTitle, mediaReleaseYear, mediaCategory, mediaRating);
        this.seriesSeasons = seriesSeasons;
    }
    public String getMediaTitle() {
        return mediaTitle;
    }
    public static String[] getSeriesSeasons() {
        return seriesSeasons;
    }

    public static void titleSearchSeries(String search) {
        List<Series> seriesSearch = new ArrayList<>();
        int number = 1;
        if (search.matches("0")) {
            mainMenu.spaces();
            System.out.println("------------------");
            mainMenu.runMainMenu();         //returns to main menu

        } else {
            for (Series p : createMedia.series) {
                if (p.getMediaTitle().toLowerCase().contains(search.toLowerCase())) {
                    seriesSearch.add(p);        //adds corresponding series to array, if it matches search input
                }
            }
            for (Series p : seriesSearch) {
                System.out.println(number + ". " + p);
                number++;
            }                               //if seriesSearch is empty
            if (seriesSearch.size()<=0) {
                mainMenu.spaces();         // if no series are added to array (search doesn't match)
                System.out.println("----------------------------------------------");
                System.out.println("There are no matching series, please try again");
                System.out.println("----------------------------------------------");
                mainMenu.runMainMenu();
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("Select a series, or press '0' to return");
        System.out.println("--------------------------------------");
        Scanner choice = new Scanner(System.in);
        int nextChoice = choice.nextInt();

        if (nextChoice == 0) {
            mainMenu.spaces();
            System.out.println("------------------");
            mainMenu.runMainMenu();         //returns to main menu

        } else if (nextChoice <= seriesSearch.size()) {
            String movieTitle = seriesSearch.get(nextChoice - 1).getMediaTitle();
            mainMenu.mediaPlayer(movieTitle, false, true);
        }
        else if (nextChoice > seriesSearch.size()||nextChoice < seriesSearch.size()){
            mainMenu.spaces();

            System.out.println("-----------------------------------------");
            System.out.println("The series was not found, please try again");
            System.out.println("-----------------------------------------");

            titleSearchSeries(search);
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
    public static void seriesCategorySearch()
    {
        System.out.println("------------------------");
        System.out.println("You have selected series");
        System.out.println("------------------------");

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
                "14. Music\n" +
                "15. Musical\n" +
                "16. Mystery\n" +
                "17. Romance\n" +
                "18. Sci-fi\n" +
                "19. Sport\n" +
                "20. Talk-show\n" +
                "21. Thriller\n" +
                "22. War\n" +
                "23. Western");
        System.out.println("-----------------------------------------------------");
        System.out.println("Select a category or press '0' to return to main menu");
        System.out.println("-----------------------------------------------------");
        String[] categoryChoice = {"Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "Film-Noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance", "Sci-fi", "Sport", "Talk-show", "Thriller", "War", "Western"};
        Scanner catChoice = new Scanner(System.in);
        int input = catChoice.nextInt();
        int choiceNumber = -1 + input;
        ArrayList<Series> foundSeries = new ArrayList<>();
        int seriesNumber = 1;
        if (input == 0) {
            mainMenu.spaces();
            System.out.println("------------------");
            mainMenu.runMainMenu();
        }

        for (Series p : createMedia.series) {
            for (String s : p.mediaCategory) {
                if (s.contains(categoryChoice[choiceNumber])) {
                    foundSeries.add(p);
                }
            }
        }

        if (foundSeries.size() > 0) {
            for (Series p : foundSeries) {
                System.out.println(seriesNumber + ". " + p);
                seriesNumber++;
            }
            System.out.println("--------------------------------------");
            System.out.println("Select a serie, or press '0' to return");
            System.out.println("--------------------------------------");
            Scanner choice = new Scanner(System.in);
            int nextChoice = choice.nextInt();

            if (nextChoice == 0) {
                mainMenu.spaces();
                System.out.println("------------------");
                mainMenu.runMainMenu();

            } else if (nextChoice <= foundSeries.size()) {
                String seriesTitle = foundSeries.get(nextChoice - 1).getMediaTitle();
                System.out.println("-------------------------------");
                System.out.println("You have selected "+ seriesTitle);
                int e=0;
                for(Series s : createMedia.series){
                    e++;
                    if(s.getMediaTitle().equals(seriesTitle)){
                        System.out.println(e);
                        createMedia.seasonList(e);
                    }
                }
                mainMenu.mediaPlayer(seriesTitle, false, true);
            }
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.println("No series were found in that category, type '0' to return");
            System.out.println("---------------------------------------------------------");
            Scanner choice = new Scanner(System.in);
            int nextChoice = choice.nextInt();

            if (nextChoice == 0) {
                seriesCategorySearch();
            } else if (nextChoice != 0) {  //anti-brat measure
                seriesCategorySearch();
            }
        }
    }
}
