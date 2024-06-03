package Week1.SudoPuzzle9x9;

public class SudokuSolver {
    public static boolean solve(SudokuBoard board) {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.getCell(row, col) == 0) { // Find an empty cell
                    for (int num = 1; num <= size; num++) {
                        if (board.isSafe(row, col, num)) { // Check if placing num is safe
                            board.setCell(row, col, num); // Place the number

                            if (solve(board)) { // Recursively solve
                                return true; // If solved, return true
                            }

                            board.setCell(row, col, 0); // Backtrack
                        }
                    }
                    return false; // Trigger backtracking if no number fits
                }
            }
        }
        return true; // Puzzle solved
    }
}

