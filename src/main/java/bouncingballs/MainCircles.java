package bouncingballs;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainCircles extends Application {

    private Canvas canvas = new Canvas(1000, 1000);
    private LogicHandler logic = new LogicHandler(canvas);
    private final BorderPane root = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            for (int i = 0; i < 10; i++) {
                logic.generateCircle(t.getX(), t.getY());
            }
        });

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), kv -> {
            logic.drawCircles();
        }));
        animation.setCycleCount(Animation.INDEFINITE);

        animation.play();

        root.setCenter(canvas);

        Scene scene = new Scene(root, 1000, 1000);
        primaryStage.setScene(scene);

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            updateCanvasSize("width", newVal);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            updateCanvasSize("height", newVal);
        });

        primaryStage.setTitle("DVD Logo");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    void updateCanvasSize(String change, Number newVal) {
        switch (change) {
            case "height":
                canvas = new Canvas(newVal.doubleValue(), canvas.getHeight());
                break;

            case "width":
                canvas = new Canvas(canvas.getWidth(), newVal.doubleValue());
                break;
        }
        logic = new LogicHandler(canvas);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            for (int i = 0; i < 10; i++) {
                logic.generateCircle(t.getX(), t.getY());
            }
        });
        root.setCenter(canvas);
    }
}
