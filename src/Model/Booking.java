package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Booking
{
    private int ID;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private int amountOfParticipants;
    private String customerName;
    private String Instructor;
    private Activity activity;

    public Booking(){}

    public Booking(int ID, LocalDate date, String startTime, String endTime, String customerName, String Instructor, int amountOfParticipants, Activity activity)
    {
        this.ID = ID;
        this.endTime = endTime;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.startTime = startTime;
        this.date = date;
        this.amountOfParticipants = amountOfParticipants;
    }

    public Booking(LocalDate date, String startTime, String endTime, String customerName, String Instructor, int amountOfParticipants, Activity activity)
    {
        this.endTime = endTime;
        this.startTime = startTime;
        this.customerName = customerName;
        this.Instructor = Instructor;
        this.activity = activity;
        this.date = date;
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

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate( LocalDate date ) {
        this.date = date;
    }

    public String getDateAsString()
    {
        DateFormat dateFormat = new SimpleDateFormat("d/M/y - k:m");

        return dateFormat.format(date);
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking that = (Booking) o;

        if (getID() != that.getID()) return false;
        if (getAmountOfParticipants() != that.getAmountOfParticipants()) return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        if (getStartTime() != null ? !getStartTime().equals(that.getStartTime()) : that.getStartTime() != null)
            return false;
        if (getEndTime() != null ? !getEndTime().equals(that.getEndTime()) : that.getEndTime() != null) return false;
        if (getCustomerName() != null ? !getCustomerName().equals(that.getCustomerName()) : that.getCustomerName() != null)
            return false;
        if (getInstructor() != null ? !getInstructor().equals(that.getInstructor()) : that.getInstructor() != null)
            return false;
        return getActivity() != null ? getActivity().equals(that.getActivity()) : that.getActivity() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getID();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getStartTime() != null ? getStartTime().hashCode() : 0);
        result = 31 * result + (getEndTime() != null ? getEndTime().hashCode() : 0);
        result = 31 * result + getAmountOfParticipants();
        result = 31 * result + (getCustomerName() != null ? getCustomerName().hashCode() : 0);
        result = 31 * result + (getInstructor() != null ? getInstructor().hashCode() : 0);
        result = 31 * result + (getActivity() != null ? getActivity().hashCode() : 0);
        return result;
    }
}
