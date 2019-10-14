import javafx.application.Application;
import javafx.stage.Stage;
import core.Lobby;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new Lobby();
    }
}
