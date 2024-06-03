package Week1.SudoPuzzle9x9;

public class SudokuBoard {
    private static final int SIZE = 9;
    private int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public int getSize() {
        return SIZE;
    }

    public int getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, int value) {
        board[row][col] = value;
    }

    public boolean isSafe(int row, int col, int num) {
        // Check row
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check column
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.println();

            if ((r + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}

