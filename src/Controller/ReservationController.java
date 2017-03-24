package Controller;

import Model.Activity;
import Model.Reservation;
import Model.ReservationModel;
import View.BookingView;

/**
 * Created by JonasBak on 23-03-2017.
 */
public class ReservationController
{
    // Model
    private ReservationModel reservationModel;
    private BookingView bookingView;

    // Constructor
    public ReservationController()
    {
        reservationModel = new ReservationModel(this);
    }

    private void submitBooking(long date, int durationInMinutes, String customerName, String instructor, Activity activity)
    {
        boolean oneBookingFieldIsEmpty = true;

        if (date == 0 || durationInMinutes == 0 || customerName.equals("") || instructor.equals("") || activity == null)
            oneBookingFieldIsEmpty = false;

        if (oneBookingFieldIsEmpty)
        {
            //bookingView.createStatusMessage(0, false);
        }
        else //Creates reservation object & calls method in ReservationModel that insert "Reservation" object in DB
        {
            Reservation reservation = new Reservation(date, durationInMinutes, customerName, instructor, activity);
            reservationModel.insertReservationInDB(reservation);
            //bookingView.createStatusMessage(0, true);
        }
    }

}
