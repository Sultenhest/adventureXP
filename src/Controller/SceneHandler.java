package Controller;

import Model.SceneCollection;
import View.ActivityView;
import View.Main_GUI;
import javafx.scene.Scene;

/**
 * Created by Christian on 17-03-2017.
 */

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

    public void createScene(int ID)
    {
        switch (ID)
        {
            case 0:
                ActivityView activityScene = new ActivityView(0);

                addScene(activityScene.getScene());
                break;
            default:
                break;
        }
    }

    public void addScene(Scene scene)
    {
        SceneCollection sceneCollection = SceneCollection.getInstance();

        sceneCollection.getSceneList().add(scene);
    }

    public void applyScene(int ID)
    {
        SceneCollection sceneCollection = SceneCollection.getInstance();

        Main_GUI.getWindow().setScene(sceneCollection.getSceneList().get(ID));
    }
}