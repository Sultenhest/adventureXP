package View;

import Controller.BookingController;
import Model.Booking;
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

public class BookingView extends BaseScene implements BaseLayout
{
    // Controller
    private BookingController bookingController;

    private VBox layout;

    private Button createBooking;
    private Button deleteBooking;
    private Button updateBooking;

    private TextField searchField;
    private Label searchLabel = new Label("Søg: ");

    private TableView<Booking> bookingTableView;
    private TableView<Booking> bookingCalendarTableView;

    private DatePicker datePicker;

    private ObservableList<Booking> bookings;

    public FilteredList<Booking> filteredData;
    public SortedList<Booking> sortedData;

    private boolean firstTime = true;

    public BookingView(int ID)
    {
        setID(ID);
        createLayout();
        createLayoutSettings();
        attachLayoutToScene();
        createTableColoumns();
        bookingController = new BookingController(this);
        //bindTable();
        createCalendarTable();
        //fillCalendarTable();
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

        datePicker = new DatePicker();

        layout.getChildren().addAll(searchFunction, bookingTableView , bookingCalendarTableView, bottomMenu );
    }

    public void createTableColoumns()
    {
        bookings = FXCollections.observableArrayList();

        TableColumn<Booking, String> date = new TableColumn<>("Dato");
        date.setCellValueFactory(new PropertyValueFactory<Booking, String>("startTime"));

        TableColumn<Booking, String> customerName = new TableColumn<>("Customer Name");
        customerName.setCellValueFactory(new PropertyValueFactory<Booking, String>("customerName"));

        TableColumn<Booking, Integer> amountOfParticipants = new TableColumn<>("Amount Of Participants");
        amountOfParticipants.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("amountOfParticipants"));

        TableColumn<Booking, String> instructor = new TableColumn<>("Instructor");
        instructor.setCellValueFactory(new PropertyValueFactory<Booking, String>("Instructor"));

        TableColumn<Booking, String> activityName = new TableColumn<>("Activity");
        activityName.setCellValueFactory(new PropertyValueFactory<Booking, String>("activityName"));

        bookingTableView.getColumns().addAll(date, customerName, amountOfParticipants, instructor, activityName);

        //addMultiToTableOb(FXCollections.observableList(bookingController.getBookingModel().readAllBookings()));
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
                callBookingModal( buttonID, "Opret Booking", "Udfyld felterne for at oprette en Booking", new Booking());
                break;
            case 1:
                //updatere
                if ( bookingTableView.getSelectionModel().selectedItemProperty().get() != null ) {
                    Booking r = bookingTableView.getSelectionModel().selectedItemProperty().get();

                    callBookingModal(buttonID, "Ret Booking", "Udfyld felterne for at ændre i Bookingen", r);
                } else {
                    Alerts.doErrorBox( "Fejl", "Vælg en booking du vil ændre.", null );
                }

                break;
            case 2:
                //Delete Booking
                if ( Alerts.doConfirmBox( "Er du sikker?", "Er du sikker på du vil slette det her?", null ) )
                    bookingController.deleteBooking(bookingTableView.getSelectionModel().selectedItemProperty().get());
                break;
            default:
                //nothing
                break;
        }
    }

    private void callBookingModal(int buttonID , String title, String message, Booking booking) {
        BookingModal bm = new BookingModal();
        Booking res = bm.display( title, message, booking);

        // If Insert
        if (buttonID == 0) {
            if (res != null)
                bookingController.submitBooking(res);
            // If Update
        }else if (buttonID ==  1) {
            if( !res.getCustomerName().equals("DONOTUPDATE") )
            {
                bookingController.updateBooking(res);
            } else {
                createStatusMessage(buttonID, false);
            }
        }
    }

    public void createStatusMessage(int buttonID, boolean succesfullAction)
    {
        String[] updateStatus = { "oprettet", "opdateret", "slettet" };

        if ( succesfullAction ) {
            Alerts.doInformationBox( "Succes", "Reservationen blev " + updateStatus[buttonID] + ".", null );
        } else {
            Alerts.doErrorBox("Fejl", "Reservationen blev ikke " + updateStatus[buttonID] + ".", null);
        }
    }

    public void overideAllToTable(ArrayList<Booking> bookings)
    {
        //this.bookingTableView.getItems().clear();

        //this.bookings =  FXCollections.observableArrayList(bookings);

        /*ObservableList<Booking> shit = FXCollections.observableArrayList(bookings);

        if (!firstTime)
        {
            if (sortedData.comparatorProperty().isBound())
            {
                sortedData.comparatorProperty().unbind();
            }
        }
        else
        {
            firstTime = false;
        }

        this.bookingTableView.getItems().addAll(shit);*/

        bindTable(bookings);

       // this.bookingTableView.getItems().addAll()
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

    private void bindTable(ArrayList<Booking> bookings)
    {
        ObservableList<Booking> list = FXCollections.observableList(bookings);

        filteredData = new FilteredList<>(list, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            filteredData.setPredicate(booking -> {
                if (newValue == null || newValue.isEmpty())
                {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (booking.getDate().toString().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches first name.
                }
                else if (booking.getCustomerName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(booking.getAmountOfParticipants()).toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (booking.getActivityName().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }
                else if (booking.getInstructor().toLowerCase().indexOf(lowerCaseFilter) != -1)
                {
                    return true; // Filter matches last name.
                }

                return false; // Does not match.
            });
        });

        sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(bookingTableView.comparatorProperty());

        bookingTableView.setItems(sortedData);
    }

    public void createCalendarTable()
    {
        TableColumn<Booking, String> time = new TableColumn<>("Tid");
        time.setCellValueFactory(new PropertyValueFactory<Booking, String>("startTimeAsString"));

        TableColumn<Booking, String> customerName = new TableColumn<>("Customer Name");
        customerName.setCellValueFactory(new PropertyValueFactory<Booking, String>("customerName"));

        TableColumn<Booking, Integer> amountOfParticipants = new TableColumn<>("Amount Of Participants");
        amountOfParticipants.setCellValueFactory(new PropertyValueFactory<Booking, Integer>("amountOfParticipants"));

        TableColumn<Booking, String> instructor = new TableColumn<>("Instructor");
        instructor.setCellValueFactory(new PropertyValueFactory<Booking, String>("Instructor"));

        TableColumn<Booking, String> activityName = new TableColumn<>("Activity");
        activityName.setCellValueFactory(new PropertyValueFactory<Booking, String>("activityName"));

        bookingCalendarTableView.getColumns().addAll(time, customerName, amountOfParticipants, instructor, activityName);
    }

    /*public void fillCalendarTable()
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

            //bookingCalendarTableView.getItems().add(new Booking(date, 0, "", "", 0, new Activity("", 0, 0)));

        }
    }*/

    /*public void fillCalendarTable(ArrayList<Booking> bookings)
    {
        ArrayList<Booking> reservationsToDate = new ArrayList<>();

        for (Booking reservation: bookings)
        {
            if (reservation.getDate().equals(datePicker.getValue()))
            {
                reservationsToDate.add(reservation);
            }
        }

        Calendar calendar = new GregorianCalendar();
        this.bookingCalendarTableView.getItems().clear();

        int count = 30;

        for (int i = 1; i < 48; i++)
        {
            count += 30;

            for (Booking reservation: reservationsToDate)
            {
                String startTime = reservation.getStartTime();

                //count = calendar.get(Calendar.HOUR_OF_DAY) * 60;

                if (reservation.getStartTime().equals())
                {

                }
            }

            calendar.set(2017, 03, 28, 0, count, 0);
            Date date = new Date();
            date.setTime(calendar.getTimeInMillis());

            //bookingCalendarTableView.getItems().add(new Booking(date, 0, "", "", 0, new Activity("", 0, 0)));

        }
    }*/
}
