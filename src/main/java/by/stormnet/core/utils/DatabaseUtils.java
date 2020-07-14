package by.stormnet.core.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASS = "";

    private static Connection getH2Connection(){
        Connection conn = null;
        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void dropTable(){
        System.out.println("Try to delete the Users table");
        try(Connection connection = getH2Connection(); Statement stmt = connection.createStatement(); ) {
            stmt.executeUpdate("DROP TABLE Users");
            System.out.println("Users table is deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(){
        System.out.println("Create table in given database...");
        try(Connection connection = getH2Connection(); Statement stmt = connection.createStatement();) {
            String sql = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER NOT NULL, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255), " +
                    "age INTEGER, " +
                    "PRIMARY KEY (id))";

            stmt.executeUpdate(sql);
            System.out.println("Table was created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean insertData(List<String> sqlStatement){
        try(Connection connection = getH2Connection(); Statement stmt = connection.createStatement();){
            for(String sql : sqlStatement){
                stmt.executeUpdate(sql);
//                System.out.println(sql);
            }
 //           System.out.println(stmt.executeQuery("select * from users"));
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> read(String sqlStatement){
        List<String> results = new ArrayList<>();
        try(Connection connection = getH2Connection();Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStatement);){
            while (rs.next()){
                int id = rs.getInt("id");
                System.out.println(id);
                int age = rs.getInt("age");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                results.add("ID: " + id + ", " + "First name: " + first + ", " + "Last name: " + last + ", " + "Age: " + age);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return results;
    }

    public static void updateAndDelete(String sqlStatement) {
        try(Connection connection = getH2Connection(); Statement stmt = connection.createStatement();) {
            stmt.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            System.out.println("Resources closed!");
//        }
    }

    public static void delete(String sqlStatement) {
        Connection connection = getH2Connection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Resources closed!");
        }
    }
}
