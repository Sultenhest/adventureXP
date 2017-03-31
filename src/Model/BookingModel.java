package Model;

import Controller.BookingController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookingModel
{
    private static BookingModel instance = null;

    private BookingModel() {}

    public static BookingModel getInstance()
    {
        if (instance == null)
            instance = new BookingModel();

        return instance;
    }

    // Controller
    private BookingController bookingController;

    // Constructor
    public BookingModel(BookingController bookingController)
    {
        this.bookingController = bookingController;
    }

    public boolean insertBookingInDB(Booking booking)
    {
        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement())
        {
            String sql = "INSERT INTO booking (bk_act_id, bk_instructor, bk_customer, bk_date, bk_startTime, bk_endTime, bk_participants) " +
                    "VALUES (" + booking.getActivity().getID() + ", '" +
                    booking.getInstructor() + "', '" +
                    booking.getCustomerName() + "', '" +
                    booking.getDate() + "', '" +
                    booking.getEndTime() + "', '" +
                    booking.getStartTime() + "', " +
                    booking.getAmountOfParticipants() + ")";

            int rowsAffected = statement.executeUpdate(sql);

            return rowsAffected == 1;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return false;
        }
    }

    public boolean updateBooking(Booking booking)
    {
        try {
            String sql = "UPDATE booking SET bk_act_id = " + booking.getActivity().getID() +
                    ", bk_instructor = '" + booking.getInstructor() +
                    "', bk_customer = '" + booking.getCustomerName() +
                    "', bk_date = '" + booking.getDate() +
                    "', bk_startTime = '" + booking.getStartTime() +
                    "', bk_endTime = '" + booking.getEndTime() +
                    "', bk_participants = " + booking.getAmountOfParticipants() +
                    " WHERE bk_id = " + booking.getID();

            Connection connection = DatabaseConnect.getConnection();
            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(sql);

            return (rowsAffected == 1);
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return false;
        }
    }

    public Booking readBooking(int id)
    {
        try (Connection connection = DatabaseConnect.getConnection();
             Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM booking WHERE bk_id = " + id;
            ActivityModel am = ActivityModel.getInstance();

            ResultSet rs = statement.executeQuery(sql);

            return new Booking(rs.getInt("bk_id"), rs.getDate("bk_startDate").toLocalDate(),
                    rs.getString("bk_startTime"), rs.getString("bk_duration"), rs.getString("bk_customer"),
                    rs.getString("bk_instructor"), rs.getInt("bk_participants"), am.read(rs.getInt("bk_act_id")));
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return null;
        }
    }

    public ArrayList<Booking> readAllBookings()
    {
        try(Connection connection = DatabaseConnect.getConnection();
            Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM booking";
            ActivityModel am = ActivityModel.getInstance();

            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Booking> listOfBookings = new ArrayList<>();

            while (rs.next())
            {
                listOfBookings.add(new Booking(rs.getInt("bk_id"), rs.getDate("bk_date").toLocalDate(),
                        rs.getString("bk_startTime"), rs.getString("bk_endTime"), rs.getString("bk_customer"),
                        rs.getString("bk_instructor"), rs.getInt("bk_participants"), am.read(rs.getInt("bk_act_id"))));
            }

            return listOfBookings;
        }
        catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return null;
        }
    }

    public boolean deleteBooking(int id)
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
