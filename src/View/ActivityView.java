package View;

import Controller.ActivityController;
import Model.Activity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
                    Alerts.doErrorBox( "Fejl", "Vælg en aktivitet du vil ændre.", null );
                }
                break;
            case 2:
                //Delete
                if ( Alerts.doConfirmBox( "Er du sikker?", "Er du sikker på du vil slette det her?", null ) )
                {
                    //delete here
                }
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
            else
                createStatusMessage(1, false);
        }
        // If Update
        else if (buttonID ==  1)
        {
            if (str.length == 3 && str[0] != null)
                activityController.updateActivity(activity.getID(), str[0], str[1], str[2]);
            else
                createStatusMessage(1, false);
        }
    }

    public void createStatusMessage(int buttonID, boolean succesfullAction)
    {
        String[] updateStatus = { "oprettet", "opdateret", "slettet" };

        if ( succesfullAction ) {
            Alerts.doConfirmBox( "Succes", "Aktiviteten blev " + updateStatus[buttonID] + ".", null );
        } else {
            Alerts.doErrorBox( "Fejl", "Aktiviteten blev ikke " + updateStatus[buttonID] + ".", null );
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
