/**
 * Created by app on 16/03/17.
 */
public class ActivityOBJ
{
    String name; //type

    int minHeight;
    int minAge;
    int numberOfEquipment;

    String Description;     // her kunne tidsbegrænsning skrives ind som start
                            //tidsinterval? eller begrænsning


    public ActivityOBJ(String name) {
        this.name = name;
    }

    public String getActivityName()
    {
        return name;
    }

    public void setActivityName(String name)
    {
        this.name = name;
    }

    public int getMinHeight()
    {
        return minHeight;
    }

    public void setMinHeight(int minHeight)
    {
        this.minHeight = minHeight;
    }

    public int getMinAge()
    {
        return minAge;
    }

    public void setMinAge(int minAge)
    {
        this.minAge = minAge;
    }

    public int getNumberOfEquipment()
    {
        return numberOfEquipment;
    }

    public void setNumberOfEquipment(int numberOfEquipment)
    {
        this.numberOfEquipment = numberOfEquipment;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String description)
    {
        Description = description;
    }

}
