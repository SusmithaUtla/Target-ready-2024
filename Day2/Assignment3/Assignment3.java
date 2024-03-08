package Assignment3;

public class Assignment3 {
    public static void main(String[] args) {
        Shape[] shapes={
                new Circle(),
                new Circle(3.54),
                new Circle(4.00,"blue",false),
                new Rectangle(),
                new Rectangle(2.0,4.0),
                new Rectangle(4.0,6.0,"pink",true),
                new Square(),
                new Square(6.0),
                new Square(5.0,"black",false),
                new Rectangle(5.0,7.0,"white",false)
        };

        for (int i = 0; i < 10; i++) {
            if (shapes[i] instanceof Circle) {
                Circle circle = (Circle) shapes[i];
                System.out.println("Circle Perimeter: " + circle.getPerimeter());
                System.out.println("Circle Area: " + circle.getArea());
            } else if (shapes[i] instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shapes[i];
                System.out.println("Rectangle Perimeter: " + rectangle.getPerimeter());
                System.out.println("Rectangle Area: " + rectangle.getArea());
            } else if (shapes[i] instanceof Square square) {
                System.out.println("Square Perimeter: " + square.getPerimeter());
                System.out.println("Square Area: " + square.getArea());
            }
        }


    }
}
