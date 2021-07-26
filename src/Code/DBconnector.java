package Code;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DBconnector {
    public static Connection Connect(){
        
        Connection conn = null;
        
        try {
           Class.forName("org.sqlite.JDBC");
            conn =DriverManager.getConnection("jdbc:sqlite:timetable.db");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }
}
