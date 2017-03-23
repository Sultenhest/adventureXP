package Controller;

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

    private void submitBooking(int startTime, int stopTime, String customerName, String employeeName)
    {
        boolean startTimeEmpty = false;
        boolean stopTimeEmpty = false;
        boolean custNameEmpty = false;
        boolean empNameEmpty = false;

        boolean oneBookingFieldIsEmpty = startTimeEmpty || stopTimeEmpty || custNameEmpty || empNameEmpty;

        if (startTime == 0)
        {
            startTimeEmpty = true;
        }

        if (stopTime == 0)
        {
            stopTimeEmpty = true;
        }

        if (customerName.equals(""))
        {
            custNameEmpty = true;
        }

        if (employeeName.equals(""))
        {
            empNameEmpty = true;
        }

        if (oneBookingFieldIsEmpty)
        {
            // Send/Set error message to View
        }
        else
        {
            // Create reservation object
            // Call method in ReservationModel that insert "Reservation" object in DB
            Reservation reservation = new Reservation(startTime, stopTime, customerName, employeeName);
            reservationModel.insertReservationInDB(reservation);
        }


    }

}
