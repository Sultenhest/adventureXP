package View;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Main_GUI extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ActivityView activityScene = new ActivityView();

        primaryStage.setTitle("Adventure Alley");
        primaryStage.setScene(activityScene.getScene());
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
