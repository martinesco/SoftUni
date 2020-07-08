package shapes;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Rectangle(5.0,5.0);


        shape.calculateArea();
        shape.calculatePerimeter();
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());


        Shape shape2 = new Circle(5.0);



    }
}
