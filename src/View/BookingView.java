package View;

import Controller.ReservationController;
import Model.Activity;
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

    private TableView<Activity> bookingTableView;

    public BookingView(int ID)
    {
        setID(ID);
        createLayout();
        createLayoutSettings();
        attachLayoutToScene();

        reservationController = new ReservationController();

    }

    @Override
    public void createLayout()
    {
        layout = new VBox();
        VBox searchFunction = new VBox();

        TextField searchField = new TextField();
        searchFunction.getChildren().addAll( searchField );

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
                callBookingModal( buttonID, "Opret Booking", "Udfyld felterne for at oprette en Booking");
                break;
            case 1:
                //updatere
                callBookingModal(buttonID, "Ret Booking", "Udfyld felterne for at ændre i Bookingen");
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

    private void callBookingModal(int buttonID ,String title, String message ) {
        BookingModal bm = new BookingModal();
        String[] str = bm.display( title, message );
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
