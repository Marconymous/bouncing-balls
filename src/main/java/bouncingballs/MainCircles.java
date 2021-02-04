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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainCircles extends Application {

    private Canvas canvas = new Canvas();
    private LogicHandler logic = new LogicHandler(canvas);
    private final VBox root = new VBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), kv -> {
            logic.drawCircles();
        }));
        animation.setCycleCount(Animation.INDEFINITE);

        animation.play();

        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            updateCanvasSize("width", newVal);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            updateCanvasSize("height", newVal);
        });

        primaryStage.setTitle("DVD Logo");
        primaryStage.getIcons().add(new Image(("file:icon.png")));
        primaryStage.setIconified(true);
        primaryStage.show();
    }

    void updateCanvasSize(String change, Number newVal) {
        switch (change) {
            case "height":
                canvas = new Canvas(canvas.getWidth(), newVal.doubleValue());
                break;

            case "width":
                canvas = new Canvas(newVal.doubleValue(), canvas.getHeight());
                break;
        }
        logic.changeSize(canvas);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            for (int i = 0; i < (int) (Math.random() * 25); i++) {
                logic.generateCircle(t.getX(), t.getY());
            }
        });
        root.getChildren().remove(0, 1);
        root.getChildren().add(canvas);
    }
}
