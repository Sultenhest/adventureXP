package View;

import Controller.SceneHandler;
import Model.Finals;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public abstract class BaseScene
{
    private int ID;
    private Scene scene;
    private String[] title = { "Aktiviteter", "Bookings" };

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
        HBox buttonContainer = new HBox(10);
        VBox subStructure = new VBox();

        Label headerText = new Label( title[ getID() ] );

        ImageView imv = new ImageView();

        imv.setImage( new Image("file:Assets/Logo.png", true) );
        Button activityButton = new Button( "Aktiviteter" );
        Button bookingButton = new Button( "Bookings" );

        activityButton.setOnAction( e -> {
            SceneHandler.getInstance().applyScene(0);
        } );

        bookingButton.setOnAction( e -> {
            SceneHandler.getInstance().applyScene(1);
        } );

        buttonContainer.getChildren().addAll( activityButton, bookingButton );
        subStructure.getChildren().addAll( buttonContainer, headerText );
        header.getChildren().addAll(imv, subStructure);

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