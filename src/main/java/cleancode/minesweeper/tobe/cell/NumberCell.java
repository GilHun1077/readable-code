package cleancode.minesweeper.tobe.cell;

public class NumberCell extends Cell {

    private final int nearbyLandMineCount;

    public NumberCell(int nearbyLandMineCount) {
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMindCount() {
        return true;
    }

    @Override
    public String getSign() {
        if (isFlagged) {
            return FLAG_SIGN;
        }
        if (isOpened) {
            return String.valueOf(nearbyLandMineCount);
        }
        return UNCHECKED_SIGN;
    }
}
