package vehicles;

public class Truck extends Vehicle {

    private static final double CONSUMPTION = 1.6;

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION);
    }

    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }
}
