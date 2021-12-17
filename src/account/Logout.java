/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import db.Database;
import db.User;

/**
 *
 * @author mitrajeet
 */
public class Logout {
    public void logout() {
        Database db = new Database();
        db.closeConnection();
    }
}
