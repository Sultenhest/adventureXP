package View;

import Model.Finals;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public abstract class BaseScene
{
    private int ID;
    private Scene scene;

    public Scene getScene()
    {
        return scene;
    }

    public void setScene(Pane pane)
    {
        Finals finals = Finals.getInstance();

        this.scene = new Scene(pane,finals.getMinWindowWitdh(), finals.getMinWindowHeight());
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getID()
    {
        return ID;
    }
}