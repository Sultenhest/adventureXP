package Controller;

import Model.Reservation;
import Model.ReservationModel;
import View.BookingView;

public class ReservationController
{
    private BookingView bookingView;
    private ReservationModel reservationModel = ReservationModel.getInstance();

    // Constructor
    public ReservationController(BookingView bookingView)
    {
        this.bookingView = bookingView;
        this.bookingView.overideAllToTable(reservationModel.readAllReservations());
    }

    public void submitBooking(Reservation res)
    {
        boolean oneBookingFieldIsEmpty = true;

        if (res.getDate() == null || res.getCustomerName().equals("") || res.getInstructor().equals("") ||
                res.getAmountOfParticipants() == 0 || res.getActivity() == null)
            oneBookingFieldIsEmpty = false;

        if (!oneBookingFieldIsEmpty)
        {
            bookingView.createStatusMessage(0, false);
        }
        else //Creates reservation object & calls method in ReservationModel that insert "Reservation" object in DB
        {
            bookingView.createStatusMessage(0, reservationModel.insertReservationInDB(res));
            bookingView.overideAllToTable(reservationModel.readAllReservations());
        }
    }

    private boolean validateInput(Reservation res)
    {
        return !(res.getDate() == null || res.getCustomerName().equals("") || res.getInstructor().equals("") ||
            res.getAmountOfParticipants() == 0 || res.getActivity() == null);
    }

    public void updateBooking(Reservation reservation)
    {
        if (reservation == null) {
            bookingView.createStatusMessage(1, false);
        }else
        {
            if (validateInput(reservation))
            {
                // Updates booking to db, and creates success message
                bookingView.createStatusMessage( 1, reservationModel.updateReservation(reservation));
            }
            else
            {
                bookingView.createStatusMessage(1, false);
            }
        }

        bookingView.overideAllToTable(reservationModel.readAllReservations());
    }

    public void deleteBooking(Reservation res)
    {
        if (res == null)
            bookingView.createStatusMessage(2, false);
        else
        {
            if (validateInput(res))
            {
                //Deletes booking from DB and creates success message.
                bookingView.createStatusMessage(2, reservationModel.deleteReservation(res.getID()));
                bookingView.overideAllToTable(reservationModel.readAllReservations());
            }
        }
    }

    public ReservationModel getReservationModel()
    {
        return reservationModel;
    }

    public void setReservationModel(ReservationModel reservationModel)
    {
        this.reservationModel = reservationModel;
    }
}