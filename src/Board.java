import java.util.Arrays;

public class Board {

    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = '_';

    private final char[][] grid;

    public Board() {
        this.grid = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            Arrays.fill(grid[i], EMPTY_CELL);
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.println("-------------");
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public boolean isValidMove(Move move) {
        return move.isWithinBounds(BOARD_SIZE) && grid[move.row()][move.col()] == EMPTY_CELL;
    }

    public void makeMove(Move move, Player player) {
        grid[move.row()][move.col()] = player.getSymbol();
    }

    public boolean isWinningMove(Move lastMove) {
        int row = lastMove.row();
        int col = lastMove.col();
        char symbol = grid[row][col];

        return isRowWin(row, symbol) ||
                isColumnWin(col, symbol) ||
                isDiagonalWin(symbol) ||
                isAntiDiagonalWin(symbol);
    }

    private boolean isRowWin(int row, char symbol) {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (grid[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnWin(int col, char symbol) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (grid[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWin(char symbol) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (grid[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isAntiDiagonalWin(char symbol) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (grid[i][BOARD_SIZE - 1 - i] != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (grid[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}