package Run;

import model.Circle;
import model.Figure;
import model.Rectangle;
import model.Triangle;

import java.awt.*;

public class Runner {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(new Point(10, 5), 10, 5);
        System.out.println(calcArea(rectangle));

        Circle circle = new Circle(new Point(34,87), 50);
        System.out.println(calcArea(circle));

        Triangle triangle = new Triangle(new Point(34,50), new Point(12,30), new Point(45,60) );
        System.out.println(calcArea(triangle));

        System.out.println(rectangle.sayHello());
    }
    public static double calcArea(Figure figure){
        return figure.calcArea();
    }
}
