package account;

import db.Database;
import db.User;
import java.sql.SQLException;
import java.util.List;

public class Login {
    private static User currentUser;
    
    /**
     * Checks if the provided credentials match any user in the database
     * @param username  : String    - username to search in the database
     * @param password  : String    - password to search in the database
     * @return 
     */
    public static String checkLogin(String username, String password) {
        Database db = new Database();
        try {
            db.connect();
            try {
                List<User> users = db.getUserData();
                for (User u : users) {
                    if (u.getCredentials()[0].equals(username) && u.getCredentials()[1].equals(password)) {
                        currentUser = u;
                        return null;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error connecting to the Database !";
        }
        return "Username or Password Incorrect!";
    }
    
    /**
     * Returns the instance of the User which has been logged in.
     * @return User
     */
    public static User getCurrentUser() {
        return Login.currentUser;
    }
}
