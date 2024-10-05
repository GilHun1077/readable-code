package cleancode.minesweeper.tobe.cell;

public class EmptyCell extends Cell {

    private static final String EMPTY_SIGN = "■";

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMindCount() {
        return false;
    }

    @Override
    public String getSign() {
        if (isFlagged) {
            return FLAG_SIGN;
        }
        if (isOpened) {
            return EMPTY_SIGN;
        }
        return UNCHECKED_SIGN;
    }
}
