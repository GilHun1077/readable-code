package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshotState;

import java.util.Arrays;

public enum CellSignProvider implements CellSignProvidable {

    EMPTY(CellSnapshotState.EMPTY){
        @Override
        public String provide(CellSnapshot snapshot) {
            return EMPTY_SIGN;
        }
    },
    FLAG(CellSnapshotState.FLAG){
        @Override
        public String provide(CellSnapshot snapshot) {
            return FLAG_SIGN;
        }
    },
    LAND_MINE(CellSnapshotState.LAND_MINE){
        @Override
        public String provide(CellSnapshot snapshot) {
            return LAND_MINE_SIGN;
        }
    },
    NUMBER(CellSnapshotState.NUMBER){
        @Override
        public String provide(CellSnapshot snapshot) {
            return String.valueOf(snapshot.getNearbyLandMineCount());
        }
    },
    UNCHECKED(CellSnapshotState.UNCHECKED){
        @Override
        public String provide(CellSnapshot snapshot) {
            return UNCHECKED_SIGN;
        }
    },
    ;

    private static final String EMPTY_SIGN = "■";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String FLAG_SIGN = "⚑";
    private static final String UNCHECKED_SIGN = "□";

    private final CellSnapshotState status;

    CellSignProvider(CellSnapshotState cellSnapshotState) {
        this.status = cellSnapshotState;
    }

    @Override
    public boolean support(CellSnapshot cellSnapshot) {
        return cellSnapshot.isSameStatus(status);
    }

    public static String findCellSignFrom(CellSnapshot snapshot) {
        CellSignProvider cellSignProvider = findBy(snapshot);
        return cellSignProvider.provide(snapshot);
    }

    private static CellSignProvider findBy(CellSnapshot snapshot) {
        return Arrays.stream(values())
                .filter(provider -> provider.support(snapshot))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 입력입니다."));
    }


}
