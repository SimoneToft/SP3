import java.util.Scanner;
public class mainMenu {
    public static int mediaAmount;
    public static boolean seriesDisplayed=false;
    public static boolean moviesDisplayed=false;

    public static void mediaCreate(){
        createMedia.createAllMedia();
    }
    public static void runMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. View all movies\n2. View all series\n3. Search\n4. Categories\n5. Watched\n6. Saved");
        int intInputMain;
        intInputMain = keyboard.nextInt();
        if(intInputMain == 1){
            mediaAmount=createMedia.allMovies();
            moviesDisplayed=true;
            System.out.println("Select a movie or press '0' to return to main menu");
            mediaSelector();
        }
        else if(intInputMain == 2){
            mediaAmount=createMedia.allSeries();
            seriesDisplayed=true;
            System.out.println("Select a series or press '0' to return to main menu");
            mediaSelector();
        }
        else if(intInputMain == 3){

            System.out.println("Do you want to search for a movie, or a series?");
            System.out.println("1. Movies");
            System.out.println("2. Series");

            Scanner choiseess = new Scanner(System.in);

            try {
                int choisees = choiseess.nextInt();
                if (choisees == 1) {
                    System.out.println("Type to search, or ¨0¨ to return");
                    Scanner searcher = new Scanner(System.in);
                    String search = searcher.nextLine();

                    Movie.titleSearch(search);

                } else if (choisees == 2) {

                    System.out.println("Type to search, or ¨0¨ to return");
                    Scanner searcher = new Scanner(System.in);
                    String search = searcher.nextLine();

                    Series.titleSearchSeries(search);
                }
            }
            catch(Exception e) {
                System.out.println("---------------------------");
                System.out.println("Please input '1' or '2' instead");
                System.out.println("---------------------------");
                runMainMenu();
            }
        }
        else if (intInputMain == 4){
            Movie.categorySearch();
        }
        else if(intInputMain == 5){
            System.out.println(startMenu.getCurrentUser().getWatched());
            System.out.println("Press '0' to return to main menu");
            if (keyboard.nextInt() == 0) {
                runMainMenu();
            }
        }
        else if(intInputMain == 6){
            System.out.println(startMenu.getCurrentUser().getSaved());
            System.out.println("Press '0' to return to main menu");
            if (keyboard.nextInt() == 0) {
                runMainMenu();
                }
            }
         else if (intInputMain > 6 || intInputMain < 0) {
            System.out.println("---------------------------");
            System.out.println("Please type '1-6' instead");
            System.out.println("---------------------------");
            runMainMenu();
          }
    }
        
    public static void mediaSelector(){
        Scanner keyboard = new Scanner(System.in);
        int input= keyboard.nextInt();
        int choice=-1+input;

        if(choice>=0&&choice<=mediaAmount){
            String mediaTitle=createMedia.getTitle(moviesDisplayed,seriesDisplayed,choice);
            System.out.println("You have selected '"+mediaTitle+"'");
            mediaPlayer(mediaTitle, moviesDisplayed, seriesDisplayed);
        }
        else if(input==0){
            runMainMenu();
        }
    }
    public static void mediaPlayer(String mediaTitle, boolean moviesDisplayed, boolean seriesDisplayed){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press '0' to return to main menu | Press '1' to play | Press '2' to save");
        int mediaChoice=keyboard.nextInt();
        if(mediaChoice==0) {
            runMainMenu();
        }
        else if(mediaChoice==1){
            System.out.println(mediaTitle+" is now playing...");
            System.out.println("Press '0' to return to main menu");
            startMenu.getCurrentUser().watchedMedia(moviesDisplayed,seriesDisplayed,mediaTitle);
            if(keyboard.nextInt()==0){
                runMainMenu();
            }
        }
        else if(mediaChoice==2){
            startMenu.getCurrentUser().saveMedia(moviesDisplayed,seriesDisplayed,mediaTitle);
            runMainMenu();
        }
    }      
}
