package Model;

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
