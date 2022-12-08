package app;

import java.sql.*;



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

        String sql_user = "CREATE TABLE User_table " +
                "( user_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " user_name VARCHAR(255), " +
                " user_email VARCHAR(255), " +
                " user_passWord VARCHAR(255), " +
                " PRIMARY KEY (user_id)) ";
        stmt.executeUpdate(sql_user);
        System.out.println("Table User created");

        String sql_profile = "CREATE TABLE Profile_table " +
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
                " PRIMARY KEY (profile_id)) " +
                " FOREIGN KEY (user_id) REFERENCES User_table(user_id))";
        stmt.executeUpdate(sql_profile);
        System.out.println("Table Profile created");
    }//connectToDatabase()

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void fillUser() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();

        String sqlLine = "INSERT INTO User VALUES ()";
        stmt.executeUpdate(sqlLine);
    }//Database


}//Database
