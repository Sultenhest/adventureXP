package View;

import Controller.ReservationController;
import Model.Activity;
import Model.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BookingView extends BaseScene implements BaseLayout
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
    private TableView<Reservation> bookingCalendarTableView;

    private ObservableList<Reservation> reservations;

    public BookingView(int ID)
    {
        reservationController = new ReservationController(this);

        setID(ID);
        createLayout();
        createLayoutSettings();
        attachLayoutToScene();
        createTableColoumns();
        bindTable();
        createCalendarTable();
        fillCalendarTable();
    }

    @Override
    public void createLayout()
    {
        layout = new VBox();

        searchField = new TextField();

        HBox searchFunction = new HBox();
        searchFunction.getChildren().addAll( searchLabel, searchField );
        searchFunction.getStyleClass().add("searchingBar");

        bookingTableView = new TableView<>();

        HBox bottomMenu = new HBox();
        createBooking = new Button("Opret ny");
        updateBooking = new Button("Opdater");
        deleteBooking = new Button("Slet");
        bottomMenu.getChildren().addAll(createBooking, updateBooking, deleteBooking);

        bottomMenu.getStyleClass().add("menu");

        bookingCalendarTableView = new TableView<>();

        layout.getChildren().addAll(searchFunction, bookingTableView , bookingCalendarTableView, bottomMenu );
    }

    public void createTableColoumns()
    {
        TableColumn<Reservation, String> date = new TableColumn<>("Dato");
        date.setCellValueFactory(new PropertyValueFactory<Reservation, String>("startDateAsString"));

        TableColumn<Reservation, String> customerName = new TableColumn<>("Customer Name");
        customerName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("customerName"));

        TableColumn<Reservation, Integer> amountOfParticipants = new TableColumn<>("Amount Of Participants");
        amountOfParticipants.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("amountOfParticipants"));

        TableColumn<Reservation, String> instructor = new TableColumn<>("Instructor");
        instructor.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Instructor"));

        TableColumn<Reservation, String> activityName = new TableColumn<>("Activity");
        activityName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("activityName"));

        bookingTableView.getColumns().addAll(date, customerName, amountOfParticipants, instructor, activityName);

        //addMultiToTableOb(FXCollections.observableList(reservationController.getReservationModel().readAllReservations()));
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
                    Alerts.doErrorBox( "Fejl", "Vælg en booking du vil ændre.", null );
                }

                break;
            case 2:
                //Delete Reservation
                if ( Alerts.doConfirmBox( "Er du sikker?", "Er du sikker på du vil slette det her?", null ) )
                    reservationController.deleteBooking(bookingTableView.getSelectionModel().selectedItemProperty().get());
                break;
            default:
                //nothing
                break;
        }
    }

    private void callBookingModal(int buttonID ,String title, String message,Reservation reservation) {
        BookingModal bm = new BookingModal();
        Reservation res = bm.display( title, message, reservation);

        // If Insert
        if (buttonID == 0)
            if(res != null )
                reservationController.submitBooking(res);
        // If Update
        else if (buttonID ==  1)
            if (res != null)
            {
                //update in reservationController
            }
    }

    public void createStatusMessage(int buttonID, boolean succesfullAction)
    {
        String[] updateStatus = { "oprettet", "opdateret", "slettet" };

        if ( succesfullAction ) {
            Alerts.doInformationBox( "Succes", "Reservationen blev " + updateStatus[buttonID] + ".", null );
        } else {
            Alerts.doErrorBox( "Fejl", "Reservationen blev ikke " + updateStatus[buttonID] + ".", null );
        }
    }

    public void overideAllToTable(ArrayList<Reservation> reservations)
    {
        this.bookingTableView.getItems().clear();

        ObservableList<Reservation> observableList = FXCollections.observableList(reservations);

        this.bookingTableView.getItems().addAll(observableList);
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

    private void bindTable()
    {
        reservations = FXCollections.observableList( reservationController.getReservationModel().readAllReservations() );

        FilteredList<Reservation> filteredData = new FilteredList<>(reservations, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredData.setPredicate(reservation -> {
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (reservation.getDate().toString().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches first name.
                }
                else if (reservation.getCustomerName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(reservation.getAmountOfParticipants()).toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (reservation.getActivityName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (reservation.getInstructor().toLowerCase().indexOf(lowerCaseFilter) != -1)
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

    public void createCalendarTable()
    {
        TableColumn<Reservation, String> time = new TableColumn<>("Tid");
        time.setCellValueFactory(new PropertyValueFactory<Reservation, String>("startTimeAsString"));

        TableColumn<Reservation, String> customerName = new TableColumn<>("Customer Name");
        customerName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("customerName"));

        TableColumn<Reservation, Integer> amountOfParticipants = new TableColumn<>("Amount Of Participants");
        amountOfParticipants.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("amountOfParticipants"));

        TableColumn<Reservation, String> instructor = new TableColumn<>("Instructor");
        instructor.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Instructor"));

        TableColumn<Reservation, String> activityName = new TableColumn<>("Activity");
        activityName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("activityName"));

        bookingCalendarTableView.getColumns().addAll(time, customerName, amountOfParticipants, instructor, activityName);
    }

    public void fillCalendarTable()
    {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2017, 03, 28, 0, 0);

        this.bookingCalendarTableView.getItems().clear();

        int count = 30;

        for (int i = 1; i < 48; i++)
        {
            count += 30;

            calendar.set(2017, 03, 28, 0, count, 0);
            Date date = new Date();
            date.setTime(calendar.getTimeInMillis());

            //bookingCalendarTableView.getItems().add(new Reservation(date, 0, "", "", 0, new Activity("", 0, 0)));

        }
    }
}
