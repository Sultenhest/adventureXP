package View;

import Model.Activity;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Christian on 16-03-2017.
 */

/*
    Name: Christian Hvidkjær
    Date: 16-03-2017
    Class: Dat16v2
    Book Excersise: ***
    Handin-Excersise Titel: ***
    Handin-Excersise: View.ActivityView
    Question:
    ***
*/

public class ActivityView extends BaseScene implements BaseLayout
{
    private VBox layout;
    private GridPane subLayout;
    private TextField activityNameField;
    private TextField ageLimitField;
    private TextField heightLimitField;
    private TextField acitivityInfoField;

    private Button createActivity;
    private Button deleteActivity;
    private Button updateActivity;

    private TableView<Activity> activityTableView;

    public ActivityView()
    {
        createLayout();
        createTableColoumns();
        createLayoutSettings();
        attachLayoutToScene();
    }

    // Creates the layout of the Activity View
    @Override
    public void createLayout()
    {
        // Main layout for View (not really needed since VBox isn't used for anything)
        layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        // Layout for Elements of ActivityView
        subLayout = new GridPane();
        subLayout.setAlignment(Pos.CENTER);

        // TableView for showing the list of activities
        activityTableView = new TableView<>();

        // TextFields for keying in info on new activity that'll be sent to the DB
        activityNameField = new TextField();
        ageLimitField = new TextField();
        heightLimitField = new TextField();
        acitivityInfoField = new TextField();

        // Buttons adding, updating and deleting activities
        createActivity = new Button();
        updateActivity = new Button();
        deleteActivity = new Button();

        // Adds elements to the GridPane
        subLayout.add(activityTableView, 0 , 0, 3, 1);
        subLayout.add(activityNameField, 0 , 1);
        subLayout.add(acitivityInfoField, 0 , 2);
        subLayout.add(ageLimitField, 1 , 1);
        subLayout.add(heightLimitField, 1 , 2);

        subLayout.add(createActivity, 2, 1);
        subLayout.add(updateActivity, 2, 2);
        subLayout.add(deleteActivity, 2, 3);

        // Adds GridPane to VBox
        layout.getChildren().add(subLayout);
    }

    public void createTableColoumns()
    {
        TableColumn<Activity, Integer> activityID = new TableColumn<>("ID");
        activityID.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ID"));
        activityID.setMaxWidth(35);

        TableColumn<Activity, Integer> ageLimit = new TableColumn<>("AgeLimit");
        ageLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ageLimit"));
        ageLimit.setMinWidth(25);

        TableColumn<Activity, Integer> heightLimit = new TableColumn<>("heightLimit");
        heightLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("heightLimit"));
        heightLimit.setMinWidth(25);

        TableColumn<Activity, String> activityName = new TableColumn<>("activityName");
        activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityName"));
        activityName.setMinWidth(25);

        TableColumn<Activity, String> activityInfo = new TableColumn<>("activityInfo");
        activityInfo.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityInfo"));
        activityInfo.setMinWidth(25);

        activityTableView.getColumns().addAll(activityID, ageLimit, heightLimit, activityName, activityInfo);
        activityTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @Override
    public void createLayoutSettings()
    {
//        String style = getClass().getResource("/View/StyleSheet.css").toExternalForm();

        activityNameField.setPromptText("Aktivitet Navn...");
        ageLimitField.setPromptText("Aldersbegrænsning...");
        heightLimitField.setPromptText("Minimum Højde...");
        acitivityInfoField.setPromptText("Aktivitet Info...");

        createActivity.setText("Skab ny Aktivitet");
        createActivity.setStyle("-fx-background-color:\n" + "" +
                "            linear-gradient(#ffd65b, #000000),\n" + "" +
                "            linear-gradient(#ffef84, #000000),\n" + "" +
                "            linear-gradient(#ffea6a, #000000),\n" + "" +
                "            linear-gradient(#ffe657 0%, #f8c202 50%, #000000 100%),\n" + "" +
                "            linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");
        updateActivity.setText("Opdatere Aktiviter");
        updateActivity.setStyle("-fx-background-color:\n" + "" +
                "            linear-gradient(#ffd65b, #000000),\n" + "" +
                "            linear-gradient(#ffef84, #000000),\n" + "" +
                "            linear-gradient(#ffea6a, #000000),\n" + "" +
                "            linear-gradient(#ffe657 0%, #f8c202 50%, #000000 100%),\n" + "" +
                "            linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");
        deleteActivity.setText("Slet Aktiviter");
        deleteActivity.setStyle("-fx-background-color:\n" + "" +
                "            linear-gradient(#ffd65b, #000000),\n" + "" +
                "            linear-gradient(#ffef84, #000000),\n" + "" +
                "            linear-gradient(#ffea6a, #000000),\n" + "" +
                "            linear-gradient(#ffe657 0%, #f8c202 50%, #000000 100%),\n" + "" +
                "            linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");

        subLayout.setHgap(25);
        subLayout.setVgap(25);
    }

    @Override
    public Pane getLayout()
    {
        return this.layout;
    }

    @Override
    public void attachLayoutToScene()
    {
        setScene(this.layout);
    }
}
