abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract double area();

    void displayColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", 5);
        Shape rectangle = new Rectangle("Blue", 4, 6);

        circle.displayColor();
        System.out.println("Circle Area: " + circle.area());

        rectangle.displayColor();
        System.out.println("Rectangle Area: " + rectangle.area());
    }
}
