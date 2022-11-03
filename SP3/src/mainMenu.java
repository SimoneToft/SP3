import java.util.Scanner;

public class mainMenu {
    public static void runMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. View all movies\n2. Search\n3. Categories\n4. Watched\n5. Saved");
        int intInputMain;
        intInputMain = keyboard.nextInt();
        if(intInputMain == 1){
            System.out.println("1");
        }
        else if(intInputMain == 2){
            System.out.println("2");
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
}

