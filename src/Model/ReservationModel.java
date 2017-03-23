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

    public void insertReservationInDB(Reservation reservation)
    {
        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement())
        {
            // TODO Create query to insert reservation in DB - create Reservation table first ...
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
        }
    }

}
