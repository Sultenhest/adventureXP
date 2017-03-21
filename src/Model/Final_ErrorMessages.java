package Model;

/**
 * Created by Christian on 21-03-2017.
 */
public class Final_ErrorMessages
{
    private static Final_ErrorMessages instance = new Final_ErrorMessages();

    /*
        Error Messages

        Syntax:
        (View Name)_(Action)_(Succesfull / Unsuccesfull)
     */

    private final String ACTIVITY_CREATED_SUCCESFULL = "Succes - Ny aktivitet er skabt";
    private final String ACTIVITY_CREATED_UNSUCCESFULL = "Fejl - Ny aktivitet er ikke Skabt";
    private final String ACTIVITY_UPDATED_SUCCESFULL = "Succes - Opdateret tabel";
    private final String ACTIVITY_UPDATED_UNSUCCESFULL = "Fejl - Fik ikke opdateret tabel";
    private final String ACTIVITY_EDIT_SUCCESFULL = "Succes - Aktivitet er ændret";
    private final String ACTIVITY_EDIT_UNSUCCESFULL = "Fejl - Aktivitet blev ikke ændret";
    private final String ACTIVITY_DELETE_SUCCESFULL = "Succes - Slettet aktivitet";
    private final String ACTIVITY_DELETE_UNSUCCESFULL = "Fejl - Fik ikke slettet aktivitet";

    public static Final_ErrorMessages getInstance()
    {
        return instance;
    }

    private Final_ErrorMessages()
    {
    }

    public String getACTIVITY_CREATED_SUCCESFULL()
    {
        return ACTIVITY_CREATED_SUCCESFULL;
    }

    public String getACTIVITY_CREATED_UNSUCCESFULL()
    {
        return ACTIVITY_CREATED_UNSUCCESFULL;
    }

    public String getACTIVITY_UPDATED_SUCCESFULL()
    {
        return ACTIVITY_UPDATED_SUCCESFULL;
    }

    public String getACTIVITY_UPDATED_UNSUCCESFULL()
    {
        return ACTIVITY_UPDATED_UNSUCCESFULL;
    }

    public String getACTIVITY_EDIT_SUCCESFULL()
    {
        return ACTIVITY_EDIT_SUCCESFULL;
    }

    public String getACTIVITY_EDIT_UNSUCCESFULL()
    {
        return ACTIVITY_EDIT_UNSUCCESFULL;
    }

    public String getACTIVITY_DELETE_SUCCESFULL()
    {
        return ACTIVITY_DELETE_SUCCESFULL;
    }

    public String getACTIVITY_DELETE_UNSUCCESFULL()
    {
        return ACTIVITY_DELETE_UNSUCCESFULL;
    }
}
