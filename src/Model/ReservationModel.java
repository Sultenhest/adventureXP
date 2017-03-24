package Model;

import Controller.ReservationController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by JonasBak on 23-03-2017.
 */
public class ReservationModel
{
    // Controller
    private ReservationController reservationController;

    // Constructor
    public ReservationModel(ReservationController reservationController)
    {
        this.reservationController = reservationController;
    }

    public boolean insertReservationInDB(Reservation reservation)
    {
        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement())
        {
            String sql = "INSERT INTO booking (bk_act_id, bk_instructor, bk_customer, bk_startDate, bk_duration, bk_participants, bk_timestamp) " +
                    "VALUES ('" + reservation.getActivity().getID() + ", " +  reservation.getInstructor() + ", " + reservation.getCustomerName() + ", " +
                    reservation.getStartDate() + ", " + reservation

            return true;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return false;
        }
    }

    public boolean updateReservation(Reservation reservation)
    {
        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement();)
        {
            String sql = "UPDATE booking SET bk_act_id = " + reservation.getActivity().getID() +
                    ", bk_instructor = '" + reservation.getInstructor() +
                    "', bk_customer = '" + reservation.getCustomerName() +
                    "', bk_startDate = " + reservation.getStartDate() +
                    ", bk_duration = " + reservation.getDurationInMinutes() +
                    ", bk_participants = " + reservation.getAmountOfParticipants() +
                    ", bk_timestamp = " + new Date(System.currentTimeMillis());

            int rowsAffected = statement.executeUpdate(sql);

            return rowsAffected == 1;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return false;
        }
    }

}
