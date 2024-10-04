package cleancode.minesweeper.tobe;

public class Cell {

    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";

    private int nearbyLandMineCount;
    private boolean isFlagged;
    private boolean isOpened;
    private boolean isLandMine;

    private Cell(int nearbyLandMines, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        this.nearbyLandMineCount = nearbyLandMines;
        this.isLandMine = isLandMine;
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    private static Cell of(int nearbyLandMines, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        return new Cell(nearbyLandMines, isLandMine, isFlagged, isOpened);
    }

    public static Cell create() {
        return of(0, false, false, false);
    }

    public void turnOnLandMine() {
        this.isLandMine = true;
    }

    public void updateNearbyLandMineCount(int count) {
        this.nearbyLandMineCount = count;
    }

    public void flag() {
        this.isFlagged = true;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isLandMine() {
        return isLandMine;
    }

    public boolean isChecked() {
        return isOpened || isFlagged;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public boolean hasLandMindCount() {
        return nearbyLandMineCount != 0;
    }

    public String getSign() {
        if (isFlagged) {
            return FLAG_SIGN;
        }
        if (isOpened) {
            if (isLandMine) {
                return LAND_MINE_SIGN;
            }
            if (hasLandMindCount()) {
                return String.valueOf(nearbyLandMineCount);
            }
            return EMPTY_SIGN;
        }
        return UNCHECKED_SIGN;
    }

}
