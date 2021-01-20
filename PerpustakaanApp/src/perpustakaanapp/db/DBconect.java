/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jodi afandi
 */
public class DBconect {
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String DB = "perpustakaanapp";
    private static final String MYCONN = "jdbc:mysql://localhost/" + DB;
    private static final String SQCONN = "jdbc:sqlite:PerpustakaanApp.sqlite";
    
    public static Connection getConnection(String driver) throws SQLException{
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                 try {
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQCONN);
                   } catch (ClassNotFoundException ex) {
                    System.out.println("Librari tidak ada");
                    Logger.getLogger(DBconect.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.Driver");
                    conn = DriverManager.getConnection(MYCONN, USER, PASSWORD);
                   } catch (ClassNotFoundException ex) {
                    System.out.println("Librari tidak ada");
                    Logger.getLogger(DBconect.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
            }
        }
        
        return conn;
    }
}
