/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Database
{
    private static Database instance = new Database();

    public static Database getInstance()
    {
        return instance;
    }

    private Database()
    {
    }
}
