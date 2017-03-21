import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by app on 16/03/17.
 */
public class ActivityOBJTest
{
    @Test
    public void CreateActivity() throws Exception
    {
        ActivityOBJ Activity = new ActivityOBJ("SumoBrydning");
        assertEquals("SumoBrydning", Activity.getActivityName());


    }
}