package Week8.Assignment;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Pong extends Application {

    private static final int width = 800; // App width
    private static final int height = 600; // App height
    private int score1 = 0; // Scores
    private int score2 = 0;
    private boolean gStarted = false; // Game State
    Ball ball1 = new Ball(width, height);
    Player player1 = new Player(height);
    Player player2 = new Player(height);

    @Override
    public void start(Stage stage) throws Exception {
        player2.xPos = width - 15;
        stage.setTitle("Pong");
        Canvas canvas = new Canvas(width, height);
        Timeline t1 = new Timeline(new KeyFrame(Duration.millis(10), e -> run(canvas.getGraphicsContext2D())));
        t1.setCycleCount(-1);
        canvas.setOnMouseClicked(e -> {
            gStarted = true;
        });
        canvas.setOnMouseMoved(e -> {
            player2.yPos = e.getY();
        });
        Pane pane = new StackPane(canvas);
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    moveUp();
                    break;
                case DOWN:
                    moveDown();
                    break;
                default: 
                    break;
            }
        });
        stage.setScene(new Scene(pane));
        stage.show();
        pane.requestFocus();
        t1.play();
    }

    private void moveDown() {
        if (player1.yPos < height - 100) {
            player1.yPos += 20;
        } else {
            player1.yPos += (height - 100) - player1.yPos;
        }
    }

    private void moveUp() {
        if (player1.yPos >= 20) {
            player1.yPos -= 20;
        } else {
            player1.yPos -= player1.yPos;
        }
    }

    private void run(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        if (gStarted) {
            ball1.xPos += ball1.dX;
            ball1.yPos += ball1.dY;

            gc.fillOval(ball1.xPos, ball1.yPos, ball1.radius, ball1.radius);
        } else {
            ball1.xPos = width / 2;
            ball1.yPos = height / 2;
            ball1.dX = new Random().nextBoolean() ? 1 : -1;
            ball1.dY = new Random().nextBoolean() ? 1 : -1;
        }

        if (!(ball1.yPos <= height - ball1.radius && ball1.yPos >= 0)) {
            ball1.dY *= -1;
        }

        if(ball1.xPos < player1.xPos-15) {
            score2++;
            gStarted = false;
        }

        if(ball1.xPos > player2.xPos+15) {
            score1++;
            gStarted = false;
        }

        if((ball1.xPos + ball1.radius > player2.xPos && ball1.yPos >= player2.yPos && ball1.yPos <=player2.yPos + 100) ||
            (ball1.xPos < player1.xPos + 15 && ball1.yPos >= player1.yPos && ball1.yPos <= player1.yPos + 100)){
                ball1.dX += (.1 * Math.signum(ball1.dX));
                ball1.dY += (.1 * Math.signum(ball1.dY));
                ball1.dX *= -1;
                ball1.dY *= -1;
        }

        gc.fillText(String.valueOf(score1) + ":" + String.valueOf(score2), width / 2, 100);

        gc.fillRect(player1.xPos, player1.yPos, 15, 100);
        gc.fillRect(player2.xPos, player2.yPos, 15, 100);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

class Ball {
    double dX = 1;
    double dY = 1;
    final int radius = 25;
    int xPos;
    int yPos;

    Ball(int w, int h) {
        xPos = w / 2;
        yPos = h / 2;
    }
}

class Player {
    double xPos;
    double yPos;

    Player(int h) {
        yPos = h / 2;
    }

}