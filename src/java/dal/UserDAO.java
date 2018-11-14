/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author Nguyen Thai Bao
 */
public class UserDAO extends BaseDAO {
    
    public User getUser(String uname) {
        User user = null;
        try {
            String query = "SELECT username, password, fullname, role "
                    + "FROM Users where username = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String role = rs.getString("role");
                user = new User(username, password, fullname, role);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
    
    public void registerUser(String username, String password, String fullName, String role) {
        try {
            String query = "INSERT INTO Users(username, password, fullname, role) "
                    + "VALUES(?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setString(4, role);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
