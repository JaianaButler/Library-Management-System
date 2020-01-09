/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserDao {
    public static boolean validate(String user, String password){
        boolean status = false;
        
        try{
            Connection con = DB.getConnection();
            
            String queryString = "SELECT USERNAME, PASSWORD FROM USERDATA where USERNAME=? and PASSWORD=?";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setString(1,user);
            ps.setString(2,password);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                status = true;
            }else{
                JOptionPane.showMessageDialog(null, "Please Check Username and Password ");
            } 
            results.close();
            con.close();
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
        
        return status;
    }
    
    public static int save(String firstName, String lastName, String username, String password){
        int status = 0;
        
        try{
            Connection con = DB.getConnection();
            String queryString = "insert into USERDATA(FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(queryString);
            
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, password);
            
            status = ps.executeUpdate();
            
            con.close();
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
        return status;
    }
}
