import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        File userdata = new File("Data/user.csv");
        Scanner scan = new Scanner(userdata);
        String username = scan.nextLine();
        String password = scan.nextLine();
        int intInputMain;
        boolean loggedIn = false;
        boolean loggingIn = false;

        while(!loggedIn){
            System.out.println("Welcome to our streaming service! \n 1. Log in \n 2. Sign up");
            intInputMain = keyboard.nextInt();
            switch (intInputMain){
                case 1:
                    System.out.println("Type your username:");
                    String inputusername=keyboard.nextLine();
                    System.out.println("Type your password:");
                    String inputpassword=keyboard.nextLine();
                        if(inputusername.equals(username)&&inputpassword.equals(password)){
                            System.out.println("You are now logged in!");
                        }
                        else{
                            System.out.println("Login is incorrect");
                        }
                    loggingIn=true;
                case 2:
                    System.out.println("Select a username:");
                    System.out.println("Select a password:");

            }


        }

    }
}
