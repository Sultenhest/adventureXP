package Model;

public class Finals
{
    private final int minWindowWitdh = 600;
    private final int minWindowHeight = 700;

    private static Finals instance = new Finals();

    public static Finals getInstance()
    {
        return instance;
    }

    private Finals() { }

    public int getMinWindowWitdh()
    {
        return minWindowWitdh;
    }

    public int getMinWindowHeight()
    {
        return minWindowHeight;
    }
}
