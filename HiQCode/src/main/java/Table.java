class Table {
    private final int size = 5;

    public boolean isValidPosition(int x, int y) {
        return isValidX(x) && isValidY(y);
    }

    private boolean isValidX(int x) {
        return x >= 0 && x < size;
    }

    private boolean isValidY(int y) {
        return y >= 0 && y < size;
    }

}
