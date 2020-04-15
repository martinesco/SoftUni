package CarSalesman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new LinkedList<>();
        List<Engine> enginesList = new ArrayList<>();

        while (n-->0){//engine info

            //Engine’s displacements and efficiency are optional.
            String []data = scanner.nextLine().split(" ");

            if (data.length==4){
                Engine engine = new Engine(
                        data[0],
                        data[1],
                        data[2],
                        data[3]);
                enginesList.add(engine);
            }
            else {
                if (data.length==3){

                    if(data[2].matches(".*\\d.*")){ //".*\\d.*"

                        enginesList.add(new Engine(
                                data[0],
                                data[1],
                                data[2],
                                "n/a"));

                    }else {
                        enginesList.add(new Engine(
                                data[0],
                                data[1],
                                "n/a",
                                data[2]));
                    }
                }
                else {  //data.length==2
                    enginesList.add(new Engine(data[0],data[1],"n/a","n/a"));
                }
            }
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-->0){ //car info

            String [] data = scanner.nextLine().split(" ");

            /*String model = carData[0];
            String engine = carData[1]; //model of an existing Engine.
            int weight = Integer.parseInt(carData[2]);
            String color = carData[3];*/

            //“<Model> <Engine> , optional <Weight> <Color>”
            switch (data.length){
                case 2:
                    for (Engine engin : enginesList){
                        if (data[1].equals(engin.getModel())){
                            carsList.add(new Car(data[0],engin,"n/a","n/a"));
                            //TODO ako grumne da go pomislq
                        }
                    }
                    break;
                case 3:
                    if (data[2].matches(".*\\d.*")){//demek e weight
                        for (Engine engin : enginesList){
                            if (data[1].equals(engin.getModel())){
                                carsList.add(new Car(
                                        data[0],
                                        engin,
                                        data[2],
                                        "n/a"));
                            }
                        }
                    }
                    else {
                        for (Engine engin: enginesList){
                            if (data[1].equals(engin.getModel())){
                                carsList.add(new Car(
                                        data[0],
                                        engin,
                                        "n/a",
                                        data[2]));
                            }
                        }
                    }
                    break;
                case 4:
                    for (Engine engin : enginesList){
                        if (data[1].equals(engin.getModel())){
                            carsList.add(new Car(
                                    data[0],
                                    engin,
                                   data[2],
                                    data[3]));
                        }
                    }
                    break;
            }

        }

        for (Car car:carsList){
            System.out.println(car.toString());
        }

    }
}
