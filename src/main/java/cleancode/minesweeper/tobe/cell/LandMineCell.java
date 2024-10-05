package cleancode.minesweeper.tobe.cell;

public class LandMineCell extends Cell {

    private static final String LAND_MINE_SIGN = "☼";

    @Override
    public boolean isLandMine() {
        return true;
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
            return LAND_MINE_SIGN;
        }
        return UNCHECKED_SIGN;
    }
}
