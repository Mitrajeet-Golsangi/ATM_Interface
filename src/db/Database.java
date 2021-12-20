package db;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {

    private final String URL = "jdbc:postgresql://localhost:5432/ATM_Interface";
    private final String USERNAME = "postgres";
    private final String PASSWORD = System.getenv("PSQL_PAS");

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    /**
     * Establishes a connection to the database to execute all queries.
     * @throws SQLException 
     */
    public void connect() throws SQLException {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    /**
     * Closes the created connection to the database
     */
    public void closeConnection() {
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {/* Ignore */
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {/* Ignore */
        }
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {/* Ignore */
        }
    }
    
    /**
     * Closes the created connection to the database without closing the 
     * result set
     */
    public void closeConnectionWithoutRS() {
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {/* Ignore */
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {/* Ignore */
        }
    }
    
    /**
     * Creates new User in the database
     * @param username      : String    - The username of the user
     * @param password      : String    - The password of the user
     * @param bankBalance   : int       - The initial bank balance of the user
     * @param cardNumber    : int       - The card number of the user
     * @throws SQLException 
     */
    public void createUser(String username, String password, int bankBalance, int cardNumber) throws SQLException {
        String query = "INSERT INTO users (username, password, bank_balance, card_number)"
                + String.format("VALUES ('%s', '%s', '%d', '%d')", username, password, bankBalance, cardNumber);

        ps = conn.prepareStatement(query);
        ps.executeUpdate(query);
    }
    
    /**
     * Returns a list of all users from the database. This contains information 
     * about the users id, username, password, bank_balance and card_number
     * 
     * @return List<User>
     * @throws Exception 
     */
    public List<User> getUserData() throws Exception {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();

        while (rs.next()) {
            User u = new User();
            u.setId(Integer.parseInt(rs.getString("id")));
            u.setUserName(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setBankBalance(Integer.parseInt(rs.getString("bank_balance")));
            u.setCardNumber(Integer.toUnsignedLong(Integer.parseInt(rs.getString("card_number"))));
            users.add(u);
        }
        return users;
    }
    
    /**
     * Updates the bank balance field in the database.
     * @param id            : int       - id of the current user
     * @param bankBalance   : int       - Bank balance of the current user
     * @param updateAmount  : int       - The amount to be added or subtracted
     * @param reduce        : Boolean   - flag to check if withdraw action is performed or deposit
     * @throws SQLException 
     */
    public void updateBankBalance(int id, int bankBalance, int updateAmount, boolean reduce) throws SQLException {
        int balance = reduce ? bankBalance - updateAmount : bankBalance + updateAmount;
        
        System.out.println("db.Database.updateBankBalance() : " + balance);
        System.out.println("db.Database.updateBankBalance() : " + (bankBalance - updateAmount));

        String query = 
                "UPDATE users " + 
                String.format("SET bank_balance='%d' ", balance)+
                String.format("WHERE id=%d", id);
        
        ps = conn.prepareStatement(query);
        ps.executeUpdate();
    }
    
    public void updateLogs(String name, int bankBalance, long cardNumber, int amount, int updatedBalance, boolean withdraw, boolean deposit) throws SQLException {
        String query = "INSERT INTO log (name, card_number, bank_balance, amount, updated_balance, withdraw, deposit) " + 
                String.format(
                        "VALUES ('%s','%d','%d','%d','%d', '%s', '%s')",
                        name,
                        cardNumber,
                        bankBalance,
                        amount,
                        updatedBalance,
                        withdraw,
                        deposit
                );
        ps = conn.prepareStatement(query);
        ps.executeUpdate();
    }
    
    public ResultSet fetchLogs(String name) throws SQLException {
        System.out.println("db.Database.fetchLogs() : " + name);
        String query = "SELECT * from log WHERE name='"+ name +"'";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();
        return rs;
    }
}
