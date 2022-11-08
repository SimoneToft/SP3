import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    public ArrayList<String> readMovieData(){
        File userfile = new File("Data/movies.csv");
        return getStrings(userfile);
    }

    private ArrayList<String> getStrings(File userfile) {
        ArrayList<String> moviedata = new ArrayList<>();
        try{
            Scanner input = new Scanner(userfile);
            while (input.hasNextLine()){
                moviedata.add(input.nextLine());
            }
        } catch (FileNotFoundException e){
            moviedata=null;
        }
        return moviedata;
    }

    public ArrayList<String> readSeriesData(){
        File userfile = new File("Data/series.csv");
        return getStrings(userfile);
    }
    public static void writeUserData(ArrayList<User> users){
        try{
            FileWriter writer = new FileWriter("Data/user.csv");
            writer.write("userName, userPassword, savedMovies, savedSeries, watchedMovies, watchedSeries");
            for (User p : users){
                writer.write("\n"+p.getUsername()+";"+p.getPassword()+";"+Arrays.toString(p.getSavedMovies()).replace("[","").replace("]","").replace(", ",",") +";"+ Arrays.toString(p.getSavedSeries()).replace("[","").replace("]","").replace(", ",",") +";"+ Arrays.toString(p.getWatchedMovies()).replace("[","").replace("]","").replace(", ",",") +";"+ Arrays.toString(p.getWatchedSeries()).replace("[","").replace("]","").replace(", ",","));
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
