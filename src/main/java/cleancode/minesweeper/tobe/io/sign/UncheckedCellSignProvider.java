package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;
import cleancode.minesweeper.tobe.cell.CellSnapshotState;

public class UncheckedCellSignProvider implements CellSignProvidable{

    private static final String UNCHECKED_SIGN = "□";

    @Override
    public boolean support(CellSnapshot snapshot) {
        return snapshot.isSameStatus(CellSnapshotState.UNCHECKED);
    }

    @Override
    public String provide(CellSnapshot snapshot) {
        return UNCHECKED_SIGN;
    }
}
