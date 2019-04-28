//package db;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import models.User;
//
//
//public class UserDAO {
//	
//	
//    public List<User> getAll() throws SQLException {
//        List<User> users = new ArrayList<>();
//        try (Connection conn = Database.getInstance().getConnection()) {
//            PreparedStatement stmt = conn.prepareStatement(ConstantsQueries.USERS.SELECT_ALL);
//            ResultSet resultSet = stmt.executeQuery();
//            while (resultSet.next()) {
//                users.add(new User(resultSet));
//            }
//        }
//        return users;
//    }
//
//    public User getById(String id) throws SQLException {
//        try (Connection conn = Database.getInstance().getConnection()) {
//            PreparedStatement stmt = conn.prepareStatement(ConstantsQueries.USERS.SELECT_BY_ID);
//            stmt.setString(1, id);
//            ResultSet resultSet = stmt.executeQuery();
//            if (resultSet.next()) {
//                return new User(resultSet);
//            }
//        }
//        return null;
//    }
//
//}
