package bouncingballs;

import javafx.scene.paint.Color;

public class Circle {
    private float speedX;
    private float speedY;
    private double x;
    private double y;
    private int radius;
    private Color color;

    public Circle(float speedX, float speedY, double x, double y, int radius, Color color) {
        this.speedX = speedX;
        this.speedY = speedY;
        this.x = x - radius;
        this.y = y - radius;
        this.radius = radius;
        this.color = color;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "speedX=" + speedX +
                ", speedY=" + speedY +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color=" + color +
                '}';
    }
}
