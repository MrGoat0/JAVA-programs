package model;

import java.awt.*;

public class Rectangle extends Figure{
    private double ancho;
    private double largo;

    public Rectangle(Point point, double ancho, double largo) {
        super(point);
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public double calcArea() {
        return ancho * largo;
    }

    @Override
    public double calcPerimetro() {
        return (ancho * 2) + (largo * 2);
    }

    @Override
    public void draw(Graphics graphics) {

    }
    public double getDiagonal(){
        return Math.sqrt(Math.pow(ancho,2)+Math.pow(largo,2));
    }
    public boolean isSquare(){
        return ancho == largo;
    }
}
