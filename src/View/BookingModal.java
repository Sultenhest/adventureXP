package View;

import Model.Activity;
import Model.ActivityModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    private ObservableList<String> activities;

    private ComboBox<String> createComboBox(){
        ComboBox<String> comboBox = new ComboBox<>();

        activities = FXCollections.observableArrayList();

        for (Object o : ActivityModel.getInstance().readAll()) {
            if ( o instanceof Activity ) {
                activities.add( ((Activity) o).getID() + ": " + ((Activity) o).getActivityName() );
            }
        }

        comboBox.setItems( activities );

        comboBox.getSelectionModel().selectFirst();

        return comboBox;
    }

    public String[] display( String title, String message )
    {
        window.setTitle( title );
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        window.setHeight(350);

        Label messageLabel = new Label( message );

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label activityLabel = new Label("Aktivitet:");
        Label instructorLabel = new Label("Instruktør:");
        Label customerLabel = new Label("Kunde:");
        Label startDateLabel = new Label("Dato:");
        Label startTimeLabel = new Label("Tidspunkt:");
        Label durationLabel = new Label("Varighed:");
        Label participantsLabel = new Label("Antal Deltagere:");

        grid.add(activityLabel, 0, 0);
        grid.add(instructorLabel, 0, 1);
        grid.add(customerLabel, 0, 2);
        grid.add(startDateLabel, 0, 3);
        grid.add(startTimeLabel, 0, 4);
        grid.add(durationLabel, 0, 5);
        grid.add(participantsLabel, 0, 6);

        //Activity field
        TextField instructorField = new TextField();
        TextField clientField = new TextField();
        DatePicker date = new DatePicker();
        TextField startTimeField = new TextField();
        TextField durationField = new TextField();
        TextField participantsField = new TextField();

        grid.add(createComboBox(), 1, 0);
        grid.add(instructorField, 1, 1);
        grid.add(clientField, 1, 2);
        grid.add(date, 1, 3);
        grid.add(startTimeField, 1, 4);
        grid.add(durationField, 1, 5);
        grid.add(participantsField, 1, 6);

        Button submitButton = new Button(title);

        submitButton.setOnAction(e -> {
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
