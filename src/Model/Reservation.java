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

    public Reservation(int ID, long date, int durationInMinutes, String customerName, String Instructor, int amountOfParticipants, Activity activity, long timestamp)
    {
        this.ID = ID;
        this.durationInMinutes = durationInMinutes;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.timestamp = new Date(timestamp);
        this.startTime = new Date(date);
        this.amountOfParticipants = amountOfParticipants;
    }

    public Reservation(int ID, Date date, int durationInMinutes, int amountOfParticipants, String customerName, String Instructor, Activity activity, Date timestamp)
    {
        this.ID = ID;
        this.durationInMinutes = durationInMinutes;
        this.amountOfParticipants = amountOfParticipants;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.timestamp = timestamp;
        this.startTime = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (getID() != that.getID()) return false;
        if (getDurationInMinutes() != that.getDurationInMinutes()) return false;
        if (getAmountOfParticipants() != that.getAmountOfParticipants()) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (getCustomerName() != null ? !getCustomerName().equals(that.getCustomerName()) : that.getCustomerName() != null)
            return false;
        if (getInstructor() != null ? !getInstructor().equals(that.getInstructor()) : that.getInstructor() != null)
            return false;
        if (getActivity() != null ? !getActivity().equals(that.getActivity()) : that.getActivity() != null)
            return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = getID();
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + getDurationInMinutes();
        result = 31 * result + getAmountOfParticipants();
        result = 31 * result + (getCustomerName() != null ? getCustomerName().hashCode() : 0);
        result = 31 * result + (getInstructor() != null ? getInstructor().hashCode() : 0);
        result = 31 * result + (getActivity() != null ? getActivity().hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
