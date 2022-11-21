import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class SQL {
    static Connection connection;
    static String url = "jdbc:mysql://localhost:3306/?user=root" + "autoReconnect=true&useSSL=false";
    static String username = "root";
    static String password = "1234";



    static ArrayList<Movie> movies = new ArrayList<>();
    static ArrayList<Series> series = new ArrayList<>();

    public static void createMovieList()
    {
        int number = 1;
        String query = "SELECT * FROM sp3_media.movies";
        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while(result.next())
            {
                String movieTitle = result.getString("Title");
                String releaseYear = result.getString("Release Year");
                String movieCategory = result.getString("Category");
                String [] categories = movieCategory.replaceAll(" ", "").split(",");
                String movieRating = result.getString("Rating");
                Movie movie = new Movie(movieTitle, releaseYear, categories, movieRating);
                movies.add(movie);
            }
            for (Movie i: movies){
                System.out.println(number + ". " + i);
                number ++;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static void createSeriesList()
    {
        int number = 1;
        String query = "SELECT * FROM sp3_media.series";
        try
        {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while(result.next())
            {
                String movieTitle = result.getString("Title");
                String releaseYear = result.getString("Release Year");
                String movieCategory = result.getString("Category");
                String [] categories = movieCategory.replaceAll(" ", "").split(",");
                String movieRating = result.getString("Rating");
                String seriesSeasons = result.getString("Seasons/Episodes");
                String [] seasons = seriesSeasons.replaceAll(" ", "").split(",");
                Series serie= new Series(movieTitle, releaseYear, categories, movieRating, seasons);
                series.add(serie);
            }
            for (Series i: series){
                System.out.println(number + ". " + i);
                number ++;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static void addSavedSeries(String series) {

        String SeriesCheck = "SELECT * FROM sp3_media.user savedSeries WHERE userName = ? AND userPassword = ?";
        String savedSeries = null;
        try {

            PreparedStatement statement = connection.prepareStatement(SeriesCheck);
            statement.setString(1, startMenu.getCurrentUser().getUsername());
            statement.setString(2, startMenu.getCurrentUser().getPassword());

            ResultSet resultCheck = statement.executeQuery();
            if (resultCheck.next()) {
                savedSeries = resultCheck.getString("savedSeries");
            }
            if (savedSeries.contains(series)) {
                return;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        String query = "UPDATE sp3_media.user SET savedSeries = CONCAT (savedSeries, ?) WHERE userName = ? AND userPassword = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, series+",");
            statement.setString(2, startMenu.getCurrentUser().getUsername());
            statement.setString(3, startMenu.getCurrentUser().getPassword());
            statement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSavedMovie(String movie) {

        String movieCheck = "SELECT * FROM sp3_media.user savedMovies WHERE userName = ? AND userPassword = ?";
        String savedMovies = null;
        try {

            PreparedStatement statement = connection.prepareStatement(movieCheck);
            statement.setString(1, startMenu.getCurrentUser().getUsername());
            statement.setString(2, startMenu.getCurrentUser().getPassword());
            ResultSet resultCheck = statement.executeQuery();

            if (resultCheck.next()) {
                savedMovies = resultCheck.getString("savedMovies");
            }
            if (savedMovies.contains(movie)) {
                return;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        String query = "UPDATE sp3_media.user SET savedMovies = CONCAT (savedMovies, ?) WHERE userName = ? AND userPassword = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, movie+",");
            statement.setString(2, startMenu.getCurrentUser().getUsername());
            statement.setString(3, startMenu.getCurrentUser().getPassword());
            statement.executeUpdate();

            if(savedMovies.contains("none")){
                query = "DELETE FROM sp3_media.user WHERE savedMovies = (none) WHERE userName = ? AND userPassword = ?";
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection establishConnection()
    {
        try
        {
            connection = DriverManager.getConnection(url, username, password);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

}
