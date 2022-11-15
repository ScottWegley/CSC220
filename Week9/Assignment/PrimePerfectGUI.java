package Week9.Assignment;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PrimePerfectGUI extends Application {
    private TextField perfNumReq = new TextField();
    private Button getPerfNums = new Button("Get Numbers");
    private static TextArea listPerfNums = new TextArea();
    private Button loadPerf = new Button("Load");
    private Button savePerf = new Button("Save");

    private TextField primeToCheck = new TextField();
    private Label isPrimeLbl = new Label();
    private Button checkIfPrime = new Button("Is Prime?");
    private Button getPrimeFactors = new Button("Get Prime Factors");
    private TextArea listPrimeFactors = new TextArea();
    private Button loadPrime = new Button("Load");
    private Button savePrime = new Button("Save");
    private PerfectNumber perNum = new PerfectNumber();
    private PrimeNumber primNum = new PrimeNumber();

    @Override
    public void start(Stage stage) throws Exception {
        SplitPane sp = new SplitPane();
        GridPane perfPane = new GridPane();
        GridPane graphPane = new GridPane();
        GridPane primePane = new GridPane();

        perfPane.getColumnConstraints().add(new ColumnConstraints(100));

        sp.getItems().addAll(perfPane, graphPane, primePane);
        perfPane.add(new Text("Perfect Numbers"), 0, 0);
        perfPane.add(new Text("How Many"), 0, 1);
        perfPane.add(perfNumReq, 0, 2);
        perfPane.add(getPerfNums, 0, 3);
        perfPane.add(listPerfNums, 0, 4);
        perfPane.add(loadPerf, 0, 5);
        perfPane.add(savePerf, 0, 6);
        perfPane.setAlignment(Pos.CENTER);

        getPerfNums.setOnAction(e -> {
            listPerfNums.setText("");
            int i;
            Long q = 0L;
            if (validateNum(perfNumReq.getText())) {
                for (i = Integer.parseInt(perfNumReq.getText()); i > 0; i--) {
                    try {
                        MyThread mt = new MyThread();
                        MyThread.setP(q);
                        mt.start();
                        mt.join();
                        q = MyThread._p;
                        listPerfNums.appendText(Long.toString(q) + "\n");
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });

        checkIfPrime.setOnAction(e -> {
            if (validateNum(primeToCheck.getText())) {
                isPrimeLbl.setText(((primNum.isPrime(Long.parseLong(primeToCheck.getText())))
                        ? primeToCheck.getText() + " is prime"
                        : primeToCheck.getText() + " is not prime"));
            }
        });

        getPrimeFactors.setOnAction(e -> {
            listPrimeFactors.setText("");
            if (validateNum(primeToCheck.getText())) {
                long[] x = primNum.primeFactors(Long.parseLong(primeToCheck.getText()));
                for (int i = 0; i < x.length; i++) {
                    listPrimeFactors.appendText(Long.toString(x[i]) + '\n');
                }
            }
        });

        primePane.getColumnConstraints().add(new ColumnConstraints(120));

        primePane.add(new Text("Prime Numbers"), 0, 0);
        primePane.add(primeToCheck, 0, 1);
        primePane.add(isPrimeLbl, 0, 2);
        primePane.add(checkIfPrime, 0, 3);
        primePane.add(getPrimeFactors, 0, 4);
        primePane.add(listPrimeFactors, 0, 5);
        primePane.add(loadPrime, 0, 6);
        primePane.add(savePrime, 0, 7);
        primePane.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(sp, Color.GREEN));
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.setTitle("Prime/Perfect Number GUI");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean validateNum(String input) {
        try {
            int i = Integer.parseInt(input);
            if (i <= 0) {
                throw new NumberFormatException();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
