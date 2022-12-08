package app;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class Database {
    static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7583537";
    static final String USER = "sql7583537";
    static final String PASS = "SdFXfJAB2n";


    /**
     * createDatabase make a connection and create 2 tables : User and Profile, then close the connection
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void createDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Open a connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();

        String sql_user = "CREATE TABLE User" +
                "(user_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " user_name VARCHAR(255), " +
                " user_email VARCHAR(255), " +
                " user_passWord VARCHAR(255), " +
                " PRIMARY KEY (user_id)) ";
        stmt.executeUpdate(sql_user);
        System.out.println("Table User created");

        String sql_profile = "CREATE TABLE Profile" +
                "(profile_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " user_id INTEGER NOT NULL, " +
                " firstName VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age INTEGER, " +
                " birthDate VARCHAR(255), " +
                " pathPicture VARCHAR(255), " +
                " city VARCHAR(255), " +
                " isMale BIT, " +
                " description VARCHAR(1000), " +
                " PRIMARY KEY (profile_id), " +
                " FOREIGN KEY (user_id) references User(user_id))"
                ;
        stmt.executeUpdate(sql_profile);
        System.out.println("Table Profile created");
        conn.close();
    }//connectToDatabase()

    /**
     * fillUser add a user in the Database table User
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void fillUser(int pUserId, String pUserName, String pEmail, String pPassWord) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sqlLine = "INSERT INTO User values ("+pUserId+",'"+pUserName+"','"+pEmail+"','"+pPassWord+"')";
        stmt.executeUpdate(sqlLine);
        conn.close();
    }//fillUser


    /**
     * fillProfile add a profile in the Database table Profile
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void fillProfile(int pUserId, String pFirstName, String pLastName, int pAge, String pBirthDate, String pPathPicture,
                                   String pCity, Boolean pIsMale, String pDescription) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sqlLine = "INSERT INTO Profile(user_id, firstName, lastName, age, birthDate, pathPicture, city, isMale, description)" +
                " values ("+pUserId+",'"+pFirstName+"','"+pLastName+"',"+pAge+",'"+pBirthDate+"','"+pPathPicture+
                "','"+pCity+"',"+pIsMale+",'"+pDescription+"')";
        stmt.executeUpdate(sqlLine);
        conn.close();
    }//fillUser

    public static HashSet getUserEmail() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String getUserEmail = "SELECT user_email FROM User";
        ResultSet rs = stmt.executeQuery(getUserEmail);
        HashSet Emails = new HashSet<String>();
        while(rs.next()){
            Emails.add(rs.getString("user_email"));
        }
        conn.close();
        return Emails;

    }
}//Database
