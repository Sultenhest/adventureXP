package Controller;

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
    public void addActivity(String... parameters)
    {
        // Boolean flag to check if either of the Strings coming from the ActivityView is empty
        // If either of them are, then send error message to user that information is missing
        boolean emptyTextFields = false;

        // Runs through the parameters coming from the AcitivtyView and checks whether one or more of them is empty
        for (String parameter : parameters)
        {
            if (parameter.equals(""))
            {
                emptyTextFields = true;
                // a "break" keyword here??
            }
        }

        // If either of the parameters is empty then send an error message to the user
        if (emptyTextFields)
        {
            // TODO call a method in the View that sets an error message on the ActivityView
        }
        else
        {
            // TODO call method in model that would add the activity to the DB
        }


    }

    public void doSHit()
    {
        activityView.createStatusMessage(0, true);
    }

    public void doSHit2()
    {
        activityView.createStatusMessage(0, false);
    }

}
