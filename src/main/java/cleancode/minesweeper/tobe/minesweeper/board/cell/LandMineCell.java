package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class LandMineCell implements Cell {

    private final CellState cellState = CellState.initialize();

    @Override
    public boolean isLandMine() {
        return true;
    }

    @Override
    public boolean hasLandMindCount() {
        return false;
    }

    @Override
    public CellSnapshot getCellSnapshot() {
        if (cellState.isFlagged()) {
            return CellSnapshot.ofFlag();
        }
        if (cellState.isOpened()) {
            return CellSnapshot.ofLandMine();
        }
        return CellSnapshot.ofUnChecked();
    }

    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public boolean isChecked() {
        return cellState.isFlagged();
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }
}
