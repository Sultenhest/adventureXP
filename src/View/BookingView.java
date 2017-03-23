package View;

import Model.Activity;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BookingView extends BaseScene implements BaseLayout, TableInterface
{
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

        //activityController = new ActivityController(this);
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
