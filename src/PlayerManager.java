public class PlayerManager {

    private Player currentPlayer;

    public PlayerManager() {
        this.currentPlayer = Player.X;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }
}