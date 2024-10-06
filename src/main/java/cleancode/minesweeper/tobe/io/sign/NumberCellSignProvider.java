package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapshot;
import cleancode.minesweeper.tobe.cell.CellSnapshotState;

public class NumberCellSignProvider implements CellSignProvidable{
    @Override
    public boolean support(CellSnapshot snapshot) {
        return snapshot.isSameStatus(CellSnapshotState.NUMBER);
    }

    @Override
    public String provide(CellSnapshot snapshot) {
        return String.valueOf(snapshot.getNearbyLandMineCount());
    }
}
