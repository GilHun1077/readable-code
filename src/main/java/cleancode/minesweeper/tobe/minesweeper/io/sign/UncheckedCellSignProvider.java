package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotState;

public class UncheckedCellSignProvider implements CellSignProvidable {

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
