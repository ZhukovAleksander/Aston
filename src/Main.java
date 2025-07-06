interface GeometricShape {
    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }

    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.println("Периметр: " + calculatePerimeter() +
                ", Площадь: " + calculateArea() +
                ", Цвет фона: " + getFillColor() +
                ", Цвет границ: " + getBorderColor());
    }
}

public class Main {
    public static void main(String[] args) {
        GeometricShape circle = new Circle(5, "Красный", "Черный");
        GeometricShape rectangle = new Rectangle(4, 6, "Синий", "Белый");
        GeometricShape triangle = new Triangle(3, 4, 5, "Зеленый", "Желтый");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("\nПрямоугольник:");
        rectangle.printInfo();

        System.out.println("\nТреугольник:");
        triangle.printInfo();
    }
}