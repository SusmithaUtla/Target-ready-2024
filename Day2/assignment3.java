package org.example;

class Shape {
    String color = "red";
    boolean filled = true;

    Shape() {
    }

    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}
class Circle1 extends Shape {
    double radius = 1.0;

    public Circle1() {
    }

    Circle1(double radius) {
        this.radius = radius;
    }

    Circle1(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "Circle[" + super.toString() + ", radius=" + radius + "]";
    }
}

class Rectangle extends Shape {
    double width = 1.0;
    double length = 1.0;

    Rectangle() {
    }

    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public String toString() {
        return "Rectangle[" + super.toString() + ", width=" + width + ", length=" + length + "]";
    }
}

class Square extends Rectangle {
    Square() {
    }

    Square(double side) {
        super(side,side);
    }

    Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();  // Assuming Square uses width as the side
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }


    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }


    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}

public class assignment3 {
    public static void main(String[] args) {
        Shape[] shapes={
             new Circle1(),
             new Circle1(3.54),
             new Circle1(4.00,"blue",false),
             new Rectangle(),
             new Rectangle(2.0,4.0),
             new Rectangle(4.0,6.0,"pink",true),
             new Square(),
             new Square(6.0),
             new Square(5.0,"black",false),
             new Rectangle(5.0,7.0,"white",false)
        };

        for (int i = 0; i < 10; i++) {
            if (shapes[i] instanceof Circle1) {
                Circle1 circle = (Circle1) shapes[i];
                System.out.println("Circle Perimeter: " + circle.getPerimeter());
                System.out.println("Circle Area: " + circle.getArea());
            } else if (shapes[i] instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shapes[i];
                System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
                System.out.println("Rectangle Area: " + rectangle.getArea());
            } else if (shapes[i] instanceof Square) {
                Square square = (Square) shapes[i];
                System.out.println("Square Perimeter: " + square.getPerimeter());
                System.out.println("Square Area: " + square.getArea());
            }
        }


    }
}