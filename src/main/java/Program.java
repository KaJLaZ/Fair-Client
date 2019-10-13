import javafx.application.Application;
import javafx.stage.Stage;
import minigames.loby.Loby;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Loby();
    }
}
