package cleancode.minesweeper.tobe.minesweeper.board.cell;

public class CellSnapshot {

    private final CellSnapshotState status;
    private final int nearbyLandMineCount;

    private CellSnapshot(CellSnapshotState status, int nearbyLandMineCount) {
        this.status = status;
        this.nearbyLandMineCount = nearbyLandMineCount;
    }

    public static CellSnapshot of(CellSnapshotState cellSnapshotState, int nearbyLandMineCount) {
        return new CellSnapshot(cellSnapshotState, nearbyLandMineCount);
    }

    public static CellSnapshot ofEmpty() {
        return new CellSnapshot(CellSnapshotState.EMPTY, 0);
    }

    public static CellSnapshot ofFlag() {
        return new CellSnapshot(CellSnapshotState.FLAG, 0);
    }

    public static CellSnapshot ofLandMine() {
        return new CellSnapshot(CellSnapshotState.LAND_MINE, 0);
    }

    public static CellSnapshot ofNumber(int nearbyLandMineCount) {
        return new CellSnapshot(CellSnapshotState.NUMBER, nearbyLandMineCount);
    }

    public static CellSnapshot ofUnChecked() {
        return new CellSnapshot(CellSnapshotState.UNCHECKED, 0);
    }

    public int getNearbyLandMineCount() {
        return nearbyLandMineCount;
    }

    public boolean isSameStatus(CellSnapshotState cellSnapshotState) {
        return this.status == cellSnapshotState;
    }
}
