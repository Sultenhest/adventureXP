package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect
{
    private static String db_url = "jdbc:mysql://localhost";
    private static String db_port = "3306";
    private static String db_name = "adventure_xp";
    private static String db_user = "root";
    private static String db_password = "root";

    public static void setDbName(String db_name)
    {
        DatabaseConnect.db_name = db_name;
    }

    public static void setUser(String db_user)
    {
        DatabaseConnect.db_user = db_user;
    }

    public static void setPass(String db_password) {
        DatabaseConnect.db_password = db_password;
    }

    public static void setPort(String db_port)
    {
        DatabaseConnect.db_port = db_port;
    }

    public static Connection getConnection()
    {
        try
        {
            String url = "" + db_url + ":" + db_port + "/" + db_name + "";

            return DriverManager.getConnection(url, db_user, db_password );
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    //
//    private DatabaseConnect()
//    {
//        db_url = "jdbc:mysql://localhost";
//        db_port = "3306";
//        db_name = "adventureXP";
//        db_user = "root";
//        db_password = "root";
//        connection = setConnection();
//    }

//    private static Statement setConnection() {
//        try {
//            String url = "" + db_url + ":" + db_port + "/" + db_name + "";
//            Connection conn = DriverManager.getConnection( url, db_user, db_password );
//
//            Statement state = conn.createStatement();
//            return state;
//        } catch ( SQLException ex ) {}
//        return null;
//    }
//
//    private static class DatabaseConnectManagerHolder {
//        private final static DatabaseConnect instance = new DatabaseConnect();
//    }
//
//    public static DatabaseConnect getInstance() {
//        try {
//            return DatabaseConnectManagerHolder.instance;
//        } catch ( ExceptionInInitializerError ex ) {}
//        return null;
//    }
//
//    public static Statement getStatement() {
//        return connection;
//    }
}
