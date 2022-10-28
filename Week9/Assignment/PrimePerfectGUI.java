package Week9.Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimePerfectGUI extends Application {
    private TextField perfNumReq = new TextField();
    private Button getPerfNums = new Button("Get Numbers");
    private TextArea listPerfNums = new TextArea();
    private Button loadPerf = new Button("Load");
    private Button savePerf = new Button("Save");

    private TextField primeToCheck = new TextField();
    private Label isPrimeLbl = new Label();
    private Button checkIfPrime = new Button();
    private Button getPrimeFactors = new Button();
    private TextArea listPrimeFactors = new TextArea();
    private Button loadPrime = new Button();
    private Button savePrime = new Button();

    @Override
    public void start(Stage stage) throws Exception {
        SplitPane sp = new SplitPane();
        GridPane perfPane = new GridPane();
        GridPane graphPane = new GridPane();
        GridPane primePane = new GridPane();

        perfPane.setHgap(5);
        perfPane.setVgap(5);
        perfPane.add(new Label("Perfect"), 0, 0);
        perfPane.add(new Label("How Many"), 0, 1);
        primePane.getChildren().addAll(primeToCheck, isPrimeLbl, checkIfPrime, getPrimeFactors, listPrimeFactors,
                loadPrime, savePrime);

        sp.getItems().addAll(perfPane, graphPane, primePane);

        Scene scene = new Scene(sp, 800, 600);
        stage.setTitle("Prime Perfect GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
