import java.util.ArrayList;
import java.util.Arrays;

public class startMenu {
    public User currentUser;
    private ArrayList<User> users = new ArrayList<>();
    public FileIO fileIO = new FileIO();
    public boolean runLogin(String username, String password){
        ArrayList<String> userdata = fileIO.readUserData();
        this.createUsers(userdata);
        return this.loginCheck(userdata,username,password);
    }
    public void addUser(String username, String password){
        FileIO.newUser(username,password);
    }
    private void createUsers(ArrayList<String> data){
        for (String s : data) {
            String[] values = s.replaceAll(" ","").split(",");
            User p = new User(values[0], values[1]);
            users.add(p);
        }
    }
     private boolean loginCheck(ArrayList<String> data, String username, String password){
         for (String s : data) {
             String[] values = s.replaceAll(" ","").split(",");
             if(username.equals(values[0])&&password.equals(values[1])){
                 currentUser = users.get(Arrays.asList(values).indexOf(username));
                 return true;
             }
         }
         return false;
     }

}

