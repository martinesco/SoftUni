import java.util.*;

public class PathsInLabyrinth {


    private static Character[][] labyrinth;
    private static List<Character> path = new ArrayList<>();


    public static void main(String [] args){

        ReadLabyrinth();
        Solve(0,0, 'S');


    }
    private static void PrintSolution() {
        for (Character print : path){
            System.out.print(print.toString().replaceFirst("S","\0"));                      //ibasi kefa

//            String [] result = {print.toString()};
//            for (int i=0; i<= result.length; i++){
//                System.out.print(result[i]);
//            }
        }
        System.out.println();
    }


    private static void ReadLabyrinth(){
        Scanner scanner = new Scanner(System.in);
        long rows = (int) Long.parseLong(scanner.nextLine());
        long cols = (int) Long.parseLong(scanner.nextLine());

        labyrinth = new Character[(int)rows][(int)cols];

        for (int row=0; row<rows; row++){
            String currentLineString = scanner.nextLine();
            char [] currentLineChar = currentLineString.toCharArray();
           // Character [] currentLineCharArray = ArrayUtils.toObject()

            for (int col = 0; col<cols  ; col++){
                labyrinth[row][col] = currentLineChar[col];
            }
        }
    }
    private static void Solve(int row, int col, char direction){
        if (OutsideOfLabyrinth(row, col)){
            return;
        }

        path.add(direction);

        if (IsExit(row, col)){

            PrintSolution();
        }
        else if (IsPassable(row, col)){

            labyrinth[row][col] = 'x';
            Solve(row + 1, col, 'D');    //nadole
            Solve(row - 1, col, 'U');    //nagore
            Solve(row, col + 1, 'R');    //nadesno
            Solve(row, col - 1, 'L');    //nalevo

            labyrinth[row][col] = '-';
        }
        path.remove(path.size()-1);
    }

    private static boolean IsPassable(int row, int col) {
       //visited
        if (labyrinth[row][col]==('x') ){
            return false;
        }
        //wall
        if (labyrinth[row][col]==('*') ){
            return false;
        }
        return true;
    }

    private static boolean IsExit(int row, int col) {
        return labyrinth[row][col] == 'e' ;
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
