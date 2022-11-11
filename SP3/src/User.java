import java.util.*;

public class User {
    private String username;
    private String password;
    private String[] savedMovies;
    private String[] savedSeries;
    private String[] watchedMovies;
    private String[] watchedSeries;

    public User(String username, String password, String[] savedMovies, String[] savedSeries, String[] watchedMovies, String[] watchedSeries) {
        this.username = username;
        this.password = password;
        this.savedMovies = savedMovies;
        this.savedSeries = savedSeries;
        this.watchedMovies = watchedMovies;
        this.watchedSeries = watchedSeries;
    }

    public void saveMedia(boolean a, boolean b, String str) {
        if (a) {
            List<String> saveMovieList;
            boolean alreadySaved = false;
            if (!Objects.equals(savedMovies[0], "none")) {
                saveMovieList = new ArrayList<String>(Arrays.asList(savedMovies));
            } else {
                saveMovieList = new ArrayList<String>();
            }
            for (String saved : savedMovies) {
                if (saved.contains(str)) {
                    alreadySaved = true;
                    System.out.println(str + " is already saved");
                    System.out.println("-------------------------------");
                    break;
                }
            }
            if (!alreadySaved) {
                saveMovieList.add(str);
                savedMovies = saveMovieList.toArray(savedMovies);
                System.out.println(str + " is now saved.");
                System.out.println("-----------------------------------");
                startMenu.saveUsers();
            }

        }
        if (b) {
            List<String> mediaList;
            boolean alreadySaved = false;
            if (!Objects.equals(savedSeries[0], "none")) {
                mediaList = new ArrayList<String>(Arrays.asList(savedSeries));
            } else {
                mediaList = new ArrayList<String>();
            }
            for (String saved : savedSeries) {
                if (saved.equals(str)) {
                    alreadySaved = true;
                    System.out.println(str + " is already saved");
                    System.out.println("--------------------------");
                    break;
                }
            }
            if (!alreadySaved) {
                mediaList.add(str);
                savedSeries = mediaList.toArray(savedSeries);
                System.out.println(str + " is now saved.");
                System.out.println("------------------------------");
                startMenu.saveUsers();
            }
        }
    }

    public void watchedMedia(boolean a2, boolean b2, String str) {
        if (a2) {
            List<String> mediaList;
            boolean alreadyWatched = false;
            if (!Objects.equals(watchedMovies[0], "none")) {
                mediaList = new ArrayList<String>(Arrays.asList(watchedMovies));
            } else {
                mediaList = new ArrayList<String>();
            }
            for (String watched : watchedMovies) {
                if (watched.equals(str)) {
                    alreadyWatched = true;
                    break;
                }
            }
            if (!alreadyWatched) {
                mediaList.add(str);
                watchedMovies = mediaList.toArray(watchedMovies);
                startMenu.saveUsers();
            }
        }
        if (b2) {
            List<String> mediaList;
            boolean alreadyWatched = false;
            if (!Objects.equals(watchedSeries[0], "none")) {
                mediaList = new ArrayList<String>(Arrays.asList(watchedSeries));
            } else {
                mediaList = new ArrayList<String>();
            }
            for (String watched : watchedSeries) {
                if (watched.equals(str)) {
                    alreadyWatched = true;
                    break;
                }
            }
            if (!alreadyWatched) {
                mediaList.add(str);
                watchedSeries = mediaList.toArray(watchedSeries);
                startMenu.saveUsers();
            }
        }
    }

    public void setSavedMovies(String[] savedMovies) {
        this.savedMovies = savedMovies;
    }

    public void setSavedSeries(String[] savedSeries) {
        this.savedSeries = savedSeries;
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
        String savedMovieList = "|SAVED MOVIES|\n";
        String savedSeriesList = "|SAVED SERIES|\n";
        String noSavedMovies = "You have no saved movies\n";
        String noSavedSeries = "You have no saved series\n";
        return getString(savedMovieList, savedSeriesList, savedMovies, savedSeries, noSavedMovies, noSavedSeries);
    }

    public String getWatched() {
        String watchedMovieList = "|WATCHED MOVIES|\n";
        String watchedSeriesList = "|WATCHED SERIES|\n";
        String noWatchedMovies = "You have no watched movies\n";
        String noWatchedSeries = "You have no watched series\n";
        return getString(watchedMovieList, watchedSeriesList, watchedMovies, watchedSeries, noWatchedMovies, noWatchedSeries);
    }

    private String getString(String watchedMovieList, String watchedSeriesList, String[] watchedMovies, String[] watchedSeries, String noMovies, String noSeries) {
        int number = 1;
        if (Objects.equals(watchedMovies[0], "none")) {
            watchedMovieList += noMovies;
        } else {
            for (String p : watchedMovies) {
                watchedMovieList += number + ". " + p + "\n";
                number++;
            }
        }
        if (Objects.equals(watchedSeries[0], "none")) {
            watchedSeriesList += noSeries;
        } else {
            for (String p : watchedSeries) {
                watchedSeriesList += number + ". " + p + "\n";
                number++;
            }
        }

        return watchedMovieList + watchedSeriesList;
    }

    public void deleteMedia()                   //Function to delete saved media titles both movie and series
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Do you want to delete a movie or series from your saved media?");
        System.out.println("1. Movie");
        System.out.println("2. Series");
        System.out.println("---------------------------------------------------------------");
        String userInput = scanner.nextLine();
        if (userInput.equals("1"))                                   //Execution if user wants to delete movie
        {
            if (Objects.equals(savedMovies[0], "none")) {
                System.out.println("There are no movies to delete");
                mainMenu.runMainMenu();
            }
            System.out.println("------------------------------------");         //reprint saved movies with a line above
            System.out.println("|SAVED MOVIES|");
            int i = 1;
            for (String s : savedMovies) {
                System.out.println(i + ". " + s);
                i++;
            }
            System.out.println("------------------------------------");             //let user choose what specific movie to delete
            System.out.println("Choose what movie you want to delete");
            System.out.println("------------------------------------");
            int userInt = scanner.nextInt() - 1;
            System.out.println("Are you sure you want to delete " + savedMovies[userInt] + " permanently from your saved media list?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int userInt2 = scanner.nextInt();
            if (userInt2 == 1) {
                String toBePrinted = savedMovies[userInt] + " has been removed from your saved media list";
                List<String> mediaList;
                String[] noneList = {"none"};
                if (1 == savedMovies.length) {
                    savedMovies = noneList;
                } else {
                    mediaList = new ArrayList<String>(Arrays.asList(savedMovies));
                    mediaList.remove(userInt);
                    savedMovies = mediaList.toArray(new String[mediaList.size()]);
                }
                System.out.println(toBePrinted);
                System.out.println(startMenu.getCurrentUser().getSaved());
                startMenu.saveUsers();
            }
            else {
                mainMenu.spaces();
                mainMenu.runMainMenu();
            }

        }
        if (userInput.equals("2"))                           //Execution if user wants to delete movie
        {
            if (Objects.equals(savedSeries[0], "none")) {
                System.out.println("There are no series to delete");
                mainMenu.runMainMenu();
            }
            System.out.println("------------------------------------");         //reprint saved movies with a line above
            System.out.println("|SAVED SERIES|");
            int i = 1;
            for (String s : savedSeries) {
                System.out.println(i + ". " + s);
                i++;
            }
            System.out.println("------------------------------------");             //let user choose what specific movie to delete
            System.out.println("Choose what series you want to delete");
            System.out.println("------------------------------------");
            int userInt = scanner.nextInt() - 1;
            System.out.println("Are you sure you want to delete " + savedSeries[userInt] + " permanently from your saved media list?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int userInt2 = scanner.nextInt();
            if (userInt2 == 1) {
                String toBePrinted = savedSeries[userInt] + " has been removed from your saved media list";
                List<String> mediaList;
                String[] noneList = {"none"};
                if (1 == savedSeries.length) {
                    savedSeries = noneList;
                } else {
                    mediaList = new ArrayList<String>(Arrays.asList(savedSeries));
                    mediaList.remove(userInt);
                    savedSeries = mediaList.toArray(new String[mediaList.size()]);
                }
                System.out.println(toBePrinted);
                System.out.println(startMenu.getCurrentUser().getSaved());
                startMenu.saveUsers();
            } else {
                mainMenu.spaces();
                mainMenu.runMainMenu();
            }
        }
    }


}
