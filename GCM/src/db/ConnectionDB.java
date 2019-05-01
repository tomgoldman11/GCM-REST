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
    Connection conn = null;
    Statement stmt = null;
    public String ansUser;
    public void init() {
    	
    	
         try {
             Class.forName(JDBC_DRIVER);
             conn = DriverManager.getConnection(DB_URL, USER, PASS);
             stmt = conn.createStatement();
         } catch (SQLException se) {
             se.printStackTrace();
             System.out.println("SQLException: " + se.getMessage());
             System.out.println("SQLState: " + se.getSQLState());
             System.out.println("VendorError: " + se.getErrorCode());
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
    public void close() {
    	
    	try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public String Connect2db(Object msg) throws SSLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();


    
    public String getUserDetails(Object msg) throws SSLException, SQLException {
            System.out.println("\t============");
            System.out.println("----------------------");    
            ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
            while (ansus.next()) {
            	String userID = ansus.getString("userID");
            	String password = ansus.getString("password");
            	String registerDate = ansus.getString("registerDate");
            	ansUser ="@ "+ userID + " " + password ;
            }

            close();
   
        return ansUser;
    }
    public String getCustomerDetails(Object msg) throws SSLException, SQLException {
        

            }
            stmt.close();
            conn.close();
            


        System.out.println("\t============");
        System.out.println("customerDB");
        
        ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
        while (ansus.next()) {
        	
        	String userID = ansus.getString("userID");
        	String cusID = ansus.getString("cusID");
	      	String purchases = ansus.getString("purchases");
	      	ansUser = "% " + userID + " " + cusID + " " + purchases;
        }
        close();
    return ansUser;
    }
    
    public void setCustoerDetail(Object msg)throws SSLException, SQLException {
    	
    		System.out.println(msg.toString().substring(1));
    		System.out.println("customerUpdate");
    		PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
    		update.executeUpdate();
    		update.close();
    		return;

    }
    	
}