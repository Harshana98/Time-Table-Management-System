/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import static javafx.scene.input.KeyCode.J;
import javax.swing.JOptionPane;

/**
 *
 * @author Kasun Deeptha
 */
public class DBconect {
    
    private static java.sql.Connection conn;
    private static Statement st;
    
    public static Statement connect() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            String url ="jdbc:sqlite:timetable.db";
            conn =DriverManager.getConnection(url);
            st=conn.createStatement();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return st;
    }
    
}
