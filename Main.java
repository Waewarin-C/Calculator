import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Gets the stage ready and launches the calculator application
 *
 * @author Waewarin Chindarassami
 */
public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage)
    {
        stage = primaryStage;

        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
            root.getStylesheets().add(getClass().getResource("layout.css").toExternalForm());
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
