package Controller;

public class InputParser
{
    public static boolean parseInt(String text, int min, int max)
    {
        try
        {
            int returnInt = Integer.parseInt(text);

            if (returnInt > min && returnInt < max)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        catch ( NumberFormatException ex)
        {
            return false;
        }

    }
}
