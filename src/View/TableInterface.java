package View;

import Model.Activity;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;

/**
 * Created by Christian on 21-03-2017.
 */
public interface TableInterface
{
    void addSingleToTable(Activity activity);
    void addMultiToTable(ArrayList<Activity> activities);
    void updateCellString(TableColumn.CellEditEvent<Activity, String> cellEditEvent, CellEditType cellEditType);
    void updateCellInteger(TableColumn.CellEditEvent<Activity, Integer> cellEditEvent, CellEditType cellEditType);
}
