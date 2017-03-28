package Controller;

import Model.Activity;
import Model.ActivityModel;
import Model.Reservation;
import Model.ReservationModel;
import View.BookingView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void submitBooking(String[] informations)
    {
        boolean oneBookingFieldIsEmpty = true;
        Date date = splitTheDate(informations[3]);

        if (date == null || Integer.parseInt(informations[5]) == 0 || informations[2].equals("") || informations[1].equals("") || informations[0] == "")
            oneBookingFieldIsEmpty = false;

        if (!oneBookingFieldIsEmpty)
        {
            bookingView.createStatusMessage(0, false);
        }
        else //Creates reservation object & calls method in ReservationModel that insert "Reservation" object in DB
        {
            int actID = Integer.parseInt(informations[0].substring(0, informations[0].indexOf(":")));
            Activity act = ActivityModel.getInstance().read(actID);

            Reservation reservation = new Reservation(date, Integer.parseInt(informations[5]), informations[2], informations[1], Integer.parseInt(informations[6]), act);
            bookingView.createStatusMessage(0, reservationModel.insertReservationInDB(reservation));
            bookingView.overideAllToTable(reservationModel.readAllReservations());
        }
    }

    private boolean validateInput(Reservation res)
    {
        return !res.getCustomerName().equals("") || !res.getInstructor().equals("") || res.getActivity() != null || res.getDurationInMinutes() == 0 || res.getStartDate() != null;
    }

    public void updateBooking(Reservation reservation)
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

    private Date splitTheDate(String s)
    {
        String[] stringDate = s.split("-");

        if (stringDate[1].length() != 2)
            stringDate[1] = "0" + stringDate[1];

        if (stringDate[2].length() != 2)
            stringDate[2] = "0" + stringDate[2];

        s = stringDate[0] + "/" + stringDate[1] + "/" + stringDate[2];

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
        try
        {
            date = dateFormat.parse(s);
        }
        catch (ParseException pEx)
        {
            pEx.printStackTrace();
        }

        return date;
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