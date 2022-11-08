import java.util.ArrayList;

public class startMenu {
    private static ArrayList<User> users = new ArrayList<>();
    public FileIO fileIO = new FileIO();
    public static User currentUser;
    ArrayList<String> userdata = fileIO.readUserData();
    boolean usersCreated = false;
    public boolean runLogin(String username, String password){
        if (!usersCreated){
            this.createUsers(fileIO.readUserData());
            usersCreated=true;
        }
        return this.loginCheck(users,username,password);
    }
    public static void saveUsers(){
        FileIO.writeUserData(users);
    }
    public static User getCurrentUser(){
        return currentUser;
    }
    public void addUser(String username, String password){
        if(this.usernameCheck(userdata, username)){
            System.out.println("This username is taken");
        }
        else {
            String[] str = {"none"};
            String[] str2 = {"none"};
            String[] str3 = {"none"};
            String[] str4 = {"none"};
            User p = new User(username,password,str,str2,str3,str4);
            users.add(p);
            System.out.println("New user created!");
        }
    }
    private boolean usernameCheck(ArrayList<String> data, String username){
        for (String s : data) {
            String[] values = s.split(";");
            if(username.equals(values[0])){
                return true;
            }
        }
        return false;
    }
    private void createUsers(ArrayList<String> data){
        for (String s : data) {
            String[] values = s.split(";");
            String [] savedMovies = values[2].split(",");
            String [] savedSeries = values[3].split(",");
            String [] watchedMovies = values[4].split(",");
            String [] watchedSeries = values[5].split(",");
            User p = new User(values[0], values[1], savedMovies,savedSeries,watchedMovies,watchedSeries);
            users.add(p);
        }
    }
     private boolean loginCheck(ArrayList<User> users, String username, String password){
         for (User p:users) {
             if(username.equals(p.getUsername())&&password.equals(p.getPassword())){
                 currentUser = p;
                 return true;
             }
         }
         return false;
     }
}

