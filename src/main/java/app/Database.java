package app;

import java.sql.*;



public class Database {
    static final String DB_URL = "";
    static final String USER = "";
    static final String PASS = "";


    /**
     * createDatabase make a connection and create 2 tables : User and Profile, then close the connection
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void createDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Open a connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt =  conn.createStatement();

        String sql_user ="CREATE TABLE User " +
                "( user_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " user_name VARCHAR(255), " +
                " user_email VARCHAR(255), " +
                " user_passWord VARCHAR(255), " +
                " PRIMARY KEY (user_id)) ";
        stmt.executeUpdate(sql_user);
        System.out.println("Table User created");

        String sql_profile ="CREATE TABLE Profile " +
                "( profile_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " user_id INTEGER NOT NULL, " +
                " profile_firstName VARCHAR(255), " +
                " profile_lastName VARCHAR(255), " +
                " profile_age INTEGER, " +
                " profile_birthDate VARCHAR(255), " +
                " profile_pathPicture VARCHAR(255), " +
                " profile_city VARCHAR(255), " +
                " profile_isMale BIT, " +
                " profile_description VARCHAR(1000), " +
                " PRIMARY KEY (user_id)) ";
        stmt.executeUpdate(sql_profile);
        System.out.println("Table Profile created");

    }//connectToDatabase()
}//Database
