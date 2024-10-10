public record Move(int row, int col) {

    public boolean isWithinBounds(int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}