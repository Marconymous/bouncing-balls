package bouncingballs;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static javafx.scene.paint.Color.*;

public class LogicHandler {
    private Canvas canvas;
    GraphicsContext gc;
    ArrayList<Circle> circles = new ArrayList<>();

    public LogicHandler(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }

    public void changeSize(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        for (Circle c : circles) {
            c.setX(canvas.getWidth() / 2 - c.getRadius());
            c.setY(canvas.getHeight() / 2 - c.getRadius());
        }
    }

    void generateCircle(double x, double y) {
        float speedX = (float) (Math.random() * 2 - 1);
        float speedY = (float) (Math.random() * 2 - 1);
        int size;
        do {
            size = (int) (Math.random() * 50);
        } while (size < 10);
        Color randColor = getRandColor();

        circles.add(new Circle(speedX, speedY, x, y, size, randColor));
    }

    void drawCircles() {
        gc.setFill(BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Circle c : circles) {
            move(c);
            gc.setFill(c.getColor());
            gc.fillOval(c.getX(), c.getY(), c.getRadius() * 2, c.getRadius() * 2);
        }
    }

    void move(Circle c) {
        if (c.getX() + c.getRadius() * 2 + 15 >= canvas.getWidth()) {
            c.setSpeedX(c.getSpeedX() - 2 * c.getSpeedX());
        }

        if (c.getX() <= 0) {
            c.setSpeedX(c.getSpeedX() - 2 * c.getSpeedX());
        }

        if (c.getY() + c.getRadius() * 2 + 38 >= canvas.getHeight()) {
            c.setSpeedY(c.getSpeedY() - 2 * c.getSpeedY());
        }

        if (c.getY() <= 0) {
            c.setSpeedY(c.getSpeedY() - 2 * c.getSpeedY());
        }
        c.setX(c.getX() + c.getSpeedX());
        c.setY(c.getY() + c.getSpeedY());
    }

    Color getRandColor() {
        double r = Math.random();
        double g = Math.random();
        double b = Math.random();
        return new Color(r, g, b, 1);
    }
}
