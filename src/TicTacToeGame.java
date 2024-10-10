public class TicTacToeGame {
    private final Board board;
    private final PlayerManager playerManager;
    private final InputHandler inputHandler;
    private final GameState gameState;

    public TicTacToeGame() {

        this.board = new Board();
        this.playerManager = new PlayerManager();
        this.inputHandler = new InputHandler();
        this.gameState = new GameState();
    }

    public void play() {
        System.out.println("Tic-Tac-Toe");
        board.print();

        while (!gameState.isGameOver()) {
            Player currentPlayer = playerManager.getCurrentPlayer();
            Move move = inputHandler.getPlayerMove(currentPlayer);

            if (!board.isValidMove(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board.makeMove(move, currentPlayer);

            if (board.isWinningMove(move)) {
                gameState.setWinner(currentPlayer);
            } else if (board.isFull()) {
                gameState.setDraw();
            }

            board.print();
            playerManager.switchPlayer();
        }

        printGameResult();
        inputHandler.close();
    }

    private void printGameResult() {
        if (gameState.isDraw()) {
            System.out.println("Game over! It's a draw!");
        } else {
            System.out.println("Game over! Player " + gameState.getWinner() + " wins!");
        }
    }
}