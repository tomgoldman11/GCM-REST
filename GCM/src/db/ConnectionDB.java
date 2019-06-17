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

/**
 *
 */
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
    public String MaxRequestID = "";
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
	 
	 public void insertRequest(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewRequest -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	
	public void insertCityRequest(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewCityRequest -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 } 
	public void insertCreditCard(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewCreditCard -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 } 
	 
	 
	public void insertMapRequest(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingNewMapRequest -----");
			PreparedStatement update = conn.prepareStatement(msg.toString().substring(1));
			update.executeUpdate();
			update.close();
			return;
	 }
	public void insertCity(Object msg) throws SSLException, SQLException {
		 System.out.println("----- InsertingCity -----");
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
	 
	 public String getMaxRequestID (Object msg) throws SSLException, SQLException { 
		 System.out.println("----- GettingnMaxRequestID -----");
		 ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		 while (ansus.next()) {     	
			 MaxRequestID = ansus.getString(1);
		 }	
		 System.out.println("THIS IS MAXREQUESTID : " + MaxRequestID );
	     close();
	     return MaxRequestID;
	 }
	 
	 public String getMaxCreditCardID (Object msg) throws SSLException, SQLException { 
		 System.out.println("----- GettingnMaxCreditCardID -----");
		 ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		 while (ansus.next()) {     	
			 MaxRequestID = ansus.getString(1);
		 }	
		 System.out.println("THIS IS MaxCreditCardID : " + MaxRequestID );
	     close();
	     return MaxRequestID;
	 }
	 
	 
	 public void updateCustomerCardCustomerUserCity(Object msg) throws SSLException, SQLException {
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
	
	
	
	public ArrayList<String> getCitiesUpdate (Object msg) throws SSLException, SQLException {
		System.out.println("----- GettingCitiesUpdate -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		ArrayListFromDB.add("getcitiesupdate");
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
	
	public ArrayList<String> getRequests (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinRequests -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("Requests");  
		while (ansus.next()) {
			int requestID = ansus.getInt("requestID");
			String requestDescription = ansus.getString("requestDescription");
			String employeeName = ansus.getString("employeeName");
			String requestDate = ansus.getString("requestDate");

			
			ArrayListFromDB.add(Integer.toString(requestID));
			ArrayListFromDB.add(requestDescription);
			ArrayListFromDB.add(employeeName);
			ArrayListFromDB.add(requestDate);		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	

	public ArrayList<String> getMaps (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinMaps -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("Maps");  
		while (ansus.next()) {
			int mapID = ansus.getInt("mapID");
			String mapName = ansus.getString("mapName");
			String mapDescription = ansus.getString("description");
			double mapVersion = ansus.getDouble("version");	
			
			ArrayListFromDB.add(Integer.toString(mapID));
			ArrayListFromDB.add(mapName);
			ArrayListFromDB.add(mapDescription);
			ArrayListFromDB.add(Double.toString(mapVersion));
		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getMaps2 (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinMaps2 -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("Maps2");  
		while (ansus.next()) {
			int mapID = ansus.getInt("mapID");
			String mapName = ansus.getString("mapName");
			String mapDescription = ansus.getString("description");
			double mapVersion = ansus.getDouble("version");	
			
			ArrayListFromDB.add(Integer.toString(mapID));
			ArrayListFromDB.add(mapName);
			ArrayListFromDB.add(mapDescription);
			ArrayListFromDB.add(Double.toString(mapVersion));
		
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
	
	public ArrayList<String> getEmployees (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinEmployees -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getEmployees");
		while (ansus.next()) {
			String userID = ansus.getString("userID");
			int employeeID = ansus.getInt("employeeID");
			int roleID = ansus.getInt("roleID");
			String jobTitle = ansus.getString("jobTitle");
			String fullName = ansus.getString("fullName");
			String email = ansus.getString("email");
			String phone = ansus.getString("phone");

			ArrayListFromDB.add(userID);
			ArrayListFromDB.add(Integer.toString(employeeID));
			ArrayListFromDB.add(Integer.toString(roleID));
			ArrayListFromDB.add(jobTitle);
			ArrayListFromDB.add(fullName);
			ArrayListFromDB.add(email);
			ArrayListFromDB.add(phone);
		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getLocationsForMap (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinLocationsForMap -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getLocationsForMap");
		while (ansus.next()) {
			int locationID = ansus.getInt("locationID");
			String locationName = ansus.getString("locationName");
			String classification = ansus.getString("classification");
			String description = ansus.getString("description");
			boolean accessibility = ansus.getBoolean("accessibility");

			ArrayListFromDB.add(Integer.toString(locationID));
			ArrayListFromDB.add(locationName);
			ArrayListFromDB.add(classification);
			ArrayListFromDB.add(description);
			ArrayListFromDB.add(Boolean.toString(accessibility));
		
		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getToursForMap (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinToursForMap -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getToursForMap");
		while (ansus.next()) {
			int tourID = ansus.getInt("tourID");
			String description = ansus.getString("description");
			String visitDuration = ansus.getString("visitDuration");
			String locationsID = ansus.getString("locationsID");
		
			ArrayListFromDB.add(Integer.toString(tourID));
			ArrayListFromDB.add(description);
			ArrayListFromDB.add(visitDuration);
			ArrayListFromDB.add(locationsID);
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getLocations (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinLocations -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getLocations");
		while (ansus.next()) {
			int locationID = ansus.getInt("locationID");
			String locationName = ansus.getString("locationName");
			String classification = ansus.getString("classification");
			String description = ansus.getString("description");
			boolean accessibility = ansus.getBoolean("accessibility");

			ArrayListFromDB.add(Integer.toString(locationID));
			ArrayListFromDB.add(locationName);
			ArrayListFromDB.add(classification);
			ArrayListFromDB.add(description);
			ArrayListFromDB.add(Boolean.toString(accessibility));
		
		
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getTours (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinTours -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getTours");
		while (ansus.next()) {
			int tourID = ansus.getInt("tourID");
			String description = ansus.getString("description");
			String visitDuration = ansus.getString("visitDuration");
			String locationsID = ansus.getString("locationsID");
		
			ArrayListFromDB.add(Integer.toString(tourID));
			ArrayListFromDB.add(description);
			ArrayListFromDB.add(visitDuration);
			ArrayListFromDB.add(locationsID);
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public ArrayList<String> getF_SubStats (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinF_substats -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getFsubstats");
		while (ansus.next()) {
			int cityID = ansus.getInt("cityID");
			String cityName = ansus.getString("cityName");
			int numOfPurchases = ansus.getInt("countF");
		
			ArrayListFromDB.add(Integer.toString(cityID));
			ArrayListFromDB.add(cityName);
			ArrayListFromDB.add(Integer.toString(numOfPurchases));
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	} 
	
	public ArrayList<String> getOT_SubStats (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinOT_substats -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("getOTsubstats");
		while (ansus.next()) {
			int cityID = ansus.getInt("cityID");
			String cityName = ansus.getString("cityName");
			int numOfPurchases = ansus.getInt("countF");
		
			ArrayListFromDB.add(Integer.toString(cityID));
			ArrayListFromDB.add(cityName);
			ArrayListFromDB.add(Integer.toString(numOfPurchases));
		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public String getCityRequest(Object msg) throws SSLException, SQLException { 	
		System.out.println("----- GetCityRequestDetails -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		while (ansus.next()) {
			String cityID = ansus.getString("cityID");
			String description = ansus.getString("description");
			String mapClusterVersion = ansus.getString("mapsClusterVersion");
			String numberMaps = ansus.getString("numMaps");
			String numberTours = ansus.getString("numTours");
			String numberLocations = ansus.getString("numLocations");
			String mapClusterPrice = ansus.getString("mapsClusterPrice");
			String cityName = ansus.getString("cityName");
			ansUser = cityID + "!" + description + "!" + mapClusterVersion + "!" + numberMaps + "!" 
			+ numberTours + "!" + numberLocations + "!" + mapClusterPrice + "!" + cityName ; // add registerDATE HERE
		}
		return ansUser;
	}
	

	public String getCreditCardCustomer(Object msg) throws SSLException, SQLException { 	
		System.out.println("----- GetCreditCardCustomer -----");
		ansUser = "42";
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		while (ansus.next()) {
			String cardType = ansus.getString("cardType");
			String cardNumber = ansus.getString("cardNumber");
			String expireDate = ansus.getString("expireDate");
			int cvv = ansus.getInt("cvv");
			String address = ansus.getString("Address");
			String fullName = ansus.getString("fullName");
			ansUser = cardType + "!" + cardNumber + "!" + expireDate + "!" + cvv + "!" 
			+ address + "!" + fullName  ; // add registerDATE HERE
		}
		return ansUser;
	}
	
	public ArrayList<String> getCDforCustomerDetails (Object msg) throws SSLException, SQLException {
		 System.out.println("----- GettinCDforCustomerDeatails -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1)); 
		ArrayListFromDB.add("CDforCustomerDatils");  
		while (ansus.next()) {
			String userID = ansus.getString("userID");
			int cusID = ansus.getInt("cusID");
			int purchases = ansus.getInt("purchases");
			String customerName = ansus.getString("customerName");
			int age = ansus.getInt("age");
			String phone = ansus.getString("phone");
			String email = ansus.getString("email");
			
			ArrayListFromDB.add(userID);
			ArrayListFromDB.add(Integer.toString(cusID));
			ArrayListFromDB.add(Integer.toString(purchases));
			ArrayListFromDB.add(customerName);
			ArrayListFromDB.add(Integer.toString(age));
			ArrayListFromDB.add(phone);
			ArrayListFromDB.add(email);

		}
		ArrayList<String> copyArrayList = new ArrayList<String>(ArrayListFromDB);
		ArrayListFromDB.clear();
		return copyArrayList;
	}
	
	public String getMapRequest(Object msg) throws SSLException, SQLException { 	
		System.out.println("----- GetMapRequestDetails -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		while (ansus.next()) {
			String mapID = ansus.getString("mapID");
			String cityID = ansus.getString("cityID");
			String mapName = ansus.getString("mapName");
			String description = ansus.getString("description");
			String version = ansus.getString("version");
			String mapPath = ansus.getString("mapPath");
			ansUser = mapID + "!"  + cityID + "!" + mapName + "!" + description + "!" + version + "!" + mapPath ; // add registerDATE HERE
		}
		return ansUser;
	}
	
	public String getLocationRequest(Object msg) throws SSLException, SQLException { 	
		System.out.println("----- GetLocationRequestDetails -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		while (ansus.next()) {
			String locationID = ansus.getString("locationID");
			String locationName = ansus.getString("locationName");
			String classification = ansus.getString("classification");
			String description = ansus.getString("description");
			String accessibility = ansus.getString("accessibility");
			ansUser = locationID + "!"  + locationName + "!" + classification + "!" + description 
					+ "!" + description + "!" + accessibility ; // add registerDATE HERE
		}
		return ansUser;
	}
	public String getTourRequest(Object msg) throws SSLException, SQLException { 	
		System.out.println("----- GetTourRequestDetails -----");
		ResultSet ansus = stmt.executeQuery(msg.toString().substring(1));
		while (ansus.next()) {
			String tourID = ansus.getString("tourID");
			String description = ansus.getString("description");
			String visitDuration = ansus.getString("visitDuration");
			String locationsID = ansus.getString("locationsID");
			String cityID = ansus.getString("cityID");

			ansUser = tourID + "!"  + description + "!" + visitDuration + "!" +  cityID  + "!" +locationsID; // add registerDATE HERE
		}
		return ansUser;
	}
	
	
	
	
	
} // end class ConnectionDB