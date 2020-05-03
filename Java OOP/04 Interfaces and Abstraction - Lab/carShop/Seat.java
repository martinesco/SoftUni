package carShop;

public class Seat implements Car {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduce;

    public Seat(String model, String color, Integer horsePower, String countryProduce) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduce = countryProduce;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduce;
    }

    @Override
    public String toString() {
        String format = "This is %s produced in %s and have %d tires";
        return String.format(format, this.getModel(), this.countryProduce, TIRES);
    }
}
