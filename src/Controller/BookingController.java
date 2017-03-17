package Controller;

/**
 * Created by Christian on 16-03-2017.
 */
public class BookingController
{
    private static BookingController instance = null;

    public static BookingController getInstance()
    {
        if (instance == null)
            instance = new BookingController();
        return instance;
    }

    private BookingController()
    {

    }
}
