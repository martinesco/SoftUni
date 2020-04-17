import java.util.*;

public class PathsInLabyrinth2 {


    private static String[][] labyrinth;
    private static List<String> path = new ArrayList<String>();


    public static void main(String [] args){

        ReadLabyrinth();
        Solve(0,0, "S");


    }
    private static void PrintSolution() {
        for (String print : path){
            System.out.print(print.replaceFirst("S","\0"));                      //ibasi kefa

//            String [] result = {print.toString()};
//            for (int i=0; i<= result.length; i++){
//                System.out.print(result[i]);
//            }
        }
        System.out.println();
    }


    private static void ReadLabyrinth(){
        Scanner scanner = new Scanner(System.in);
        int rows =  Integer.parseInt(scanner.nextLine());
        int cols =  Integer.parseInt(scanner.nextLine());

        labyrinth = new String[rows][cols];

        for (int row=0; row<rows; row++){
            String currentLineString = scanner.nextLine();
            String [] currentLineChar = currentLineString.split("");
            // Character [] currentLineCharArray = ArrayUtils.toObject()

            for (int col = 0; col<cols  ; col++){
                labyrinth[row][col] = currentLineChar[col];
            }
        }
    }
    private static void Solve(int row, int col, String direction){
        if (OutsideOfLabyrinth(row, col)){
            return;
        }

        path.add(direction);

        if (IsExit(row, col)){

            PrintSolution();
        }
        else if (IsPassable(row, col)){

            labyrinth[row][col] = "x";
            Solve(row + 1, col, "D");    //nadole
            Solve(row - 1, col, "U");    //nagore
            Solve(row, col + 1, "R");    //nadesno
            Solve(row, col - 1, "L");    //nalevo

            labyrinth[row][col] = "-";
        }
        path.remove(path.size()-1);
    }

    private static boolean IsPassable(int row, int col) {
        //visited
        if (Objects.equals(labyrinth[row][col], "x")){
            return false;
        }
        //wall
        if (Objects.equals(labyrinth[row][col], "*")){
            return false;
        }
        return true;
    }

    private static boolean IsExit(int row, int col) {
        return Objects.equals(labyrinth[row][col], "e");
    }


    private static boolean OutsideOfLabyrinth(int row, int col) {
        if (row < 0 || row>= labyrinth[0].length){
            return true;
        }
        if (col < 0 || col>= labyrinth[1].length){
            return true;
        }
        return false;
    }
}
