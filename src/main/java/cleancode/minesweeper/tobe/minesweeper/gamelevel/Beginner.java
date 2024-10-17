package cleancode.minesweeper.tobe.minesweeper.gamelevel;

public class Beginner implements GameLevel {
    @Override
    public int getRowSize() {
        return 144;
    }

    @Override
    public int getColSize() {
        return 144;
    }

    @Override
    public int getLandMineCount() {
        return 10;
    }
}
