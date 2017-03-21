package View;

import Controller.ActivityController;
import Model.Activity;
import Model.Final_ErrorMessages;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

/**
 * Created by Christian on 16-03-2017.
 */

public class ActivityView extends BaseScene implements BaseLayout
{
    private VBox layout;
    private GridPane subLayout;
    private TextField activityNameField;
    //private TextField acitivityInfoField;
    private TextField ageLimitField;
    private TextField heightLimitField;

    private Button createActivity;
    private Button deleteActivity;
    private Button updateActivity;

    private TableView<Activity> activityTableView;

    private Label status;

    private ImageView logo;

    private ActivityController activityController;

    public ActivityView(int ID)
    {
        setID(ID);
        createLayout();
        createTableColoumns();
        createLayoutSettings();
        attachLayoutToScene();

        activityController = new ActivityController(this);
    }

    @Override
    public void createLayout()
    {
        layout = new VBox();

        subLayout = new GridPane();

        activityNameField = new TextField();
        //acitivityInfoField = new TextField();
        ageLimitField = new TextField();
        heightLimitField = new TextField();

        createActivity = new Button();
        updateActivity = new Button();
        deleteActivity = new Button();

        activityTableView = new TableView<>();

        status = new Label();

        Image image = new Image(Main_GUI.class.getResourceAsStream("LOGO.png"));

        logo = new ImageView(image);

        subLayout.add(logo, 0 , 0);
        subLayout.add(activityTableView, 1 , 0);

        subLayout.add(activityNameField, 1 , 1);
        //subLayout.add(acitivityInfoField, 1 , 2);
        subLayout.add(ageLimitField, 2 , 1);
        subLayout.add(heightLimitField, 2 , 2);

        subLayout.add(createActivity, 3, 1);
        subLayout.add(updateActivity, 3, 2);
        subLayout.add(deleteActivity, 3, 3);

        subLayout.add(status, 1, 3);

        layout.getChildren().add(subLayout);
    }

    public void createTableColoumns()
    {
       /* TableColumn<Activity, Integer> activityID = new TableColumn<>("ID");
        activityID.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ID"));
        activityID.setMinWidth(100);*/

        TableColumn<Activity, String> activityName = new TableColumn<>("Aktivitet");
        activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityName"));
        activityName.setMinWidth(150);

        /*TableColumn<Activity, String> activityInfo = new TableColumn<>("Aktivitet Beskrivelse");
        activityInfo.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityInfo"));
        activityInfo.setMinWidth(150);*/

        TableColumn<Activity, Integer> ageLimit = new TableColumn<>("Alders begrænsning");
        ageLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ageLimit"));
        ageLimit.setMinWidth(150);

        TableColumn<Activity, Integer> heightLimit = new TableColumn<>("Minimum Højde");
        heightLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("heightLimit"));
        heightLimit.setMinWidth(150);

        //activityTableView.getColumns().addAll(activityID, ageLimit, heightLimit, activityName, activityInfo);
        activityTableView.getColumns().addAll(activityName, ageLimit, heightLimit);
        activityTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @Override
    public void createLayoutSettings()
    {
        activityNameField.setPromptText("Aktivitet Navn...");
        //acitivityInfoField.setPromptText("Aktivitet Info...");
        ageLimitField.setPromptText("Aldersbegrænsning...");
        heightLimitField.setPromptText("Minimum Højde...");

        createActivity.setText("Skab ny Aktivitet");
        createActivity.setStyle("-fx-background-color:\n" + "" +
                "            linear-gradient(#ffd65b, #000000),\n" + "" +
                "            linear-gradient(#ffef84, #000000),\n" + "" +
                "            linear-gradient(#ffea6a, #000000),\n" + "" +
                "            linear-gradient(#ffe657 0%, #f8c202 50%, #000000 100%),\n" + "" +
                "            linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");
        createActivity.setOnAction(event ->
        {
            buttonClicked(0);
        });

        updateActivity.setText("Opdatere Aktiviter");
        updateActivity.setStyle("-fx-background-color:\n" + "" +
                "            linear-gradient(#ffd65b, #000000),\n" + "" +
                "            linear-gradient(#ffef84, #000000),\n" + "" +
                "            linear-gradient(#ffea6a, #000000),\n" + "" +
                "            linear-gradient(#ffe657 0%, #f8c202 50%, #000000 100%),\n" + "" +
                "            linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");
        updateActivity.setOnAction(event ->
        {
            buttonClicked(1);
        });

        deleteActivity.setText("Slet Aktiviter");
        deleteActivity.setStyle("-fx-background-color:\n" + "" +
                "            linear-gradient(#ffd65b, #000000),\n" + "" +
                "            linear-gradient(#ffef84, #000000),\n" + "" +
                "            linear-gradient(#ffea6a, #000000),\n" + "" +
                "            linear-gradient(#ffe657 0%, #f8c202 50%, #000000 100%),\n" + "" +
                "            linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));");
        deleteActivity.setOnAction(event ->
        {
            buttonClicked(2);
        });

        activityTableView.setMinWidth(700);
        activityTableView.setMinHeight(600);

        hideStatus();

        subLayout.setHgap(50);
        subLayout.setVgap(50);
    }

    public void buttonClicked(int buttonID)
    {
        switch (buttonID)
        {
            case 0:
                //create
                activityController.createActivity(buttonID, activityNameField.getText().trim(), ageLimitField.getText().trim(), heightLimitField.getText().trim());
                break;
            case 1:
                //updatere
                //somemethod();
                break;
            case 2:
                //Delete
                //somemethod();
                break;
            default:
                //nothing
                break;
        }
    }

    public void createStatusMessage(int buttonID, boolean succesfullAction)
    {
        if (succesfullAction)
        {
            switch (buttonID)
            {
                case 0:
                    //create Button
                    showStatus(Final_ErrorMessages.getInstance().getACTIVITY_CREATED_SUCCESFULL(), true);
                    break;
                case 1:
                    //update button
                    showStatus(Final_ErrorMessages.getInstance().getACTIVITY_UPDATED_SUCCESFULL(), true);
                    break;
                case 2:
                    //Delete button
                    showStatus(Final_ErrorMessages.getInstance().getACTIVITY_DELETE_SUCCESFULL(), true);
                    break;
                default:
                    //nothing
                    break;
            }
        }
        else
        {
            switch (buttonID)
            {
                case 0:
                    //create Button
                    showStatus(Final_ErrorMessages.getInstance().getACTIVITY_CREATED_UNSUCCESFULL(), false);
                    break;
                case 1:
                    //update button
                    showStatus(Final_ErrorMessages.getInstance().getACTIVITY_UPDATED_UNSUCCESFULL(), false);
                    break;
                case 2:
                    //Delete button
                    showStatus(Final_ErrorMessages.getInstance().getACTIVITY_DELETE_UNSUCCESFULL(), false);
                    break;
                default:
                    //nothing
                    break;
            }
        }
    }

    public void showStatus(String statusText, boolean succesfullAction)
    {
        status.setVisible(true);

        status.setText(statusText);

        if (succesfullAction)
        {
            status.setTextFill(Paint.valueOf("Green"));
        }
        else
        {
            status.setTextFill(Paint.valueOf("Red"));
        }
    }

    public void hideStatus()
    {
        status.setVisible(false);
    }

    public void addMultiToTable(ArrayList<Activity> activities)
    {
        ObservableList<Activity> observableList = FXCollections.observableList(activities);

        this.activityTableView.getItems().addAll(observableList);
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
