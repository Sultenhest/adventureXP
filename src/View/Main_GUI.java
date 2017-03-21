package View;

import Controller.SceneHandler;
import Model.SceneCollection;
import Model.Database;
import Model.DatabaseConnect;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Main_GUI extends Application
{
    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;

        window.setTitle("Adventure Alley");

        // Creates the ActivityView
        SceneHandler.getInstance().createScene(0);
        SceneHandler.getInstance().applyScene(0);
        window.show();
    }

    public static Stage getWindow()
    {
        return window;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
