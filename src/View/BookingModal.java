package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Christian on 23-03-2017.
 */

/*
    Name: Christian Hvidkjær
    Date: 23-03-2017
    Class: Dat16v2
    Book Excersise: ***
    Handin-Excersise Titel: ***
    Handin-Excersise: BookingModal
    Question:
    ***
*/

public class BookingModal
{
    private String[] output = new String[3];
    private Stage window = new Stage();
    private VBox layout = new VBox(10);
    private GridPane grid = new GridPane();
    private Button closeButton = new Button("Annuller");

    public String[] display( String title, String message, String[] input)
    {
        window.setTitle( title );
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label messageLabel = new Label( message );

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label l1 = new Label("Dato:");
        Label l2 = new Label("Start Tid:");
        Label l3 = new Label("Slut Tid:");

        grid.add(l1, 0, 0);
        grid.add(l2, 0, 1);
        grid.add(l3, 0, 2);

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();

        if( input[0] != null ) {
            tf1.setText(input[0]);
            tf2.setText(input[1]);
            tf3.setText(input[2]);
        }

        grid.add(tf1, 1, 0);
        grid.add(tf2, 1, 1);
        grid.add(tf3, 1, 2);

        Button submitButton = new Button(title);

        submitButton.setOnAction(e -> {
            output[0] = tf1.getText().trim();
            output[1] = tf2.getText().trim();
            output[2] = tf3.getText().trim();

            window.close();
        });

        closeButton.setOnAction(
                e-> window.close()
        );

        HBox bottom = new HBox(10, submitButton, closeButton);

        layout.getChildren().addAll(messageLabel, grid, bottom);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return output;
    }
}
