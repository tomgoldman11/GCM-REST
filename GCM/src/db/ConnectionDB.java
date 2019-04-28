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
    static public String ansUser;
    public String Connect2db(Object msg) throws SSLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            System.out.println("\t============");
            
            

            /* exercize a */
            
            System.out.println("----------------------" + msg.toString());
            
            ResultSet ansus = stmt.executeQuery(msg.toString());
            while (ansus.next()) {
            	String userID = ansus.getString("userID");
            	String password = ansus.getString("password");
            	String registerDate = ansus.getString("registerDate");
            	System.out.format("userID: %s password: %s registerDate: %s\n",userID,password,registerDate);
            	ansUser = userID + " " + password + " ";
            }
            

//            /* exercize b */
//            
//            sql = "SELECT price " + "FROM flights " + "WHERE num=387";
//            ResultSet ans = stmt.executeQuery(sql);
//            ans.next();
//            System.out.println("new price is: " + ans.getInt("price"));
//
//
//            /* exercize c */
//            
//            Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//            sql = "SELECT * " + "FROM flights " + "WHERE distance>1000";
//            ResultSet ans2 = stmt2.executeQuery(sql);
//            while (ans2.next()){
//                ans2.updateFloat("price", ans2.getFloat("price")+50);
//                ans2.updateRow(); // update the change in the database.
//            }
//            ans2.close();
//            stmt2.close();
//
//            /* exercize d */
//            
//            PreparedStatement updateSales = conn.prepareStatement("UPDATE flights "+ " SET price = price + 50 WHERE distance > ? ");
//                updateSales.setInt(1, 1000); 
//                updateSales.executeUpdate(); // run the query only on flights which their distance is bigger than 1000.
//
//
//            sql = "SELECT * FROM flights";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) { // printing row by row of the database.
//                int num = rs.getInt("num");
//                String origin = rs.getString("origin");
//                String destination = rs.getString("destination");
//                int distance = rs.getInt("distance");
//                int price = rs.getInt("price");
//
//                System.out.format("Number %5s Origin %15s destinations %18s Distance %5d Price %5d\n", num, origin, destination, distance, price);
//            }
//
//            System.out.println("\t============");
//
//            sql = "SELECT origin, destination, distance, num FROM flights";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                String origin = rs.getString("origin");
//                String destination = rs.getString("destination");
//                int distance = rs.getInt("distance");
//
//                System.out.print("From: " + origin);
//                System.out.print(",\tTo: " + destination);
//                System.out.println(",\t\tDistance: " + distance);
//            }
//
//            System.out.println("\t============");
//
//            sql = "SELECT origin, destination FROM flights WHERE distance > ?";
//            PreparedStatement prep_stmt = conn.prepareStatement(sql);
//            prep_stmt.setInt(1, 200);
//            rs = prep_stmt.executeQuery();
//            while (rs.next()) {
//                String origin = rs.getString("origin");
//                System.out.println("From: " + origin);
//            }

//            rs.close();
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
        return ansUser;
    }
}