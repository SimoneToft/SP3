import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String[] savedMovies;
    private String[] savedSeries;
    private String[] watchedMovies;
    private String[] watchedSeries;

    public User(String username, String password, String[] savedMovies, String[] savedSeries, String[] watchedMovies, String[] watchedSeries){
        this.username=username;
        this.password=password;
        this.savedMovies=savedMovies;
        this.savedSeries=savedSeries;
        this.watchedMovies=watchedMovies;
        this.watchedSeries=watchedSeries;
    }
    public void saveMedia(boolean a, boolean b, String str){
        if(a){
            List<String> mediaList;
            boolean alreadySaved = false;
            if(!Objects.equals(savedMovies[0], "null")){
                mediaList = new ArrayList<String>(Arrays.asList(savedMovies));
            }
            else{
                mediaList = new ArrayList<String>();
            }
            for(String saved : savedMovies)
            {
                if(saved.equals(str))
                {
                    alreadySaved = true;
                    break;
                }
            }
            if(!alreadySaved) {
                mediaList.add(str);
                savedMovies = mediaList.toArray(savedMovies);
                startMenu.saveUsers();

            }

        }
        if (b){
            List<String> mediaList;
            boolean alreadySaved = false;
            if(!Objects.equals(savedSeries[0], "null")){
                mediaList = new ArrayList<String>(Arrays.asList(savedSeries));
            }
            else{
                mediaList = new ArrayList<String>();
            }
            for(String saved : savedSeries)
            {
                if(saved.equals(str))
                {
                    alreadySaved = true;
                    break;
                }
            }
            if(!alreadySaved) {
                mediaList.add(str);
                savedSeries = mediaList.toArray(savedSeries);
                startMenu.saveUsers();
            }
        }
    }
    public void watchedMedia(boolean a, boolean b, String str){
        if(a){
            List<String> mediaList;
            boolean alreadyWatched = false;
            if(!Objects.equals(watchedMovies[0], "null")){
                mediaList = new ArrayList<String>(Arrays.asList(watchedMovies));
            }
            else{
                mediaList = new ArrayList<String>();
            }
            for(String watched : watchedMovies)
            {
                if(watched.equals(watchedMovies))
                {
                    alreadyWatched = true;
                    break;
                }
            }
            if(!alreadyWatched) {
                mediaList.add(str);
                watchedMovies = mediaList.toArray(watchedMovies);
                startMenu.saveUsers();
            }
        }
        if (b){
            List<String> mediaList;
            boolean alreadyWatched = false;
            if(!Objects.equals(watchedSeries[0], "null")){
                mediaList = new ArrayList<String>(Arrays.asList(watchedSeries));
            }
            else{
                mediaList = new ArrayList<String>();
            }
            for(String watched : watchedSeries)
            {
                if(watched.equals(str))
                {
                    alreadyWatched = true;
                    break;
                }
            }
            if(!alreadyWatched) {
                mediaList.add(str);
                watchedSeries = mediaList.toArray(watchedSeries);
                startMenu.saveUsers();
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getSavedMovies() {
        return savedMovies;
    }

    public String[] getSavedSeries() {
        return savedSeries;
    }

    public String[] getWatchedMovies() {
        return watchedMovies;
    }

    public String[] getWatchedSeries() {
        return watchedSeries;
    }

    public String getSaved() {
        String savedMovieList= "|SAVED MOVIES|\n";
        String savedSeriesList= "|SAVED SERIES|\n";
        String noSavedMovies="You have no saved movies\n";
        String noSavedSeries="You have no saved series\n";
        return getString(savedMovieList, savedSeriesList, savedMovies, savedSeries, noSavedMovies,noSavedSeries);
    }
    public String getWatched() {
        String watchedMovieList= "|WATCHED MOVIES|\n";
        String watchedSeriesList= "|WATCHED SERIES|\n";
        String noWatchedMovies="You have no watched movies\n";
        String noWatchedSeries="You have no watched series\n";
        return getString(watchedMovieList, watchedSeriesList, watchedMovies, watchedSeries, noWatchedMovies,noWatchedSeries);
    }

    private String getString(String watchedMovieList, String watchedSeriesList, String[] watchedMovies, String[] watchedSeries,String noMovies, String noSeries) {
        int number=1;
        if(Objects.equals(watchedMovies[0], "null")){
            watchedMovieList+=noMovies;
        }
        else {
            for(String p : watchedMovies){
                watchedMovieList+=number+". "+p+"\n";
                number++;
            }
        }
        if (Objects.equals(watchedSeries[0],"null")){
            watchedSeriesList+=noSeries;
        }
        else {
            for (String p : watchedSeries){
                watchedSeriesList+=number+". "+p+"\n";
                number++;
            }
        }

        return watchedMovieList+watchedSeriesList;
    }
}

