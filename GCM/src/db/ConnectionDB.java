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
    public String MaxcusID ="";
    
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
    } // end function init
    public void close() {
    	
    	try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    } // end function close

    public String getUserDetails(Object msg) throws SSLException, SQLException { 	
  		System.out.println("----- GetUserDetails -----");
        ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
        while (ansus.next()) {
        	String userID = ansus.getString("userID");
        	String password = ansus.getString("password");
        	String registerDate = ansus.getString("registerDate");
        	ansUser ="@ "+ userID + " " + password + " " + registerDate ; // add registerDATE HERE
        }
        close();
    return ansUser;
    } // end function getUserDetails
    
    public String getCustomerCardDetails(Object msg) throws SSLException, SQLException {
    	System.out.println("----- GetCustomerCardDetails -----");
        ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
        while (ansus.next()) {     	
        	String cusID = ansus.getString("cusID");
        	String customerName = ansus.getString("customerName");
	      	String age = ansus.getString("age");
	      	String phone = ansus.getString("phone");
	      	String Email = ansus.getString("Email");
	      	ansUser = "! " + cusID + " " + customerName + " " + age + " " + phone + " " + Email;
        }
        close();
    return ansUser;
    }
    
public String getCustomerDetails(Object msg) throws SSLException, SQLException {        
    	System.out.println("----- GetCustomerDetails -----");
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

    public void setCustomerDetail(Object msg)throws SSLException, SQLException {
		System.out.println("----- ExecutingCustomerUpdate -----");
		PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
		update.executeUpdate();
		update.close();
		return;
    }
    
	 public void insertUser(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewUser -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	 
	 public void insertCustomer(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewCustomer -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	 
	 public void insertCustomerCard(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewCustomerCard -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	 
	 public String getMaxcusID (Object msg) throws SSLException, SQLException { 
		 System.out.println("----- GettingnMaxcusID -----");
		 ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		 while (ansus.next()) {     	
    	 	MaxcusID = ansus.getString(1);
		 }	
		 System.out.println("THIS IS MAXCUSID : " + MaxcusID );
	     close();
	     return MaxcusID;
	 }
} // end class ConnectionDB