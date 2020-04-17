import java.util.HashSet;

public class QueensPuzzle {

    private static final int size = 8;
    private static int board [][] = new int[size][size];

    static HashSet<Integer> attackedRows = new HashSet<Integer>();
    static HashSet<Integer> attackedCols = new HashSet<Integer>();



    static void Solve(int row){
        if (row == size){
            PrintSolutions();
            return;
        }
        else {
            for (int col = 0; col < size; col++){
                if (CanPlaceQueen(row, col)){
                    MarkAttackedFields(row, col);
                    Solve(row + 1);
                    UnmarkAttackedFields(row, col);
                }

            }
        }
    }

    private static void PrintSolutions() {
        for (int row = 0; row < size ; row++){
            for (int col = 0; col < size; col++){
                if (board[row][col] == 1 ){
                    System.out.print("* ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();            //Nov red za samoto reshenie
        }
        System.out.println();                //Nov prazen red za sledvashto reshenie

    }

    private static void UnmarkAttackedFields(int row, int col) {

        board[row][col] = 0;
        attackedRows.remove(row);
        attackedCols.remove(col);
    }

    private static void MarkAttackedFields(int row, int col) {

        board[row][col] = 1;
        attackedRows.add(row);
        attackedCols.add(col);

    }

    private static boolean CanPlaceQueen(int row, int col) {
        if (attackedRows.contains(row)){
            return false;
        }
        if (attackedCols.contains(col)){
            return false;
        }

        // NALEVO i NAGORE
        for (int i=1; i< size; i++){           //i=1 ne 0 zashtoto tam e kralicata
            int currentRow = row - i;
            int currentCol = col - i;

            if (currentRow < 0 || currentRow >= size ||
                    currentCol < 0 || currentCol >= size){
                break;
            }

            //queen here
            if (board[currentRow][currentCol] == 1){
                return false;
            }
        }
        // NADESNO i NAGORE
        for (int i=1; i< size; i++){           //i=1 ne 0 zashtoto tam e kralicata
            int currentRow = row - i;
            int currentCol = col + i;

            if (currentRow < 0 || currentRow >= size ||
                    currentCol < 0 || currentCol >= size){
                break;
            }

            //queen here
            if (board[currentRow][currentCol] == 1){
                return false;
            }
        }
        // NALEVO i NADOLE
        for (int i=1; i< size; i++){           //i=1 ne 0 zashtoto tam e kralicata
            int currentRow = row + i;
            int currentCol = col - i;

            if (currentRow < 0 || currentRow >= size ||
                    currentCol < 0 || currentCol >= size){
                break;
            }

            //queen here
            if (board[currentRow][currentCol] == 1){
                return false;
            }
        }
        // NADESNO i NADOLU
        for (int i=1; i< size; i++){           //i=1 ne 0 zashtoto tam e kralicata
            int currentRow = row + i;
            int currentCol = col + i;

            if (currentRow < 0 || currentRow >= size ||
                    currentCol < 0 || currentCol >= size){
                break;
            }

            //queen here
            if (board[currentRow][currentCol] == 1){
                return false;
            }
        }

        return true; //turihme kralicata
    }

    public static void main(String [] args){
        Solve(0);
    }
}
