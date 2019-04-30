package db;


import jdk.nashorn.internal.objects.annotations.Where;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import javax.net.ssl.SSLException;


public class ConnectionDB {
    static private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static private final String DB = "c4EgFjQoFL"; // serial name of the database.
    static private final String DB_URL = "jdbc:mysql://remotemysql.com/" + DB + "?useSSL=false";
    static private final String USER = "c4EgFjQoFL";
    static private final String PASS = "lcOQ5ludsS";
    public String Connect2db(Object msg) throws SSLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            System.out.println("\t============");
            
            

            /* exercize a */
            
            System.out.println("----------------------");
            
            ResultSet ansus = stmt.executeQuery(msg.toString());
            while (ansus.next()) {
            	String userID = ansus.getString("userID");
            	String password = ansus.getString("password");
            	String registerDate = ansus.getString("registerDate");
            }
            stmt.close();
            conn.close();
            

        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState: " + se.getSQLState());
            System.out.println("VendorError: " + se.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}