import Model.DatabaseConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnect single = DatabaseConnect.getInstance();
        Statement state = DatabaseConnect.getStatement();

        try {
            ResultSet result = state.executeQuery( "SELECT equ_id FROM equipment" );

            while (result.next()) {
                System.out.println( result.getInt( 0 ) );
            }
        } catch ( SQLException ex ) {}
    }
}
