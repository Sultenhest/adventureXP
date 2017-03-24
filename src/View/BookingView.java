package View;

import Controller.ReservationController;
import Model.Activity;
import Model.Reservation;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BookingView extends BaseScene implements BaseLayout, TableInterface
{
    // Controller
    private ReservationController reservationController;

    private VBox layout;

    private Button createBooking;
    private Button deleteBooking;
    private Button updateBooking;

    private TextField searchField;
    private Label searchLabel = new Label("Søg: ");

    private TableView<Reservation> bookingTableView;

    private ObservableList<Reservation> reservations;

    public BookingView(int ID)
    {
        setID(ID);
        createLayout();
        createLayoutSettings();
        attachLayoutToScene();
        //bindTable();

        reservationController = new ReservationController();

    }

    @Override
    public void createLayout()
    {
        layout = new VBox();
        HBox searchFunction = new HBox();

        searchField = new TextField();

        searchFunction.getChildren().addAll( searchLabel, searchField );

        //reservations = new FXCollections.observableArrayList();

        bookingTableView = new TableView<>();

        HBox bottomMenu = new HBox();

        createBooking = new Button("Opret ny");
        updateBooking = new Button("Opdater");
        deleteBooking = new Button("Slet");
        bottomMenu.getChildren().addAll(createBooking, updateBooking, deleteBooking);

        bottomMenu.getStyleClass().add("menu");

        layout.getChildren().addAll(searchFunction, bookingTableView, bottomMenu );
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
                callBookingModal( buttonID, "Opret Booking", "Udfyld felterne for at oprette en Booking", new Reservation());
                break;
            case 1:
                //updatere
                if ( bookingTableView.getSelectionModel().selectedItemProperty().get() != null ) {
                    Reservation r = bookingTableView.getSelectionModel().selectedItemProperty().get();

                    callBookingModal(buttonID, "Ret Booking", "Udfyld felterne for at ændre i Bookingen", r);
                } else {
                    doAlert( Alert.AlertType.ERROR, "Fejl", "Vælg en booking du vil ændre.", null );
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

    public void createStatusMessage(int buttonID, boolean succesfullAction)
    {
        String[] updateStatus = { "oprettet", "opdateret", "slettet" };

        if ( succesfullAction ) {
            doAlert( Alert.AlertType.INFORMATION, "Succes", "Reservationen blev " + updateStatus[buttonID] + ".", null );
        } else {
            doAlert( Alert.AlertType.ERROR, "Fejl", "Reservationen blev ikke " + updateStatus[buttonID] + ".", null );
        }
    }

    private void callBookingModal(int buttonID ,String title, String message, Reservation reservation ) {
        BookingModal bm = new BookingModal();
        String[] str = bm.display( title, message, reservation );

        // If Insert
        if (buttonID == 0)
        {
            if(str[0] != null )
            {
                String activity = str[0];
                String instructor = str[1];
                String clientname = str[2];
                String date = str[3];
                String startTime = str[4];
                String duration = str[5];
                String participants = str[6];

                //create reservation in reservationModel
            }
        }
        // If Update
        else if (buttonID ==  1)
        {
            if (str.length == 3 && str[0] != null)
            {
                //update in reservationController
            }
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

    /*
    private void bindTable()
    {
        FilteredList<Reservation> filteredData = new FilteredList<>(reservations, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                /*if (reservations.getName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches first name.
                }
                else if (reservations.getName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (reservations.getName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }

                return false; // Does not match.
            });
        });

        SortedList<Reservation> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(bookingTableView.comparatorProperty());

        bookingTableView.setItems(sortedData);
    }
    */
}
