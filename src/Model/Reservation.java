package Model;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Reservation
{
    private Date startTime;
    private int durationInMinutes;
    private int amountOfParticipants;
    private String customerName;
    private String Instructor;
    private Activity activity;
    private Date timestamp;

    public Reservation(){}

    public Reservation(long date, int durationInMinutes, String customerName, String Instructor, Activity activity, long timestamp)
    {
        this.durationInMinutes = durationInMinutes;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.timestamp = new Date(timestamp);
        this.startTime = new Date(date);
    }

    public Reservation(long date, int durationInMinutes, String customerName, String Instructor, Activity activity)
    {
        this.durationInMinutes = durationInMinutes;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.timestamp = new Date();
        this.startTime = new Date(date);
    }

    public Date getStartDate()
    {
        return startTime;
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
