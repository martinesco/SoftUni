package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart();
        cart.add(new OrderItem("asd-20",20));
        Order order = new OnlineOrder(cart,"email@dot.com");

        order.getTotalAmount();


    }
}
