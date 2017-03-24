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

    private boolean validateInput(Reservation res)
    {
        return !res.getCustomerName().equals("") || !res.getInstructor().equals("") || res.getActivity() != null || res.getDurationInMinutes() == 0 || res.getStartDate() != null;
    }

    public void updateActivity(Reservation reservation)
    {
        if (reservation == null)
            bookingView.createStatusMessage(1, false);
        else
        {
            if (validateInput(reservation))
            {
                // Updates booking to db, and creates success message
                bookingView.createStatusMessage( 1, reservationModel.updateReservation(reservation));
                bookingView.overideAllToTable(reservationModel.readAllReservations());
            }
            else
            {
                bookingView.createStatusMessage(1, false);
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