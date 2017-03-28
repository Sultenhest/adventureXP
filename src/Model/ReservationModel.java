package Model;

import Controller.ReservationController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
                    "VALUES (" + reservation.getActivity().getID() + ", '" +
                    reservation.getInstructor() + "', '" +
                    reservation.getCustomerName() + "', " +
                    reservation.getStartDate() + ", " +
                    reservation.getDurationInMinutes() + ", " +
                    reservation.getAmountOfParticipants() + ", " +
                    new Date();

            int rowsAffected = statement.executeUpdate(sql);

            return rowsAffected == 1;
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
             Statement statement = connection.createStatement())
        {
            String sql = "UPDATE booking SET bk_act_id = " + reservation.getActivity().getID() +
                    ", bk_instructor = '" + reservation.getInstructor() +
                    "', bk_customer = '" + reservation.getCustomerName() +
                    "', bk_startDate = " + reservation.getStartDate() +
                    ", bk_duration = " + reservation.getDurationInMinutes() +
                    ", bk_participants = " + reservation.getAmountOfParticipants() +
                    ", bk_timestamp = " + new Date();

            int rowsAffected = statement.executeUpdate(sql);

            return rowsAffected == 1;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return false;
        }
    }

    public Reservation readReservation(int id)
    {
        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM booking WHERE bk_id = " + id;
            ActivityModel am = ActivityModel.getInstance();

            ResultSet rs = statement.executeQuery(sql);

            return new Reservation(rs.getInt("bk_id"), rs.getLong(5), rs.getInt(6), rs.getString(4), rs.getString(3), am.read(rs.getInt(1)), rs.getLong(8));
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return null;
        }
    }

    public ArrayList<Reservation> readAllReservations()
    {
        try(Connection connection = DatabaseConnect.getConnection();
            Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM booking";
            ActivityModel am = ActivityModel.getInstance();

            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Reservation> listOfReservations = new ArrayList<>();

            while (rs.next())
            {
                listOfReservations.add(new Reservation(rs.getInt("bk_id"), rs.getLong(5), rs.getInt(6), rs.getString(4), rs.getString(3), am.read(rs.getInt(1)), rs.getLong(8)));
            }

            return listOfReservations;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return null;
        }
    }

    public boolean deleteReservation(int id)
    {
        try (Connection connection = DatabaseConnect.getConnection();
            Statement statement = connection.createStatement())
        {
            String sql = "DELETE FROM booking WHERE bk_id = " + id;
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
