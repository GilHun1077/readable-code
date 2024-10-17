package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotState;

public class NumberCellSignProvider implements CellSignProvidable {
    @Override
    public boolean support(CellSnapshot snapshot) {
        return snapshot.isSameStatus(CellSnapshotState.NUMBER);
    }

    @Override
    public String provide(CellSnapshot snapshot) {
        return String.valueOf(snapshot.getNearbyLandMineCount());
    }
}
