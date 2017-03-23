package View;

import Controller.BookingController;
import Model.Activity;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BookingView extends BaseScene implements BaseLayout, TableInterface
{
    // Controller
    private BookingController bookingController;

    private VBox layout;

    private Button createBooking;
    private Button deleteBooking;
    private Button updateBooking;

    private TableView<Activity> bookingTableView;

    public BookingView(int ID)
    {
        setID(ID);
        createLayout();
        createLayoutSettings();
        attachLayoutToScene();

        bookingController = new BookingController();

    }

    @Override
    public void createLayout()
    {
        layout = new VBox();

        bookingTableView = new TableView<>();

        HBox bottomMenu = new HBox();

        createBooking = new Button("Opret ny");
        updateBooking = new Button("Opdater");
        deleteBooking = new Button("Slet");
        bottomMenu.getChildren().addAll(createBooking, updateBooking, deleteBooking);

        bottomMenu.getStyleClass().add("menu");

        layout.getChildren().addAll(bookingTableView, bottomMenu );
    }

    @Override
    public void createLayoutSettings()
    {
        createBooking.setOnAction(event ->
        {
            buttonClicked(0);
        });

        updateBooking.setOnAction(event ->
        {
            buttonClicked(1);
        });

        deleteBooking.setOnAction(event ->
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
                callActivityModal( buttonID, "Opret Booking", "Udfyld felterne for at oprette en Booking", new String[3] );
                break;
            case 1:
                //updatere
                if ( bookingTableView.getSelectionModel().selectedItemProperty().get() != null ) {
                    String[] str = {
                            bookingTableView.getSelectionModel().selectedItemProperty().get().getActivityName(),
                            Integer.toString(bookingTableView.getSelectionModel().selectedItemProperty().get().getAgeLimit()),
                            Integer.toString(bookingTableView.getSelectionModel().selectedItemProperty().get().getHeightLimit())
                    };
                    callActivityModal(buttonID, "Ret Booking", "Udfyld felterne for at ændre i Bookingen", str);
                } else {
                    doAlert( Alert.AlertType.ERROR, "Fejl", "Vælg en Booking du vil ændre.", null );
                }
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

    private void doAlert(Alert.AlertType alertType, String title, String header, String content){
        Alert alert = new Alert( alertType );
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }

    private void callActivityModal(int buttonID ,String title, String message, String[] input ) {
        ActivityModal am = new ActivityModal();
        String[] str = am.display( title, message, input );

        if( input[0] == null && str[0] != null ) {
            String name = str[0];
            String age = str[1];
            String height = str[2];

            //activityController.createActivity(buttonID, name, age, height);
        }
    }

    public void overideAllToTable()
    {

    }

    @Override
    public void addSingleToTable(Activity activity) {

    }

    @Override
    public void addMultiToTable(ArrayList<Activity> activities) {

    }

    @Override
    public void overideAllToTable(ArrayList<Activity> activities) {

    }

    @Override
    public void updateCellString(TableColumn.CellEditEvent<Activity, String> cellEditEvent, CellEditType cellEditType) {

    }

    @Override
    public void updateCellInteger(TableColumn.CellEditEvent<Activity, Integer> cellEditEvent, CellEditType cellEditType) {

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
