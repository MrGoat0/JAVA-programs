package model;

import java.awt.*;

public abstract class Figure {
    protected Point point;

    public Figure(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    public String sayHello(){
        return "Hola soy una figura";
    }
    public abstract double calcArea();
    public abstract double calcPerimetro();
    public abstract void draw(Graphics graphics);
}

