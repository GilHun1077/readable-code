package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;
import cleancode.minesweeper.tobe.cell.CellSnapshotState;

public class FlagCellSignProvider implements CellSignProvidable{

    private static final String FLAG_SIGN = "⚑";

    @Override
    public boolean support(CellSnapshot snapshot) {
        return snapshot.isSameStatus(CellSnapshotState.FLAG);
    }

    @Override
    public String provide(CellSnapshot snapshot) {
        return FLAG_SIGN;
    }
}
