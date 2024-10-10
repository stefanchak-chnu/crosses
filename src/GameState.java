public class GameState {

    private boolean gameOver;
    private Player winner;

    public GameState() {
        this.gameOver = false;
        this.winner = null;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
        this.gameOver = true;
    }

    public void setDraw() {
        this.gameOver = true;
    }

    public boolean isDraw() {
        return gameOver && winner == null;
    }

    public Player getWinner() {
        return winner;
    }
}