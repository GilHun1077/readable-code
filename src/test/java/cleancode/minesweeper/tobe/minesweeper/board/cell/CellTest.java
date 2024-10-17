package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell emptyCell;
    private Cell landMineCell;
    private Cell numberCell;

    @BeforeEach
    void cellSetUp() {
        emptyCell = new EmptyCell();
        landMineCell = new LandMineCell();
        numberCell = new NumberCell(3);
    }

    @DisplayName("생성한 지뢰 셀이 지뢰셀이 맞는지 확인한다.")
    @Test
    void landMineCellIsLandMine() {
        // when
        boolean landMine = landMineCell.isLandMine();

        // then
        assertThat(landMine).isTrue();
    }

    @DisplayName("생성한 숫자 셀이 지뢰셀이 아닌지 확인한다.")
    @Test
    void NumberCellIsNotLandMine() {
        // when
        boolean notLandMine = numberCell.isLandMine();

        // then
        assertThat(notLandMine).isFalse();
    }

    @DisplayName("빈 셀이 주변 지뢰 수를 갖고있지 않은지 확인한다.")
    @Test
    void emptyCellHasNotLandMineCount() {
        // when
        boolean hasNotLandMine = emptyCell.hasLandMineCount();

        // then
        assertThat(hasNotLandMine).isFalse();
    }

    @DisplayName("숫자 셀이 주변 지뢰 수를 갖고 있는지 확인한다.")
    @Test
    void numberCellHasLandMineCount() {
        // when
        boolean hasLandMine = numberCell.hasLandMineCount();

        // then
        assertThat(hasLandMine).isTrue();
    }

    @DisplayName("셀 오픈 전 셀의 스냅샷 상태는 UNCHECKED 상태이다.")
    @Test
    void beforeOpenSnapshotOfEmptyCellIsUnchecked() {
        // when
        CellSnapshot emptyCellSnapshot = emptyCell.getCellSnapshot();

        // then
        assertThat(emptyCellSnapshot.isSameStatus(CellSnapshotState.UNCHECKED)).isTrue();
    }

    @DisplayName("지뢰 셀 오픈 후 셀의 스냅샷 상태는 지뢰 상태이다.")
    @Test
    void afterOpenSnapshotOfLandMineCellIsLandMine() {
        // when
        landMineCell.open();
        CellSnapshot emptyCellSnapshot = landMineCell.getCellSnapshot();

        // then
        assertThat(emptyCellSnapshot.isSameStatus(CellSnapshotState.LAND_MINE)).isTrue();
    }

    @DisplayName("숫자 셀 오픈 후 셀의 스냅샷 상태는 NUMBER 상태이고, 주변 지뢰 갯수를 확인할 수 있다.")
    @Test
    void afterOpenSnapshotOfNumberCellIsNumber() {
        // when
        numberCell.open();
        CellSnapshot numberSnapshot = numberCell.getCellSnapshot();
        int nearbyLandMineCount = numberSnapshot.getNearbyLandMineCount();

        // then
        assertThat(numberSnapshot.isSameStatus(CellSnapshotState.NUMBER)).isTrue();
        assertThat(nearbyLandMineCount).isEqualTo(3);
    }


}
