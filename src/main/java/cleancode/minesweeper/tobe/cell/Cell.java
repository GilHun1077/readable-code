package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    boolean isLandMine();

    boolean hasLandMindCount();

    String getSign();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();

}
