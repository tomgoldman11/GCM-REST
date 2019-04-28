package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jdk.nashorn.internal.objects.annotations.Where;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.net.ssl.SSLException;

public class Database {
    private static Database instance;
    static private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static private final String DB = "c4EgFjQoFL";
    private static final String URL ="jdbc:mysql://remotemysql.com/" + DB + "?useSSL=false";
    private static final String USER = "c4EgFjQoFL";
    private static final String PASSWORD = "lcOQ5ludsS";

    private Database() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.exit(0);
        }
    }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}