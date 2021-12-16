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
    private final String PASSWORD = "mitgol27";

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void connect() throws SQLException {
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {/* Ignore */
        }
        try {
            ps.close();
        } catch (SQLException e) {/* Ignore */
        }
        try {
            rs.close();
        } catch (SQLException e) {/* Ignore */
        }
    }

    public void createUser(String username, String password, int bankBalance, int cardNumber) throws SQLException {
        String query = "INSERT INTO users (username, password, bank_balance, card_number)"
                + String.format("VALUES ('%s', '%s', '%d', '%d')", username, password, bankBalance, cardNumber);

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ps = conn.prepareStatement(query);
        ps.executeUpdate(query);
    }

    public List<User> getUserData() throws Exception {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users";
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();

        while (rs.next()) {
            User u = new User();
            u.setUserName(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setBankBalance(Integer.parseInt(rs.getString("bank_balance")));
            u.setCardNumber(Integer.toUnsignedLong(Integer.parseInt(rs.getString("card_number"))));
            users.add(u);
        }
        return users;
    }
}
