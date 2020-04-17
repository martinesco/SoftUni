package HotelReservation;

public enum Discount {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int percentDiscount;

    Discount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}
