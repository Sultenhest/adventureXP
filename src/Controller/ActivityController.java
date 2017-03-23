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

    private boolean validateLimits(int ageLimit, int heightLimit)
    {
        return (ageLimit >= 0 && ageLimit <= 99 && heightLimit >= 0 && heightLimit <= 250);
    }


    // Adds a new activity to the DB and displays it in the TableView upon succesfull creation
    public void createActivity(int buttonId, String activityName, String minAge, String minHeight)
    {
        // If activityName is empty then send error message to View
        // Else check if "Age" and "Height" is within limits
        // If so, insert activity in DB and update TableView
        // If not, display error message on View
        if (activityName.equals(""))
        {
            activityView.createStatusMessage(0, false);
        }
        else
        {
            int age = Integer.parseInt(minAge);
            int height = Integer.parseInt(minHeight);

         /*   boolean ageAsInt = InputParser.parseInt(ageLimit, 0, 99);
            boolean heightAsInt = InputParser.parseInt(minHeight, 0, 250);
*/
            if (validateLimits(age, height))
            {
                Activity activity = new Activity(activityName, age, height);

                // Inserts activity to db, and creates succes message
                activityView.createStatusMessage(buttonId, activityModel.insert(activity));

                activityView.overideAllToTable(activityModel.readAll());

            }
            else
            {
                activityView.createStatusMessage(buttonId, false);
            }
        }

    }

    public void updateActivity(int id, String name, String minAge, String minHeight)
    {

        if (name.equals(""))
        {
            activityView.createStatusMessage(1, false);
        }
        else
        {
            int age = Integer.parseInt(minAge);
            int height = Integer.parseInt(minHeight);

            if (validateLimits(age, height))
            {
                Activity activity = new Activity(id, age, height, name);

                // Updates activity to db, and creates success message
                activityView.createStatusMessage( 1, activityModel.update(activity));
            }
            else
            {
                activityView.createStatusMessage(1, false);
            }
        }

        activityView.overideAllToTable(activityModel.readAll());
    }

}
