package classBox;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {

        return this.length * this.width * this.height;
    }

    private void setLength(double length) {
        validateDimensions(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateDimensions(length, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateDimensions(length, "Height");
        this.height = height;
    }

    private void validateDimensions(double value, String dimension) {
        if (value <= 0) {
            throw new IllegalArgumentException(dimension + " cannot be zero or negative.");
        }
    }

}
