package Controller;

/**
 * Created by Christian on 16-03-2017.
 */
public class BookingController
{
    private static BookingController instance = new BookingController();

    public static BookingController getInstance()
    {
        return instance;
    }

    private BookingController()
    {
    }
}
