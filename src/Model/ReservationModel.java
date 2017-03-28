package Model;

import Controller.ReservationController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ReservationModel
{
    private static ReservationModel instance = null;

    private ReservationModel() {}

    public static ReservationModel getInstance()
    {
        if (instance == null)
            instance = new ReservationModel();

        return instance;
    }

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
            String sql = "INSERT INTO booking (bk_act_id, bk_instructor, bk_customer, bk_date, bk_startTime, bk_endTime, bk_participants) " +
                    "VALUES (" + reservation.getActivity().getID() + ", '" +
                    reservation.getInstructor() + "', '" +
                    reservation.getCustomerName() + "', " +
                    reservation.getDate() + ", " +
                    reservation.getEndTime() + ", " +
                    reservation.getStartTime() + ", " +
                    reservation.getAmountOfParticipants() + ")";

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
                    "', bk_date = '" + reservation.getDate() +
                    "', bk_startTime = " + reservation.getStartTime() +
                    ", bk_endTime = " + reservation.getEndTime() +
                    ", bk_participants = " + reservation.getAmountOfParticipants();
            System.out.println(sql);

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

            return new Reservation(rs.getInt("bk_id"), rs.getDate("bk_startDate").toLocalDate(),
                    rs.getString("bk_startTime"), rs.getString("bk_duration"), rs.getString("bk_customer"),
                    rs.getString("bk_instructor"), rs.getInt("bk_participants"), am.read(rs.getInt("bk_act_id")));
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
                listOfReservations.add(new Reservation(rs.getInt("bk_id"), rs.getDate("bk_startDate").toLocalDate(),
                        rs.getString("bk_startTime"), rs.getString("bk_duration"), rs.getString("bk_customer"),
                        rs.getString("bk_instructor"), rs.getInt("bk_participants"), am.read(rs.getInt("bk_act_id"))));
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
