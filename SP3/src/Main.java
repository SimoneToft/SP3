import java.util.Scanner;

public class Main {
    private static startMenu startmenu = new startMenu();
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboardlogin = new Scanner(System.in);
        Scanner keyboardsignup = new Scanner(System.in);

        boolean loggedIn = false;

        while(!loggedIn){
            System.out.println("Welcome to our streaming service! \n 1. Log in \n 2. Sign up");
            int intInputMain;
            intInputMain = keyboard.nextInt();
            if (intInputMain == 1){
                System.out.println("Type your username:");
                String inputusername = keyboardlogin.nextLine();
                System.out.println("Type your password:");
                String inputpassword = keyboardlogin.nextLine();
                if (startmenu.runLogin(inputusername, inputpassword)) {
                    System.out.println("You are logged in");
                    loggedIn = true;
                } else {
                    System.out.println("Incorrect log-in");
                }
            }
                else if(intInputMain == 2) {
                System.out.println("Select a username:");
                String signupusername = keyboardsignup.nextLine();
                System.out.println("Select a password:");
                String signuppassword = keyboardsignup.nextLine();
                startmenu.addUser(signupusername,signuppassword);
            }
            }
        if(loggedIn){
            mainMenu.runMainMenu();
        }
        }

}
