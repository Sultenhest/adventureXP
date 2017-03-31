package View;

import Model.Activity;
import Model.ActivityModel;
import Model.Booking;
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

public class BookingModal
{
    private String[] output = new String[7];
    private Stage window = new Stage();
    private VBox layout = new VBox(10);
    private GridPane grid = new GridPane();
    private Button closeButton = new Button("Annuller");

    private ObservableList<String> activities;
    private ComboBox<String> comboBox;

    private ComboBox<String> createComboBox(){
        comboBox = new ComboBox<>();

        activities = FXCollections.observableArrayList();

        for (Activity a : ActivityModel.getInstance().readAll()) {
            activities.add( a.getID() + ": " + a.getActivityName() );
        }

        comboBox.setItems( activities );

        comboBox.getSelectionModel().selectedItemProperty().addListener(
                (v, oldValue, newValue) -> createActivityLimitsAlert( ActivityModel.getInstance().read( Integer.parseInt( newValue.substring(0, newValue.indexOf(":") ) ) ) )
        );

        return comboBox;
    }

    private void createActivityLimitsAlert( Activity a ) {
        String str  = "Aktiviteten har følgende aldersbegrænsning: min. " + a.getAgeLimit() + " år\n";
               str += "Aktiviteten har følgende højdebegrænsning:  min. " + a.getHeightLimit() + " cm";

        Alerts.doInformationBox( "Aktivitetsbegrænsninger", "Vær opmærksom på følgende vdr. " + a.getActivityName(), str );
    }

    public Booking display(String title, String message, Booking booking)
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

        if( booking != null ) {
            Alerts.doInformationBox("Aktivitet", "Valg af aktivitet", "Grundet dårlig programmering, skal du vælge den samme eller en ny aktivitet igen. Sorry senpai :(");

            instructorField.setText( booking.getInstructor() );
            clientField.setText( booking.getCustomerName() );
            date.setValue( booking.getDate() );
            startTimeField.setText( booking.getStartTime() );
            durationField.setText( booking.getEndTime() );
            participantsField.setText( "" + booking.getAmountOfParticipants() );
        }

        grid.add(createComboBox(), 1, 0);
        grid.add(instructorField, 1, 1);
        grid.add(clientField, 1, 2);
        grid.add(date, 1, 3);
        grid.add(startTimeField, 1, 4);
        grid.add(durationField, 1, 5);
        grid.add(participantsField, 1, 6);

        Button submitButton = new Button(title);

        submitButton.setOnAction(e -> {
            int actID = Integer.parseInt(comboBox.getValue().substring(0, comboBox.getValue().indexOf(":")));

            booking.setActivity( ActivityModel.getInstance().read(actID) );
            booking.setInstructor( instructorField.getText().trim() );
            booking.setCustomerName( clientField.getText().trim() );
            booking.setDate( date.getValue() );
            booking.setStartTime( startTimeField.getText().trim() );
            booking.setEndTime( durationField.getText().trim() );
            booking.setAmountOfParticipants( Integer.parseInt(participantsField.getText().trim()) );

            window.close();
        });

        closeButton.setOnAction( e-> {
            booking.setCustomerName("DONOTUPDATE");
            window.close();
        } );

        HBox bottom = new HBox(10, submitButton, closeButton);

        layout.getChildren().addAll(messageLabel, grid, bottom);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return booking;
    }
}
