package shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * radius * radius);
    }

    public final Double getRadius() {
        return radius;
    }
}
