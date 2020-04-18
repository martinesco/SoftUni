package CardSuit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CardSuit[] enums = CardSuit.values();
        System.out.println("Card Suits:");

        for (CardSuit value : enums) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    value.ordinal(),
                    value
            ));
        }
    }

}
