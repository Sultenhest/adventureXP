package Controller;

import Model.Activity;
import Model.ActivityModel;
import View.ActivityView;

/**
 * Created by JonasBak on 17-03-2017.
 */
public class ActivityController
{
    // Fields
    private ActivityView activityView;
    private ActivityModel activityModel = ActivityModel.getInstance();

    // Constructors
    public ActivityController(ActivityView activityView)
    {
        // View
        this.activityView = activityView;
        this.activityView.overideAllToTable(activityModel.readAll());

    }

    // Adds a new activity to the DB and displays it in the TableView upon succesfull creation
    public void createActivity(int buttonId, String activityName, String ageLimit, String minHeight)
    {
        // If activityName is empty then send error message to View
        // Else check if "Age" and "Height" is within limits
        // If so, insert activity in DB and update TableView
        // If not, display error message on View
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

                activityView.createStatusMessage(buttonId, activityModel.insert(activity));

                activityView.overideAllToTable(activityModel.readAll());

            }
            else
            {
                activityView.createStatusMessage(buttonId, false);
            }
        }

    }

    public void updateActivity(Activity activity)
    {
        activityModel.update(activity);
        activityView.overideAllToTable(activityModel.readAll());
    }

}
