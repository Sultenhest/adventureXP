package View;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alerts {
    public static void doInformationBox( String title, String header, String message )
    {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        createContent( alert, title, header, message );

        alert.showAndWait();
    }

    public static void doErrorBox( String title, String header, String message )
    {
        Alert alert = new Alert( Alert.AlertType.ERROR );
        createContent( alert, title, header, message );

        alert.showAndWait();
    }

    public static boolean doConfirmBox( String title, String header, String message )
    {
        Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
        createContent( alert, title, header, message );

        Optional<ButtonType> result = alert.showAndWait();

        return result.get() == ButtonType.OK;
    }

    private static void createContent( Alert alert, String title, String header, String message )
    {
        alert.setTitle( title );
        alert.setHeaderText( header );
        alert.setContentText( message );
    }
}
