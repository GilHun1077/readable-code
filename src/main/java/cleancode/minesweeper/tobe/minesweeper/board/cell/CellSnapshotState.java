package cleancode.minesweeper.tobe.minesweeper.board.cell;

public enum CellSnapshotState {

    EMPTY("빈 셀"),
    FLAG("깃발"),
    LAND_MINE("지뢰"),
    NUMBER("숫자 셀"),
    UNCHECKED("확인 전 셀")
    ;

    private final String description;

    CellSnapshotState(String description) {
        this.description = description;
    }
}
