/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mitrajeet
 */
public class Tester {
    public static void main(String[] args) {
        Database db = new Database();
        try {
            db.connect();
            System.out.println("db.Tester.main() : Connection successfull");
            try {
                List<User> users = db.getUserData();
                System.out.println("db.Tester.main() " + users.get(0).getUserName());
            } catch(Exception e){
                System.out.println("db.Tester.main()" + "Error Fetching Data");
                e.printStackTrace();
            }
            db.closeConnection();
        } catch(SQLException e){
            System.out.println("db.Tester.main()" + "Error connecting to Database");
            e.printStackTrace();
        }
    }
}
