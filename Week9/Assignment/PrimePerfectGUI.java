package Week9.Assignment;

import javafx.application.Application;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimePerfectGUI extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        SplitPane sp = new SplitPane();
        StackPane perfPane = new StackPane();
        StackPane graphPane = new StackPane();
        StackPane primePane = new StackPane();

        sp.getItems().addAll(perfPane, graphPane, primePane);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
