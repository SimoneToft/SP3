import java.util.Scanner;

public class Main {
    private static startMenu startmenu = new startMenu();
    public static void main(String[] args) {
        loginScreen();
    }
    public static void loginScreen(){
        System.out.println("Welcome to our streaming service! \n 1. Log in \n 2. Sign up");

        Scanner keyboard = new Scanner(System.in);
        Scanner keyboardsignup = new Scanner(System.in);
        Scanner keyboardlogin = new Scanner(System.in);
        boolean loggingIn=false;
        boolean signingUp=false;

        try {
            int intInputMain = keyboard.nextInt();

            if (intInputMain == 1) {
                loggingIn=true;
            }  else if (intInputMain == 2) {
                signingUp=true;
            }
            else if (intInputMain!=1||intInputMain!=2){
              System.out.println("-------------------------------");
              System.out.println("Please input '1' or '2' instead");
              System.out.println("-------------------------------");
              loginScreen();
            }
        }
        catch (Exception e){
            System.out.println("-------------------------------");
            System.out.println("Please input '1' or '2' instead");
            System.out.println("-------------------------------");
            loginScreen();
        }
        while(loggingIn==true){
            System.out.println("Type your username:");
            String inputusername = keyboardlogin.nextLine();
            System.out.println("Type your password:");
            String inputpassword = keyboardlogin.nextLine();
            if (startmenu.runLogin(inputusername, inputpassword)) {
                System.out.println("---------------------");
                System.out.println("You are now logged in");
                System.out.println("---------------------");
                mainMenu.mediaCreate();
                mainMenu.runMainMenu();
            } else {
                System.out.println("----------------");
                System.out.println("Incorrect log-in");
                System.out.println("----------------");
                loginScreen();
            }
        }
        while (signingUp==true){
            System.out.println("Select a username:");
            String signupusername = keyboardsignup.nextLine();
            System.out.println("Select a password:");
            String signuppassword = keyboardsignup.nextLine();
            startmenu.addUser(signupusername, signuppassword);
            loginScreen();
        }
    }
}
