/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Activity
{
    private int ID;
    private int ageLimit;
    private int heightLimit;
    private String activityName;
    private String activityInfo;

    public Activity(int ID, int ageLimit, String activityName, String activityInfo)
    {
        this.ID = ID;
        this.ageLimit = ageLimit;
        this.activityName = activityName;
        this.activityInfo = activityInfo;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getAgeLimit()
    {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit)
    {
        this.ageLimit = ageLimit;
    }

    public int getHeightLimit()
    {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit)
    {
        this.heightLimit = heightLimit;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getActivityInfo()
    {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo)
    {
        this.activityInfo = activityInfo;
    }
}
