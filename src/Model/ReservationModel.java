package Model;

import Controller.ReservationController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
            // TODO Create query to insert reservation in DB - create Reservation table first ...

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
            String sql = "UPDATE activity SET act_name = '" + booking.getActivityName() +
                    "', act_min_age = " + booking.getAgeLimit() +
                    ", act_min_height = " + booking.getHeightLimit() +
                    " WHERE act_id = " + booking.getID();

            return true;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return false;
        }
    }

}
