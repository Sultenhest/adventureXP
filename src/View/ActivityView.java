package View;

import Model.Activity;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private ImageView logo;

    public ActivityView(int ID)
    {
        setID(ID);
        createLayout();
        createTableColoumns();
        createLayoutSettings();
        attachLayoutToScene();
    }

    //
    @Override
    public void createLayout()
    {

        layout = new VBox();

        subLayout = new GridPane();

        activityNameField = new TextField();
        ageLimitField = new TextField();
        heightLimitField = new TextField();
        acitivityInfoField = new TextField();

        createActivity = new Button();
        updateActivity = new Button();
        deleteActivity = new Button();

        activityTableView = new TableView<>();

        Image image = new Image(Main_GUI.class.getResourceAsStream("LOGO.png"));

        logo = new ImageView(image);

        subLayout.add(logo, 0 , 0);
        subLayout.add(activityTableView, 1 , 0);

        subLayout.add(activityNameField, 1 , 1);
        subLayout.add(acitivityInfoField, 1 , 2);
        subLayout.add(ageLimitField, 2 , 1);
        subLayout.add(heightLimitField, 2 , 2);

        subLayout.add(createActivity, 3, 1);
        subLayout.add(updateActivity, 3, 2);
        subLayout.add(deleteActivity, 3, 3);

        layout.getChildren().add(subLayout);
    }

    public void createTableColoumns()
    {
        TableColumn<Activity, Integer> activityID = new TableColumn<>("ID");
        activityID.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ID"));
        activityID.setMinWidth(100);

        TableColumn<Activity, Integer> ageLimit = new TableColumn<>("Alders begrænsning");
        ageLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ageLimit"));
        ageLimit.setMinWidth(150);

        TableColumn<Activity, Integer> heightLimit = new TableColumn<>("Minimum Højde");
        heightLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("heightLimit"));
        heightLimit.setMinWidth(150);

        TableColumn<Activity, String> activityName = new TableColumn<>("Aktivitet");
        activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityName"));
        activityName.setMinWidth(150);

        TableColumn<Activity, String> activityInfo = new TableColumn<>("Aktivitet Beskrivelse");
        activityInfo.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityInfo"));
        activityInfo.setMinWidth(150);

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

        activityTableView.setMinWidth(700);
        activityTableView.setMinHeight(600);

        subLayout.setHgap(50);
        subLayout.setVgap(50);
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
