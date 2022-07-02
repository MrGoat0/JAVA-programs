package model;

import java.awt.*;

public class Triangle extends Figure{
    private Point pointOne;
    private Point pointTwo;

    public Triangle(Point point, Point pointOne, Point pointTwo) {
        super(point);
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }

    @Override
    public double calcArea() {
        return 0;
    }

    @Override
    public double calcPerimetro() {
        return 0;
    }

    @Override
    public void draw(Graphics graphics) {

    }
}
