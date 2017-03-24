package Controller;

import Model.Activity;
import Model.Reservation;
import Model.ReservationModel;
import View.BookingView;

import java.util.Date;

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

    public void submitBooking(Date date, String durationInMinutes, String customerName, String instructor, Activity activity)
    {
        boolean oneBookingFieldIsEmpty = true;

        if (date == null || Integer.parseInt(durationInMinutes) == 0 || customerName.equals("") || instructor.equals("") || activity == null)
            oneBookingFieldIsEmpty = false;

        if (oneBookingFieldIsEmpty)
        {
            bookingView.createStatusMessage(0, false);
        }
        else //Creates reservation object & calls method in ReservationModel that insert "Reservation" object in DB
        {
            Reservation reservation = new Reservation(date, Integer.parseInt(durationInMinutes), customerName, instructor, activity);
            reservationModel.insertReservationInDB(reservation);
            bookingView.createStatusMessage(0, true);
        }
    }

    private boolean validateInput()
    {

        return
    }

    public void updateActivity(Reservation reservation)
    {

        if ()
            bookingView.createStatusMessage(1, false);
        else
        {
            int age = Integer.parseInt();
            int height = Integer.parseInt();

            if (validateInput())
            {
                Reservation reservation = new Reservation()

                // Updates activity to db, and creates success message
                bookingView.createStatusMessage( 1, reservationModel.updateReservation(reservation));
            }
            else
            {
                bookingView.createStatusMessage(1, false);
            }
        }

        bookingView.overideAllToTable(reservationModel.readAllReservations());
    }

}
