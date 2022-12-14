import java.util.Scanner;
public class mainMenu {
    public static int mediaAmount;
    public static boolean seriesDisplayed=false;
    public static boolean moviesDisplayed=false;
    public static boolean SQLEnabled = true;

    public static void mediaCreate(){
        createMedia.createAllMedia();
    }
    public static void runMainMenu() {
         seriesDisplayed=false;
         moviesDisplayed=false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("M A I N   M E N U");
        System.out.println("------------------");
        System.out.println("1. View all movies\n2. View all series\n3. Search\n4. Categories\n5. Watched\n6. Saved\n7. Settings");
        System.out.println("------------------");
        int intInputMain;

        try {
            intInputMain = keyboard.nextInt();

            if (intInputMain == 1) {
                mediaAmount = createMedia.allMovies();
                moviesDisplayed = true;                         //prints list of all movies
                System.out.println("--------------------------------------------------");
                System.out.println("Select a movie or press '0' to return to main menu");
                System.out.println("--------------------------------------------------");
                mediaSelector();
            } else if (intInputMain == 2) {
                mediaAmount = createMedia.allSeries();
                seriesDisplayed = true;                         //prints list of all series
                System.out.println("---------------------------------------------------");
                System.out.println("Select a series or press '0' to return to main menu");
                System.out.println("---------------------------------------------------");
                mediaSelector();
            } else if (intInputMain == 3) {
                System.out.println("-----------------------------------------------");
                System.out.println("Do you want to search for a movie, or a series?");
                System.out.println("1. Movies");
                System.out.println("2. Series");
                System.out.println("-----------------------------------------------");

                Scanner choiseess = new Scanner(System.in);

                try {
                    int choisees = choiseess.nextInt();
                    if (choisees == 1) {
                        System.out.println("--------------------------------");
                        System.out.println("Type to search, or '0' to return");
                        System.out.println("--------------------------------");
                        Scanner searcher = new Scanner(System.in);
                        String search = searcher.nextLine();

                        Movie.titleSearch(search);

                    } else if (choisees == 2) {
                        System.out.println("--------------------------------");
                        System.out.println("Type to search, or '0' to return");
                        System.out.println("--------------------------------");
                        Scanner searcher = new Scanner(System.in);
                        String search = searcher.nextLine();

                        Series.titleSearchSeries(search);
                    } else if (choisees != 1 || choisees != 2) {                //catches wrong number input
                        mainMenu.spaces();
                        System.out.println("-------------------------------");
                        System.out.println("Please input '1' or '2' instead");
                        System.out.println("-------------------------------");
                        runMainMenu();
                    }
                } catch (Exception e) {
                    mainMenu.spaces();                                          //catches wrong input
                    System.out.println("-------------------------------");
                    System.out.println("Please input '1' or '2' instead");
                    System.out.println("-------------------------------");
                    runMainMenu();

                }
            } else if (intInputMain == 4) {
                categorySearch();
            } else if (intInputMain == 5) {
                System.out.println(startMenu.getCurrentUser().getWatched());   //prints watched movies for user
                System.out.println("--------------------------------");
                System.out.println("Press '0' to return to main menu");
                System.out.println("--------------------------------");
                Scanner newkeyboard = new Scanner(System.in);
                int nextkey = newkeyboard.nextInt();
                if (nextkey == 0 ||nextkey  != 0) {
                    mainMenu.spaces();
                    System.out.println("------------------");
                    runMainMenu();
                }
            } else if (intInputMain == 6) {
                System.out.println(startMenu.getCurrentUser().getSaved());      //prints saved movies for user
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Press '0' to return to main menu | Press '1' to delete media from your saved file");
                System.out.println("---------------------------------------------------------------------------------");
                Scanner newkeyboard = new Scanner(System.in);
                int nextkey = newkeyboard.nextInt();
                if (nextkey == 0 ) {
                    mainMenu.spaces();
                    System.out.println("------------------");
                    runMainMenu();
                }
                    else if(nextkey == 1) {

                    startMenu.getCurrentUser().deleteMedia();
                    runMainMenu();
                }
                mainMenu.spaces();
                System.out.println("-------------------------------------------");  //wrongful input
                System.out.println("Please input a corresponding number instead");
                System.out.println("-------------------------------------------");
                runMainMenu();

            } else if (intInputMain == 7) {
                String Enabled = "Enable";
                if (SQLEnabled){
                    Enabled = "Disable";
                }

                Scanner keychoice = new Scanner(System.in);
                System.out.println("--------SETTINGS---------");
                System.out.println("1. " + Enabled + " SQL\n2. Logout" );
                System.out.println("-------------------------");
                int keythatisnext = keychoice.nextInt();
                if (keythatisnext == 1) {
                    if (SQLEnabled) {
                        SQLEnabled = false;
                        spaces();
                        System.out.println("-------------------");
                        System.out.println("SQL is now disabled");
                        System.out.println("-------------------");
                        runMainMenu();
                    } else if (!SQLEnabled) {
                        SQLEnabled = true;
                        spaces();
                        System.out.println("------------------");
                        System.out.println("SQL is now enabled");
                        System.out.println("------------------");
                        runMainMenu();
                    }

                    else if (keythatisnext == 2) {
                        spaces();
                        Main.loginScreen();
                    }
                }

            }


            else if (intInputMain > 7 || intInputMain <= 0) {                 //number-typo
                mainMenu.spaces();
                System.out.println("-------------------------");
                System.out.println("Please type '1-6' instead");
                System.out.println("-------------------------");
                runMainMenu();

            }
        } catch (Exception e) {
            mainMenu.spaces();
            System.out.println("-------------------x-----------------------");  //wrongful input
            System.out.println("Please input a corresponding number instead");
            System.out.println("-------------------------------------------");
            runMainMenu();
        }
     }

        
    public static void mediaSelector(){
        Scanner keyboard = new Scanner(System.in);
        int input= keyboard.nextInt();
        int choice=-1+input;

        if(choice>=0&&choice<=mediaAmount){
            String mediaTitle=createMedia.getTitle(moviesDisplayed,seriesDisplayed,choice);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("You have selected '"+mediaTitle+"'");
            System.out.println("------------------------------------------------------------------------");
            if(seriesDisplayed) {
                createMedia.seasonList(choice);
            }
            mediaPlayer(mediaTitle, moviesDisplayed, seriesDisplayed);
        }
        else if(input==0){
            mainMenu.spaces();
            System.out.println("------------------");
            runMainMenu();
        }
        mainMenu.spaces();
        System.out.println("-------------------------------------------");  //wrongful input
        System.out.println("Please input a corresponding number instead");
        System.out.println("-------------------------------------------");
        runMainMenu();
    }
    public static void mediaPlayer(String mediaTitle, boolean moviesDisplayed, boolean seriesDisplayed){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Press '0' to return to main menu | Press '1' to play | Press '2' to save");
        System.out.println("------------------------------------------------------------------------");
        int mediaChoice=keyboard.nextInt();
        if(mediaChoice==0) {
            mainMenu.spaces();
            System.out.println("------------------");
            runMainMenu();
        }
        else if(mediaChoice==1){
            System.out.println(mediaTitle+" is now playing...");
            System.out.println("--------------------------------");
            System.out.println("Press '0' to return to main menu");
            System.out.println("--------------------------------");
            startMenu.getCurrentUser().watchedMedia(moviesDisplayed,seriesDisplayed,mediaTitle);
            if(keyboard.nextInt()==0){
                mainMenu.spaces();
                System.out.println("------------------");
                runMainMenu();
            }
        }
        else if(mediaChoice==2){
            mainMenu.spaces();
                startMenu.getCurrentUser().saveMedia(moviesDisplayed, seriesDisplayed, mediaTitle);
                if (moviesDisplayed){
                    SQL.addSavedMovie(mediaTitle);
                    runMainMenu();
                }
            else if (seriesDisplayed) {
                SQL.addSavedSeries(mediaTitle);
                runMainMenu();
                }
        }
    }
    public static void spaces (){
        int i;
        for(i = 0 ; i < 50 ;){
            System.out.println("");
            i++;
        }
    }
    public static void categorySearch() {
        System.out.println("-------------------------------------------");
        System.out.println("Do you want to search for movies or series?");
        System.out.println("1. Movies");
        System.out.println("2. Series");
        System.out.println("-------------------------------------------");
        Scanner movieorseries = new Scanner(System.in);
        String inputmovieorseries = movieorseries.nextLine();
        if (inputmovieorseries.equals("1")) {
            Movie.movieCategorySearch();
        }
        if (inputmovieorseries.equals("2"))
        {
            Series.seriesCategorySearch();
        }
        else
        {
            mainMenu.spaces();
            System.out.println("-------------------------");
            System.out.println("Please type '1-2' instead");
            System.out.println("-------------------------");
            runMainMenu();
        }
    }
}
