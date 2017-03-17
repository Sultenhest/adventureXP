package Model;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Reservation
{
    private int startTime;
    private int stopTime;
    private String customerName;
    private String employeeName;
    private Activity activity;

    public Reservation(int startTime, int stopTime, String customerName, String employeeName, String activityName)
    {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.customerName = customerName;
        this.employeeName = employeeName;
        //this.activity = new Model.Activity();
    }

    public int getStartTime()
    {
        return startTime;
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }

    public int getStopTime()
    {
        return stopTime;
    }

    public void setStopTime(int stopTime)
    {
        this.stopTime = stopTime;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public Activity getActivity()
    {
        return activity;
    }

    public void setActivity(Activity activity)
    {
        this.activity = activity;
    }
}
