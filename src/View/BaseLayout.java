package View;

import javafx.scene.layout.Pane;

public interface BaseLayout
{
    void createLayout();
    void createLayoutSettings();
    Pane getLayout();
    void attachLayoutToScene();
}
