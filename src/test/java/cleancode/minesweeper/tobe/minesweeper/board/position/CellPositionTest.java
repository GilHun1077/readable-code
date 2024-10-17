package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CellPositionTest {

    @DisplayName("상대 위치에 따라 현재 셀 포지션의 위치를 계산할 수 있다.")
    @Test
    void calculatePositionByRelativePosition() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 1);
        RelativePosition relativePosition = RelativePosition.of(1, 0);

        // when
        CellPosition movingCellPosition = cellPosition.calculatePositionBy(relativePosition);

        // then
        assertThat(movingCellPosition.getRowIndex()).isEqualTo(1);
        assertThat(movingCellPosition.getColIndex()).isEqualTo(1);
    }

    @DisplayName("상대 위치로 인해 셀 위치가 인덱스를 벗어나면 예외를 발생한다.")
    @Test
    void calculatePositionThrowException() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 1);
        RelativePosition relativePosition = RelativePosition.of(-1, 0);

        // when


        // then
        assertThatThrownBy(() -> cellPosition.calculatePositionBy(relativePosition))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("움직일 수 있는 좌표가 아닙니다.");
    }
    
    @DisplayName("셀 포지션의 rowIndex가 게임보드의 rowSize보다 크거나 같음을 확인할 수 있다.")
    @Test
    void isRowIndexMoreThanOrEqual() {
        // given
        CellPosition cellPosition = CellPosition.of(10, 10);
        
        // when
        boolean rowIndexMoreThanOrEqual = cellPosition.isRowIndexMoreThanOrEqual(9);

        // then
        assertThat(rowIndexMoreThanOrEqual).isTrue();
    }
}
