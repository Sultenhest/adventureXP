package View;

import Model.Finals;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public abstract class BaseScene
{
    private int ID;
    private Scene scene;

    public Scene getScene()
    {
        return scene;
    }

    public void setScene( Pane pane )
    {
        Finals finals = Finals.getInstance();

        BorderPane borderPane = new BorderPane();

        borderPane.setTop( generateHeader() );
        borderPane.setCenter( pane );

        scene = new Scene( borderPane, finals.getMinWindowWitdh(), finals.getMinWindowHeight() );

        scene.getStylesheets().add("file:Assets/Stylesheet.css");
    }

    private HBox generateHeader(){
        HBox header = new HBox();

        ImageView imv = new ImageView();

        imv.setImage( new Image("file:Assets/Logo.png", true) );
        Button activityButton = new Button("Activities");
        Button bookingButton = new Button("Bookings");

        header.getChildren().addAll(imv, activityButton, bookingButton);

        header.getStyleClass().add("menu");

        return header;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getID()
    {
        return ID;
    }
}