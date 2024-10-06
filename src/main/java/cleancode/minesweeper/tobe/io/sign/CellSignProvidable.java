package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;

public interface CellSignProvidable {

    boolean support(CellSnapshot snapshot);

    String provide(CellSnapshot snapshot);
}
