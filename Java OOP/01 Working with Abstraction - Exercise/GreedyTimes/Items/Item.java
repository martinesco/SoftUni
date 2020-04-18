package GreedyTimes.Items;

public class Item {
    private long quantity;

    protected Item(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return String.format("<%s> $%d",this.getClass().getSimpleName(), this.getQuantity());
    }

}
