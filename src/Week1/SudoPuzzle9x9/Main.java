package Week1.SudoPuzzle9x9;

public class Main {
    public static void main(String[] args) {
        int[][] initialBoard = {
                {2, 0, 3, 0, 7, 0, 0, 0, 8},
                {0, 0, 0, 0, 9, 2, 0, 0, 0},
                {8, 1, 0, 6, 0, 0, 0, 0, 7},
                {4, 0, 0, 0, 0, 0, 8, 0, 0},
                {7, 0, 1, 5, 0, 8, 9, 0, 4},
                {0, 0, 2, 0, 0, 0, 0, 0, 5},
                {9, 0, 0, 0, 0, 7, 0, 5, 6},
                {0, 0, 0, 2, 6, 0, 0, 0, 0},
                {1, 0, 0, 0, 8, 0, 3, 0, 9}
        };

        SudokuBoard board = new SudokuBoard(initialBoard);
        System.out.println("Initial Board : ");
        board.printBoard();

        if (SudokuSolver.solve(board)) {
            System.out.println("The solution is : ");
            board.printBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }
}

