package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class BaseModal
{
    private String[] output;
    private Stage window = new Stage();
    private VBox layout = new VBox(10);
    private GridPane grid = new GridPane();
    private Button closeButton = new Button("Annuller");
    private Button submitButton = new Button();

    public String[] display( String title, String message, String[] input) {
        window.setTitle( title );
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label messageLabel = new Label( message );

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        submitButton.setText(title);
        submitButton.setOnAction(event ->
        {
            submitButtonClicked();
        });

        closeButton.setOnAction(
                e-> window.close()
        );

        HBox bottom = new HBox(10, submitButton, closeButton);

        layout.getChildren().addAll(messageLabel, grid, bottom);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return output;
    }

    public void submitButtonClicked()
    {

    }

    public String[] getOutput()
    {
        return output;
    }

    public Button getSubmitButton()
    {
        return submitButton;
    }

    public void setOutputSize(int size)
    {
        output = new String[size];
    }

    public Stage getWindow()
    {
        return window;
    }
}
