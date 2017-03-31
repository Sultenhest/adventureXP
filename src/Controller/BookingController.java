package Controller;

import Model.Booking;
import Model.BookingModel;
import View.BookingView;

public class BookingController
{
    private BookingView bookingView;
    private BookingModel bookingModel = BookingModel.getInstance();

    // Constructor
    public BookingController(BookingView bookingView)
    {
        this.bookingView = bookingView;
        this.bookingView.overideAllToTable(bookingModel.readAllBookings());
    }

    public void submitBooking(Booking res)
    {
        boolean oneBookingFieldIsEmpty = true;

        if (res.getDate() == null || res.getCustomerName().equals("") || res.getInstructor().equals("") ||
                res.getAmountOfParticipants() == 0 || res.getActivity() == null)
            oneBookingFieldIsEmpty = false;

        if (!oneBookingFieldIsEmpty)
        {
            bookingView.createStatusMessage(0, false);
        }
        else //Creates Booking object & calls method in BookingModel that insert "Booking" object in DB
        {
            bookingView.createStatusMessage(0, bookingModel.insertBookingInDB(res));
            bookingView.overideAllToTable(bookingModel.readAllBookings());
        }
    }

    private boolean validateInput(Booking res)
    {
        return !(res.getDate() == null || res.getCustomerName().equals("") || res.getInstructor().equals("") ||
            res.getAmountOfParticipants() == 0 || res.getActivity() == null);
    }

    public void updateBooking(Booking booking)
    {
        if (booking == null) {
            bookingView.createStatusMessage(1, false);
        }else
        {
            if (validateInput(booking))
            {
                // Updates booking to db, and creates success message
                bookingView.createStatusMessage( 1, bookingModel.updateBooking(booking));
            }
            else
            {
                bookingView.createStatusMessage(1, false);
            }
        }

        bookingView.overideAllToTable(bookingModel.readAllBookings());
    }

    public void deleteBooking(Booking res)
    {
        if (res == null)
            bookingView.createStatusMessage(2, false);
        else
        {
            if (validateInput(res))
            {
                //Deletes booking from DB and creates success message.
                bookingView.createStatusMessage(2, bookingModel.deleteBooking(res.getID()));
                bookingView.overideAllToTable(bookingModel.readAllBookings());
            }
        }
    }

    public BookingModel getBookingModel()
    {
        return bookingModel;
    }

    public void setBookingModel(BookingModel bookingModel)
    {
        this.bookingModel = bookingModel;
    }
}