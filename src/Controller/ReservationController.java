package Controller;

import Model.Activity;
import Model.Reservation;
import Model.ReservationModel;

/**
 * Created by JonasBak on 23-03-2017.
 */
public class ReservationController
{
    // Model
    private ReservationModel reservationModel;

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
            // Send/Set error message to View
        }
        else //Creates reservation object & calls method in ReservationModel that insert "Reservation" object in DB
        {
            Reservation reservation = new Reservation(date, durationInMinutes, customerName, instructor, activity);
            reservationModel.insertReservationInDB(reservation);
        }


    }

}
