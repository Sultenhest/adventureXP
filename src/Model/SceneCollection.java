package Model;

import View.BaseScene;

import java.util.ArrayList;

/**
 * Created by Christian on 17-03-2017.
 */
public class SceneCollection
{
    private ArrayList<BaseScene> sceneList = new ArrayList<>();
    private static SceneCollection instance = new SceneCollection();

    public static SceneCollection getInstance()
    {
        return instance;
    }

    private SceneCollection()
    {
    }

    public ArrayList<BaseScene> getSceneList()
    {
        return sceneList;
    }
}
