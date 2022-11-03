import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;


public class FileIO {
    public ArrayList<String> readUserData(){
        File userfile = new File("Data/user.csv");
        ArrayList<String> userdata = new ArrayList<>();
        try{
            Scanner input = new Scanner(userfile);
            input.nextLine();
            while (input.hasNextLine()){
                userdata.add(input.nextLine());
            }
        } catch (FileNotFoundException e){
            userdata=null;
        }
        return userdata;
    }
    public static void newUser(String username, String password){
        try {
            FileWriter writer = new FileWriter("Data/user.csv", true);
            writer.write("\n"+username+","+password);
            writer.close();
        }
        catch (IOException e){
            System.out.println(e);
        }

    }
}

