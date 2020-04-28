package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money > product.getCost()) {
            products.add(product);
            /*double newMoney = this.money - product.getCost();
            this.setMoney(newMoney);*/

        } else {
            System.out.println(String.format("%s can't afford %s",
                    this.getName(),
                    product.getName()));
        }

        if (products.isEmpty()){
            System.out.println(this.getName() + " - Nothing bought");
        }

    }

    public String getName() {
        return name;
    }



}
