package Controller;

import Model.Activity;

import static org.junit.Assert.*;

/**
 * Created by Andreas on 17-03-2017.
 */
public class ActivityViewControllerTest
{
    public void createActivityTest()
    {
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertFalse(activity == null);
    }

    public void saveActivity()
    {

    }
}