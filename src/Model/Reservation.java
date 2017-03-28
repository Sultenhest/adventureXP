package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Reservation
{
    private int ID;
    private Date startTime;
    private int durationInMinutes;
    private int amountOfParticipants;
    private String customerName;
    private String Instructor;
    private Activity activity;
    private Date timestamp;

    public Reservation(){}

    public Reservation(int ID, long date, int durationInMinutes, String customerName, String Instructor, Activity activity, long timestamp)
    {
        this.ID = ID;
        this.durationInMinutes = durationInMinutes;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.timestamp = new Date(timestamp);
        this.startTime = new Date(date);
    }

    public Reservation(Date date, int durationInMinutes, String customerName, String Instructor, int amountOfParticipants, Activity activity)
    {
        this.durationInMinutes = durationInMinutes;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.timestamp = new Date();
        this.startTime = date;
        this.amountOfParticipants = amountOfParticipants;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public Date getStartDate()
    {
        return startTime;
    }

    public String getStartDateAsString()
    {
        DateFormat dateFormat = new SimpleDateFormat("d/M/y - k:m");


        return dateFormat.format(startTime);
    }

    public String getStartTimeAsString()
    {
        DateFormat dateFormat = new SimpleDateFormat("kk:mm");


        return dateFormat.format(startTime);
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public int getDurationInMinutes()
    {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getInstructor()
    {
        return Instructor;
    }

    public void setInstructor(String instructor)
    {
        this.Instructor = instructor;
    }

    public String getActivityName()
    {
        return activity.getActivityName();
    }

    public Activity getActivity()
    {
        return activity;
    }

    public void setActivity(Activity activity)
    {
        this.activity = activity;
    }

    public int getAmountOfParticipants()
    {
        return amountOfParticipants;
    }

    public void setAmountOfParticipants(int amountOfParticipants)
    {
        this.amountOfParticipants = amountOfParticipants;
    }
}
