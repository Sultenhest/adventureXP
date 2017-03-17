package View;

import javafx.scene.layout.Pane;

/**
 * Created by Christian and Sose on 16-03-2017.
 */
public interface BaseLayout
{
    void createLayout();
    void createLayoutSettings();
    Pane getLayout();
    void attachLayoutToScene();
}
