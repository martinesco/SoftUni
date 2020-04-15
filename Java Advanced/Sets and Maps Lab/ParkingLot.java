import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parkingLot = new HashSet<>();


        while (true){
            String input = scanner.nextLine();

            if (!input.equals("END")){

                String [] tokens = input.split(", ");


                if (tokens[0].equals("IN")){
                    parkingLot.add(tokens[1]);
                }
                else {
                    parkingLot.remove(tokens[1]);
                }
            }
            else {
                /*if (parkingLot.isEmpty()){
                    System.out.println("Parking Lot is Empty");
                }
                else {
                    for (String str : parkingLot) {
                        System.out.println(str);
                    }*/


                //vtori variant
                System.out.println(parkingLot.isEmpty() ? "Parking Lot is Empty" :
                        String.join(System.lineSeparator(),parkingLot));
            }
            return;
        }
    }


}
