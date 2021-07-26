/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;


import java.sql.Connection;
import java.sql.DriverManager;
import static javafx.scene.input.KeyCode.J;
import javax.swing.JOptionPane;

/**
 *
 * @author Kasun Deeptha
 */
public class DBconect_1 {
    
    public static Connection connect() {
    
        Connection conn = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            conn = (Connection) DriverManager.getConnection("jdbc:sqlite:timetable.db");
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
    }
    
}
