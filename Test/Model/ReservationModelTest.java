package Model;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

//
//Created by DaMasterHam on 28-03-2017.
//
public class ReservationModelTest
{
    private void setupDB()
    {
        // Change the credentials to your local db's credentials to test locally
        DatabaseConnect.setDbName("adventure_xp");
        DatabaseConnect.setUser("root");
        DatabaseConnect.setPass("pass1234");
        DatabaseConnect.setPort("4200");
    }


    @Test
    public void ReservationCRUD() throws Exception
    {
        setupDB();

        boolean success = InsertReservation();

    }

    @Test
    public void ReadReservation() throws Exception
    {
        setupDB();

        //insert into booking values(1, 1, 'Test_Ins', 'Test_cust', now(), now(), 123, 10, now());

        Reservation resDb = ReservationModel.getInstance().readReservation(1);

        //assertEquals(res,);
    }


    public boolean InsertReservation()
    {

        Date date = new Date();

         Activity activity = ActivityModel.getInstance().read(1);

        return ReservationModel.getInstance().insertReservationInDB(
                new Reservation(99, date, 30, 12, "Test_Customer", "Test_Instructor", activity, date));
    }

    public boolean UpdateReservation() throws Exception
    {
        Date date = new Date();

        Activity activity = ActivityModel.getInstance().read(2);

        return ReservationModel.getInstance().updateReservation(
                new Reservation(99, date, 31, 13, "Test_Customer_UP", "Test_Instructor_UP", activity, date));
    }

    @Test
    public void DeleteReservation() throws Exception
    {

    }
}