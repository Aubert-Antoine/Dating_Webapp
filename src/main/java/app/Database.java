package app;

import java.sql.*;
import java.util.Stack;
import java.util.Date;

public class Database {
    static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7586380";
    static final String USER = "sql7586380";
    static final String PASS = "sUxm8dx6bQ";


    /**
     * createDatabase make a connection and create 2 tables : User and Profile, then close the connection
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void createDatabase() throws SQLException, ClassNotFoundException {
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
                " isMale BOOLEAN, " +
                " description VARCHAR(1000), " +
                " PRIMARY KEY (profile_id), " +
                " FOREIGN KEY (user_id) references User(user_id))"
                ;
        stmt.executeUpdate(sql_profile);
        System.out.println("Table Profile created");

        String sql_MatchInProgress = "CREATE TABLE MIP" +
                "(MIP_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " men_id INTEGER NOT NULL, " +
                " women_id INTEGER NOT NULL, " +
                " menIsOk BOOLEAN, " +
                " womenIsOk BOOLEAN, " +
                " PRIMARY KEY (MIP_id), " +
                " FOREIGN KEY (Men_id) references Profile(Profile_id),"+
                " FOREIGN KEY (Women_id) references Profile(Profile_id))"
                ;
        stmt.executeUpdate(sql_MatchInProgress);
        System.out.println("Table Match In Progress (MIP) created");

        String sql_Matchs = "CREATE TABLE Matchs" +
                "(Matchs_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " men_id INTEGER NOT NULL, " +
                " women_id INTEGER NOT NULL, " +
                " matchDate VARCHAR(255), " +
                " PRIMARY KEY (Matchs_id), " +
                " FOREIGN KEY (Men_id) references Profile(Profile_id),"+
                " FOREIGN KEY (Women_id) references Profile(Profile_id))"
                ;
        stmt.executeUpdate(sql_Matchs);
        System.out.println("Table Match created");

        String sql_NoMatch = "CREATE TABLE NoMatch" +
                "(NoMatch_id INTEGER NOT NULL AUTO_INCREMENT, " +
                " men_id INTEGER NOT NULL, " +
                " women_id INTEGER NOT NULL, " +
                " noMatchDate VARCHAR(255), " +
                " PRIMARY KEY (NoMatch_id), " +
                " FOREIGN KEY (Men_id) references Profile(Profile_id),"+
                " FOREIGN KEY (Women_id) references Profile(Profile_id))"
                ;
        stmt.executeUpdate(sql_NoMatch);
        System.out.println("Table noMatch created");
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
        String sql_fillUser = "INSERT INTO User values ("+pUserId+",'"+pUserName+"','"+pEmail+"','"+pPassWord+"')";
        stmt.executeUpdate(sql_fillUser);
        conn.close();
    }//fillUser

    public static boolean deleteUser(String pEmail, String pPassword) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql_getUserId = "SELECT values (user_id) FROM User where email = '"+pEmail+"' and password = '"+pPassword+"'";
        ResultSet rs = stmt.executeQuery(sql_getUserId);
        if (!rs.next()) return false;
        int userId = rs.getInt("user_id");

        String sql_deleteInMatchs = "DELETE from Matchs where men_id = "+userId+" or women_id = "+userId;
        stmt.executeUpdate(sql_deleteInMatchs);

        String sql_deleteInMIP = "DELETE from MIP where men_id = "+userId+" or women_id = "+userId;
        stmt.executeUpdate(sql_deleteInMIP);

        String sql_deleteInProfile = "DELETE from Profile where user_id = "+userId;
        stmt.executeUpdate(sql_deleteInProfile);

        String sql_deleteInUser = "DELETE from User where user_id = "+userId;
        stmt.executeUpdate(sql_deleteInUser);
        conn.close();
        return true;
    }


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


    public static Stack getProfiles(Profile profile, int numberOfProfiles) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();

        Stack profiles = new Stack();
        String sql_userId="SELECT profile_id from Profile where isMale = "+ !profile.isMale();
        ResultSet rs = stmt.executeQuery(sql_userId);
        Stack profileId = new Stack();
        while (rs.next()){
            profileId.add("\""+rs.getInt("profile_id")+"\"");
        }
        String sql_profileIdMIP="";
        String sql_profileIdMatch="";
        String sql_profileIdNoMatch="";
        if (profile.isMale()){
            sql_profileIdMIP = "SELECT women_id from MIP where men_id = "+profile.getId()+" and menIsOk = true";
            sql_profileIdMatch = "SELECT women_id from Matchs where men_id = "+ profile.getId();
            sql_profileIdNoMatch = "SELECT women_id from NoMatch where men_id = "+ profile.getId();
        }
        if (!profile.isMale()){
            sql_profileIdMIP = "SELECT men_id from MIP where women_id = "+profile.getId()+" and womenIsOk = true";
            sql_profileIdMatch = "SELECT men_id from Matchs where women_id = "+ profile.getId();
            sql_profileIdNoMatch = "SELECT men_id from NoMatch where women_id = "+ profile.getId();
        }

        rs = stmt.executeQuery(sql_profileIdMIP);
        while (rs.next()){
            profileId.remove("\""+rs.getInt(1)+"\"");
        }
        rs = stmt.executeQuery(sql_profileIdMatch);
        while (rs.next()){
            profileId.remove("\""+rs.getInt(1)+"\"");
        }
        rs = stmt.executeQuery(sql_profileIdNoMatch);
        while (rs.next()){
            profileId.remove("\""+rs.getInt(1)+"\"");
        }
        String sql_getProfile="";
        for (int i=0;i<numberOfProfiles;i++){
            if (profileId.size()<=0) break;
            Object id =(profileId.pop());
            String sId = (String) id;
            sId = sId.split("\"")[1];
            int iId = Integer.valueOf(sId);
            sql_getProfile ="SELECT user_id,firstName,lastName,age,birthdate,pathpicture,city,isMale,description FROM Profile WHERE user_id = "+iId;
            rs = stmt.executeQuery(sql_getProfile);
            rs.next();
            profiles.add( new Profile(new User(rs.getInt("user_id")),rs.getString("firstName"),rs.getString("lastName"),
                    rs.getInt("age"), rs.getString("birthdate"),rs.getString("pathpicture"),rs.getString("city"),
                    rs.getBoolean("isMale"), rs.getString("description")));
        }
        return profiles;
    }

    public static void acceptProfile(int currentUserId, int acceptedProfileId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql_isMale ="SELECT isMale from Profile where user_id = "+currentUserId;
        ResultSet rs = stmt.executeQuery(sql_isMale);
        rs.next();
        Boolean isMale = rs.getBoolean("isMale");

        // Recuperation des infos du match en cour entre les 2 profiles
        String sql_isMIP="";
        if (isMale) sql_isMIP = "SELECT men_id,women_id,menIsOk,womenIsOk from MIP where men_id = "+currentUserId+" and women_id = "+acceptedProfileId;
        if (!isMale) sql_isMIP = "SELECT men_id,women_id,menIsOk,womenIsOk from MIP where women_id = "+currentUserId+" and men_id = "+acceptedProfileId;
        rs = stmt.executeQuery(sql_isMIP);

        // Si pas de match en cour : creation d'un nouveau MIP puis retour
        if (!rs.next()){
            String sql_newMIP = "";
            if (isMale) sql_newMIP = "INSERT into MIP(men_id,women_id,menIsOk) values("+currentUserId+","+acceptedProfileId+",true) ";
            if (!isMale) sql_newMIP = "INSERT into MIP(men_id,women_id,womenIsOk) values("+acceptedProfileId+","+currentUserId+",true) ";
            stmt.execute(sql_newMIP);
            return;
        }

        // On transfer le MIP dans la bonne table
        if(isMale && rs.getBoolean("womenIsOk")) {
            Database.addMatch(currentUserId, acceptedProfileId);
            Database.delMIP(currentUserId, acceptedProfileId);
        }
        else if(!isMale && rs.getBoolean("menIsOk")){
            Database.addMatch(acceptedProfileId,currentUserId);
            Database.delMIP(acceptedProfileId, currentUserId);
        }
    }

    public static void refuseProfile(int currentUserId, int acceptedProfileId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();

        String sql_isMale ="SELECT isMale from Profile where user_id = "+currentUserId;
        ResultSet rs = stmt.executeQuery(sql_isMale);
        rs.next();
        Boolean isMale = rs.getBoolean("isMale");

        // Recuperation des infos du match en cour entre les 2 profiles
        String sql_isMIP="";
        if (isMale) sql_isMIP = "SELECT men_id,women_id,menIsOk,womenIsOk from MIP where men_id = "+currentUserId+" and women_id = "+acceptedProfileId;
        if (!isMale) sql_isMIP = "SELECT men_id,women_id,menIsOk,womenIsOk from MIP where women_id = "+currentUserId+" and men_id = "+acceptedProfileId;
        rs = stmt.executeQuery(sql_isMIP);

        // On transfer le MIP dans la table NoMatch
        if(isMale) {
            Database.addNoMatch(currentUserId, acceptedProfileId);
            if (rs.next()) Database.delMIP(currentUserId, acceptedProfileId);
        }
        else if(!isMale){
            Database.addNoMatch(acceptedProfileId,currentUserId);
            if (rs.next()) Database.delMIP(acceptedProfileId, currentUserId);
        }
    }

    public static void addMatch(int menId,int womenId) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql_addMatch = "INSERT INTO Matchs(men_id,women_id,matchDAte) values (+"+menId+","+womenId+",'"+ new Date() +"')";
        stmt.execute(sql_addMatch);
        conn.close();
    }
    public static void addNoMatch(int menId,int womenId) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql_addNoMatch = "INSERT INTO NoMatch(men_id,women_id,noMatchDAte) values (+"+menId+","+womenId+",'"+new Date()+"')";
        stmt.execute(sql_addNoMatch);
        conn.close();
    }
    public static void delMIP(int men_id, int women_id) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(Database.DB_URL, Database.USER, Database.PASS);
        Statement stmt = conn.createStatement();
        String sql_delMIP = "DELETE from MIP where men_id = "+men_id+" and women_id ="+women_id;
        stmt.execute(sql_delMIP);
    }

}//Database
