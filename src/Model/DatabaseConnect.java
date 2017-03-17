package Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
    private static String db_url;
    private static String db_port;
    private static String db_name;
    private static String db_user;
    private static String db_password;
    private static Statement connection;

    private DatabaseConnect() {
        db_url = "jdbc:mysql://localhost";
        db_port = "8888";
        db_name = "adventureXP";
        db_user = "root";
        db_password = "root";
        connection = setConnection();
    }

    private static Statement setConnection() {
        try {
            String url = "" + db_url + ":" + db_port + "/" + db_name + "";
            java.sql.Connection conn = DriverManager.getConnection( url, db_user, db_password );

            Statement state = conn.createStatement();
            return state;
        } catch ( SQLException ex ) {}
        return null;
    }

    private static class DatabaseConnectManagerHolder {
        private final static DatabaseConnect instance = new DatabaseConnect();
    }

    public static DatabaseConnect getInstance() {
        try {
            return DatabaseConnectManagerHolder.instance;
        } catch ( ExceptionInInitializerError ex ) {}
        return null;
    }

    public static Statement getStatement() {
        return connection;
    }
}
