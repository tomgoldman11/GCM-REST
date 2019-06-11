package db;


import jdk.nashorn.internal.objects.annotations.Where;
import models.City;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import javax.net.ssl.SSLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;


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
    public ArrayList<String> ArrayListFromDB = new ArrayList<String>();
    
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
	
	public String getEmployeeDetails(Object msg) throws SSLException, SQLException { 	
			System.out.println("----- GetEmployeeDetails -----");
	    ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
	    ansUser = "42";
	    while (ansus.next()) {
	    	String userID = ansus.getString("userID");
	    	String employeeID = ansus.getString("employeeID");
	    	String roleID = ansus.getString("roleID");
	    	String jobTitle = ansus.getString("jobTitle");
	    	String fullName = ansus.getString("fullName");
	    	String email = ansus.getString("email");
	    	String phone = ansus.getString("phone");
	    	ansUser ="E "+ userID + " " + employeeID + " " + roleID + " " + jobTitle + " " + fullName + " " + email + " " + phone ; // add registerDATE HERE
	    }
		close();
		return ansUser;
		} // end function getEmployeeDetails

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
	 
	 public void insertOTSub(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewOTsub -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	 
	 public void insertFSub(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewFsub -----");
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
	 
	 public String getMaxOTSubID (Object msg) throws SSLException, SQLException { 
		 System.out.println("----- GettingnMaxOTSubID -----");
		 ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		 while (ansus.next()) {     	
    	 	MaxcusID = ansus.getString(1);
		 }	
		 System.out.println("THIS IS MaxOTSubID : " + MaxcusID );
	     close();
	     return MaxcusID;
	 }
	 
	 public String getMaxFSubID (Object msg) throws SSLException, SQLException { 
		 System.out.println("----- GettingnMaxFSubID -----");
		 ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		 while (ansus.next()) {     	
    	 	MaxcusID = ansus.getString(1);
		 }	
		 System.out.println("THIS IS MaxOTSubID : " + MaxcusID );
	     close();
	     return MaxcusID;
	 }
	 
	 
	 public void updateCustomerCardCustomerUser(Object msg) throws SSLException, SQLException {
		 System.out.println("----- UpdateCustomerCard -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	 
	public ArrayList<String> getCities (Object msg) throws SSLException, SQLException {
		System.out.println("----- GettingCities -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		ArrayListFromDB.add("getcities");
		while (ansus.next()) {
			int cityID = ansus.getInt("cityID");
			String description = ansus.getString("description");
			double mapClusterVersion = ansus.getDouble("mapsClusterVersion");
			int numberMaps = ansus.getInt("numMaps");
			int numberTours = ansus.getInt("numTours");
			int numberLocations = ansus.getInt("numLocations");
			double mapClusterPrice = ansus.getDouble("mapsClusterPrice");
			String cityName = ansus.getString("cityName");
			//------------------------------------------------------------
			ArrayListFromDB.add(Integer.toString(cityID));
			ArrayListFromDB.add(description);
			ArrayListFromDB.add(Double.toString(mapClusterVersion));
			ArrayListFromDB.add(Integer.toString(numberMaps));
			ArrayListFromDB.add(Integer.toString(numberTours));
			ArrayListFromDB.add(Integer.toString(numberLocations));
			ArrayListFromDB.add(Double.toString(mapClusterPrice));
			ArrayListFromDB.add(cityName);
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	public ArrayList<String> getMapsOT (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinMapsOT -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("OTMaps");
		while (ansus.next()) {
			int mapID = ansus.getInt("mapID");
			String mapName = ansus.getString("mapName");
			String mapDescription = ansus.getString("description");
			double mapVersion = ansus.getDouble("version");
			String mapPath = ansus.getString("mapPath");
			double price = ansus.getDouble("purchasePrice");
			
			ArrayListFromDB.add(Integer.toString(mapID));
			ArrayListFromDB.add(mapName);
			ArrayListFromDB.add(mapDescription);
			ArrayListFromDB.add(Double.toString(mapVersion));
			ArrayListFromDB.add(mapPath);
			ArrayListFromDB.add((Double.toString(price)));
		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getMapsF (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinMapsF -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("FMaps");
		while (ansus.next()) {
			int mapID = ansus.getInt("mapID");
			String mapName = ansus.getString("mapName");
			String mapDescription = ansus.getString("description");
			double mapVersion = ansus.getDouble("version");
			String mapPath = ansus.getString("mapPath");
			String till = ansus.getString("expireDate");
			double price = ansus.getDouble("purchasePrice");

			ArrayListFromDB.add(Integer.toString(mapID));
			ArrayListFromDB.add(mapName);
			ArrayListFromDB.add(mapDescription);
			ArrayListFromDB.add(Double.toString(mapVersion));
			ArrayListFromDB.add(mapPath);
			ArrayListFromDB.add(till);
			ArrayListFromDB.add((Double.toString(price)));
		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
} // end class ConnectionDB