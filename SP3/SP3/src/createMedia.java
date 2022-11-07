import java.util.ArrayList;

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
}
