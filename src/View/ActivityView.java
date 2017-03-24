package View;

import Controller.ActivityController;
import Model.Activity;
import Model.Final_ErrorMessages;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Christian on 16-03-2017.
 */

public class ActivityView extends BaseScene implements BaseLayout, TableInterface
{
    private VBox layout;

    private Button createActivity;
    private Button deleteActivity;
    private Button updateActivity;

    private TableView<Activity> activityTableView;

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

        activityTableView = new TableView<>();

        HBox bottomMenu = new HBox();
        createActivity = new Button("Opret ny");
        updateActivity = new Button("Opdater");
        deleteActivity = new Button("Slet");
        bottomMenu.getChildren().addAll(createActivity, updateActivity, deleteActivity);

        bottomMenu.getStyleClass().add("menu");

        layout.getChildren().addAll(activityTableView, bottomMenu );
    }

    public void createTableColoumns()
    {
        TableColumn<Activity, String> activityName = new TableColumn<>("Aktivitet");
        activityName.setCellValueFactory(new PropertyValueFactory<Activity, String>("activityName"));

        TableColumn<Activity, Integer> ageLimit = new TableColumn<>("Alders begrænsning");
        ageLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("ageLimit"));

        TableColumn<Activity, Integer> heightLimit = new TableColumn<>("Minimum Højde");
        heightLimit.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("heightLimit"));

        activityTableView.getColumns().addAll(activityName, ageLimit, heightLimit);
    }

    @Override
    public void createLayoutSettings()
    {
        createActivity.setOnAction(event ->
        {
            buttonClicked(0);
        });

        updateActivity.setOnAction(event ->
        {
            buttonClicked(1);
        });

        deleteActivity.setOnAction(event ->
        {
            buttonClicked(2);
        });
    }

    public void buttonClicked(int buttonID)
    {
        switch (buttonID)
        {
            case 0:
                //create
                callActivityModal( buttonID, "Opret aktivitet", "Udfyld felterne for at oprette en aktivitet", new Activity() );
                break;
            case 1:
                //updatere
                if ( activityTableView.getSelectionModel().selectedItemProperty().get() != null ) {
                  Activity act = activityTableView.getSelectionModel().selectedItemProperty().get();

                    callActivityModal(buttonID, "Ret aktivitet", "Udfyld felterne for at ændre i aktiviteten", act);
                } else {
                    doAlert( Alert.AlertType.ERROR, "Fejl", "Vælg en aktivitet du vil ændre.", null );
                }
                break;
            case 2:
                //Delete
                doAlert( Alert.AlertType.CONFIRMATION, "Er du sikker?", "Er du sikker på du vil slette det her?", null );
                break;
            default:
                //nothing
                break;
        }
    }

    private void callActivityModal(int buttonID ,String title, String message, Activity activity) //String[] input )
    {
        ActivityModal am = new ActivityModal();
        String[] str = am.display( title, message, activity);

        // If Insert
        if (buttonID == 0)
        {
            if(str[0] != null ) {
                String name = str[0];
                String age = str[1];
                String height = str[2];

                activityController.createActivity(buttonID, name, age, height);
            }
        }
        // If Update
        else if (buttonID ==  1)
        {
            if (str.length == 3 && str[0] != null)
                activityController.updateActivity(activity.getID(), str[0], str[1], str[2]);
        }

    }

    private void doAlert(Alert.AlertType alertType, String title, String header, String content){
        Alert alert = new Alert( alertType );
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void createStatusMessage(int buttonID, boolean succesfullAction)
    {
        String[] updateStatus = { "oprettet", "opdateret", "slettet" };

        if ( succesfullAction ) {
            doAlert( Alert.AlertType.INFORMATION, "Succes", "Aktiviteten blev " + updateStatus[buttonID] + ".", null );
        } else {
            doAlert( Alert.AlertType.ERROR, "Fejl", "Aktiviteten blev ikke " + updateStatus[buttonID] + ".", null );
        }
    }

    public void addSingleToTable(Activity activity)
    {
        this.activityTableView.getItems().add(activity);
    }

    public void addMultiToTable(ArrayList<Activity> activities)
    {
        ObservableList<Activity> observableList = FXCollections.observableList(activities);

        this.activityTableView.getItems().addAll(observableList);
    }

    public void overideAllToTable(ArrayList<Activity> activities)
    {
        this.activityTableView.getItems().clear();

        ObservableList<Activity> observableList = FXCollections.observableList(activities);

        this.activityTableView.getItems().addAll(observableList);
    }

    public void updateCellString(TableColumn.CellEditEvent<Activity, String> cellEditEvent, CellEditType cellEditType)
    {
        String oldValue;
        String newValue;

        oldValue = cellEditEvent.getOldValue();
        newValue = cellEditEvent.getNewValue();

        System.out.println(oldValue + ", " + newValue);

        switch (cellEditType)
        {
            case ACTIVITY_NAME:
                //activityController.updateActivity(cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow()));
                break;
            default:
                break;
        }
    }

    public void updateCellInteger(TableColumn.CellEditEvent<Activity, Integer> cellEditEvent, CellEditType cellEditType)
    {
        String oldValue;
        String newValue;

        oldValue = String.valueOf(cellEditEvent.getOldValue());
        newValue = String.valueOf(cellEditEvent.getNewValue());

        System.out.println(oldValue + ", " + newValue);

        switch (cellEditType)
        {
            case ACTIVITY_AGELIMIT:
                //client_database.updateEntry((Order)cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow()));
                //((Activity) cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow())).setItemCell(cellEditEvent.getNewValue());
                //((Activity) cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow())).setItem(newValue);
                break;
            case ACTIVITY_MINHEIGHT:
                //client_database.updateEntry((Order)cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow()));
                //((Activity) cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow())).setNumberOfItemsCell(cellEditEvent.getNewValue());
                //((Activity) cellEditEvent.getTableView().getItems().get(cellEditEvent.getTablePosition().getRow())).setNumberOfItems(newValue);
                break;
            default:
                break;
        }
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
