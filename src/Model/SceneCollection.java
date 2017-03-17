package Model;

import javafx.scene.Scene;

import java.util.ArrayList;

/**
 * Created by Christian on 17-03-2017.
 */
public class SceneCollection
{
    private ArrayList<Scene> sceneList = new ArrayList<>();
    private static SceneCollection instance = new SceneCollection();

    public static SceneCollection getInstance()
    {
        return instance;
    }

    private SceneCollection()
    {
    }

    public ArrayList<Scene> getSceneList()
    {
        return sceneList;
    }
}
