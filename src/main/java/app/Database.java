package app;

import java.sql.*;
import java.util.HashSet;

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
                " username VARCHAR(255), " +
                " email VARCHAR(255), " +
                " password VARCHAR(255), " +
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
    /**
     * @retrun false if the mail is not valid (already exist in database) and true otherwise
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static boolean isEmailValid(String pEmail) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String getUserEmails = "SELECT email FROM User";
        ResultSet rs = stmt.executeQuery(getUserEmails);
        while(rs.next()){
            if(rs.getString("email").equals(pEmail)) {
                return false;
            }
        }
        conn.close();
        return true;
    }

    public static boolean isUserValid(String pUsername, String pPassword) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql = "SELECT count(*) FROM User where username = '"+pUsername+"' and password = '"+pPassword+"'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        if (rs.getInt("count(*)")==1) return true;
        return false;
    }
    public static void updateUser(Profile pProfile) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql = "UPDATE Profile" +
                "SET firstName = '"+pProfile.getFirstName()+"'," +
                "SET lastName = '"+pProfile.getLastName()+"'," +
                "SET age = "+pProfile.getAge()+"," +
                "SET birthDate = '"+pProfile.getBirthDate()+"'," +
                "SET pathPicture = '"+pProfile.getPicture()+"'," +
                "SET city = '"+pProfile.getCity()+"'," +
                "SET isMale = "+pProfile.isMale()+"," +
                "SET description = '"+pProfile.getDescription()+"'" +
                "Where profile_id = "+pProfile.getId();
        stmt.execute(sql);
    }
}//Database
