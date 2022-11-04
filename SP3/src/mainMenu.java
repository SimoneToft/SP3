import java.util.Scanner;
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
            mediaSelector();
        }
        else if(intInputMain == 2){
            mediaAmount=createMedia.allSeries();
            seriesDisplayed=true;
            mediaSelector();
        }
        else if(intInputMain == 3){
            System.out.println("3");
        }
        else if(intInputMain == 4){
            System.out.println("4");
        }
        else if(intInputMain == 5){
            System.out.println("5");
        }
    }
    public static void mediaSelector(){
        Scanner keyboard = new Scanner(System.in);
        int choice=-1+keyboard.nextInt();
        if(choice>=0&&choice<=mediaAmount){
            System.out.println(createMedia.getTitle(moviesDisplayed,seriesDisplayed,choice)+" is now playing...");
        }
    }
}
