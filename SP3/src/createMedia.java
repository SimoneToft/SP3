import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class createMedia {
    static FileIO fileIO = new FileIO();
    static ArrayList<Movie> movies = new ArrayList<>();
    static ArrayList<Series> series = new ArrayList<>();

    public static void createAllMedia(){
        ArrayList<String> movieData = fileIO.readMovieData();
        ArrayList<String> seriesData = fileIO.readSeriesData();
        movieList(movieData);
        seriesList(seriesData);

    }
    public static String getTitle(boolean a, boolean b, int i){
        if(a){
            return movies.get(i).getMediaTitle();
        }
        else if(b){
            return series.get(i).getMediaTitle();
        }
        return null;
    }
    private static void movieList(ArrayList<String> data) {
        for (String s : data) {
            String[] values = s.split(";");
            String [] categories = values[2].replaceAll(" ", "").split(",");
            Movie p = new Movie(values[0], values[1].replace(" ",""), categories, values[3].replace(" ",""));
            movies.add(p);
        }
    }
    private static void seriesList(ArrayList<String> data) {
        for (String s : data) {
            String[] values = s.replaceAll(" ", " ").split(";");
            String [] categories = values[2].replaceAll(" ", "").split(",");
            String [] seasons = values[4].replaceAll(" ", "").split(",");
            Series p = new Series(values[0], values[1].replace(" ",""), categories, values[3].replace(" ",""),seasons);
            series.add(p);
        }
    }
    public static int allMovies(){
        int i = 1;
        for (Movie p : movies){
            System.out.println(i+". "+p);
            i++;
        }
        return i-1;
    }
    public static int allSeries(){
        int i = 1;
        for (Series p : series){
            System.out.println(i+". "+p);
            i++;
        }
        return i-1;
    }
    public static void seasonList(int choice) {
        ArrayList<String> seasonList = new ArrayList<>();
        ArrayList<String> episodeList = new ArrayList<>();
        Series p = series.get(choice);
        for (String s : p.getSeriesSeasons()) {
            String[] seasons = s.replaceAll(",","-").replaceAll(" ", "").split("-");
            for(int i = 0; i<seasons.length; i++) {
                if(i%2!=0) {
                    episodeList.add(seasons[i]);
                }
                else if(i%2==0) {
                    seasonList.add(seasons[i]);
                }
            }
        }
        seasonChoice(seasonList, episodeList);
    }

    public static void seasonChoice(ArrayList<String>seasonList, ArrayList<String>episodeList) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Press '0' to return to main menu");
        System.out.println("Or select a season from the list");
        System.out.println("--------------------------------");
        for(String k: seasonList) {
            System.out.println("Season: "+k);
        }
        int seasonChoice=keyboard.nextInt();
        if(seasonChoice==0) {
            mainMenu.spaces();
            System.out.println("------------------");
            mainMenu.runMainMenu();
        }
        else if(seasonChoice>0&&seasonChoice<=seasonList.size()) {
            System.out.println("You have selected season "+seasonChoice);
            episodeChoice(seasonChoice, episodeList);
        }
    }
    public static void episodeChoice(int seasonChoice, ArrayList<String>episodeList) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Press '0' to return to main menu");
        System.out.println("Or select a episode from the list");
        System.out.println("--------------------------------");
        for(int i=1; i<=Integer.parseInt(episodeList.get(seasonChoice-1));i++) {
            System.out.println("Episode: "+i);
        }
        int episodeChoice=keyboard.nextInt();
        if(episodeChoice==0) {
            mainMenu.spaces();
            System.out.println("------------------");
            mainMenu.runMainMenu();
        }
        else if(episodeChoice>0&&episodeChoice-1<=Integer.parseInt(episodeList.get(seasonChoice-1))) {
            System.out.println("You have selected episode "+episodeChoice);
        }
    }
}