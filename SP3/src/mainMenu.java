public class mainMenu {
    public static int mediaAmount;
    public static boolean seriesDisplayed=false;
    public static boolean moviesDisplayed=false;
    public static void runMainMenu() {
        createMedia.createAllMedia();
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
            System.out.println("3");
        }
        else if(intInputMain == 4){
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
        }
        else if(intInputMain == 5){
            System.out.println("5");
        }
    }
    public static void mediaSelector(){
        Scanner keyboard = new Scanner(System.in);
        int input= keyboard.nextInt();
        int choice=-1+input;
        if(choice>=0&&choice<=mediaAmount){
            System.out.println(createMedia.getTitle(moviesDisplayed,seriesDisplayed,choice)+" is now playing...");
            System.out.println("Press '0' to return to main menu");
            if(keyboard.nextInt()==0){
                runMainMenu();
            }
        }
        else if(input==0){
            runMainMenu();
        }
    }
}
