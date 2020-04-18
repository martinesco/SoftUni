package RandomArrayList;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add("Pesho");
        randomArrayList.add(125);
        randomArrayList.add(new BigDecimal("1.42"));
        randomArrayList.add('h');

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());

    }
}
