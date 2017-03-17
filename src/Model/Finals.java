package Model;

/**
 * Created by Christian on 16-03-2017.
 */
public class Finals
{
    private final int minWindowWitdh = 800;
    private final int minWindowHeight = 800;

    private static Finals instance = new Finals();

    public static Finals getInstance()
    {
        return instance;
    }

    private Finals()
    {

    }

    public int getMinWindowWitdh()
    {
        return minWindowWitdh;
    }

    public int getMinWindowHeight()
    {
        return minWindowHeight;
    }
}