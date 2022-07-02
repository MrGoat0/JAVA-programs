package model;

import java.awt.*;

public class Circle extends Figure{
    private double radio;

    public Circle(Point point, double radio) {
        super(point);
        this.radio = radio;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcPerimetro() {
        return 2 * Math.PI* radio;
    }

    @Override
    public void draw(Graphics graphics) {

    }
}
