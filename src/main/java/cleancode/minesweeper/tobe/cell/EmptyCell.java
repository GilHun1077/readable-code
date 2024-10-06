package cleancode.minesweeper.tobe.cell;

public class EmptyCell implements Cell {

    private final CellState cellState = CellState.initialize();

    @Override
    public boolean isLandMine() {
        return false;
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
            return CellSnapshot.ofEmpty();
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
        return cellState.isChecked();
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }
}
