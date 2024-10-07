package cleancode.minesweeper.tobe.minesweeper.board.cell;

public interface Cell {

    boolean isLandMine();

    boolean hasLandMindCount();

    CellSnapshot getCellSnapshot();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();

}
