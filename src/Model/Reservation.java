package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Reservation
{
    private int ID;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private int amountOfParticipants;
    private String customerName;
    private String Instructor;
    private Activity activity;

    public Reservation(){}

    public Reservation(int ID, LocalDate date, String startTime, String endTime, String customerName, String Instructor, int amountOfParticipants, Activity activity)
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

    public Reservation(LocalDate date, String startTime, String endTime, String customerName, String Instructor, int amountOfParticipants, Activity activity)
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
