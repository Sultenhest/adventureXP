package Controller;

import Model.Activity;
import View.ActivityView;

/**
 * Created by JonasBak on 17-03-2017.
 */
public class ActivityController
{
    // Fields
    private ActivityView activityView;

    // Constructors
    public ActivityController(ActivityView activityView)
    {
        // View
        this.activityView = activityView;

    }

    // Adds a new activity to the DB and displays it in the TableView upon succesfull creation
    public void createActivity(int buttonId, String activityName, String ageLimit, String minHeight)
    {
        if (activityName.equals(""))
        {
            activityView.createStatusMessage(buttonId, false);
        }
        else
        {
            boolean ageAsInt = InputParser.parseInt(ageLimit, 0, 99);
            boolean heightAsInt = InputParser.parseInt(minHeight, 0, 250);

            if ( ageAsInt && heightAsInt)
            {
                int age = Integer.parseInt(ageLimit);
                int height = Integer.parseInt(minHeight);

                Activity activity = new Activity(activityName, age, height);

                activityView.createStatusMessage(buttonId, activity.save());

            }
            else
            {
                activityView.createStatusMessage(buttonId, false);
            }
        }


    }

}
