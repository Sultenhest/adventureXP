package Controller;

import Model.SceneCollection;
import View.ActivityView;
import View.BaseScene;
import View.BookingView;
import View.Main_GUI;

//Handles creating scenes, Storing them, and changing the stage scene
public class SceneHandler
{
    private static SceneHandler instance = new SceneHandler();

    public static SceneHandler getInstance()
    {
        return instance;
    }

    private SceneHandler()
    {

    }

    // Creates
    public void createScene(int ID)
    {
        switch (ID)
        {
            case 0:
                ActivityView activityScene = new ActivityView(0);
                addScene(activityScene);
                break;
            case 1:
                BookingView bookingScene = new BookingView(1);
                addScene(bookingScene);
                break;
            default:
                break;
        }
    }

    public void addScene(BaseScene view)
    {
        SceneCollection sceneCollection = SceneCollection.getInstance();

        sceneCollection.getSceneList().add(view);
    }

    public void applyScene(int ID)
    {
        SceneCollection sceneCollection = SceneCollection.getInstance();

        Main_GUI.getWindow().setScene(sceneCollection.getSceneList().get(ID).getScene());
    }
}
