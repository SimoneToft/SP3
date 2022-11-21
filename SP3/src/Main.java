import java.util.Scanner;

public class Main {
    private static startMenu startmenu = new startMenu();

        public static void main(String[] args) {
        SQL.establishConnection();
        loginScreen();
    }
    public static void loginScreen(){

        System.out.println("--------------------------------");
        System.out.println("Welcome to our streaming service! \n 1. Log in \n 2. Sign up");
        System.out.println("--------------------------------");

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
                mainMenu.spaces();
                System.out.println("--------------------------------");
                System.out.println("Please input '1' or '2' instead");
                loginScreen();          //returns to login, if number is wrong
            }
        }
        catch (Exception e){
            mainMenu.spaces();
            System.out.println("--------------------------------");
            System.out.println("Please input '1' or '2' instead");
            loginScreen();             //returns to login, if input is wrong
        }
        while(loggingIn==true){
            System.out.println("-------------------");
            System.out.println("Type your username:");
            System.out.println("--------------------");
            String inputusername = keyboardlogin.nextLine();
            System.out.println("-------------------");
            System.out.println("Type your password:");
            System.out.println("-------------------");
            String inputpassword = keyboardlogin.nextLine();
            if (startmenu.runLogin(inputusername, inputpassword)) {
                mainMenu.spaces();
                System.out.println("---------------------");
                System.out.println("You are now logged in");
                System.out.println("---------------------");
                mainMenu.mediaCreate();
                mainMenu.runMainMenu();

            } else {

                mainMenu.spaces();
                System.out.println("----------------");
                System.out.println("Incorrect log-in");
                System.out.println("----------------");
                loginScreen();
            }
        }
        while (signingUp==true){
            System.out.println("------------------");
            System.out.println("Select a username:");
            System.out.println("------------------");
            String signupusername = keyboardsignup.nextLine();
            System.out.println("------------------");
            System.out.println("Select a password:");
            System.out.println("------------------");
            String signuppassword = keyboardsignup.nextLine();
            startmenu.addUser(signupusername, signuppassword);
            loginScreen();
        }
    }
}
