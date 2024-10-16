package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CellStateTest {

    @DisplayName("셀 상태를 깃발이 꽃힌 상태로 변경할 수 있다.")
    @Test
    void flag() {
        //given
        CellState cellState = CellState.initialize();

        //when
        cellState.flag();

        //then
        assertThat(cellState.isFlagged()).isTrue();
    }

    @DisplayName("셀 상태를 오픈 상태로 변경할 수 있다.")
    @Test
    void open() {
        //given
        CellState cellState = CellState.initialize();

        //when
        cellState.open();

        //then
        assertThat(cellState.isOpened()).isTrue();
    }

    @DisplayName("셀 상태를 깃발 꽃기 후 다시 오픈 상태로 변경할 수 있다.")
    @Test
    void flagAndOpen() {
        // given
        CellState cellState = CellState.initialize();

        // when
        cellState.flag();
        boolean flagState = cellState.isFlagged();

        cellState.open();
        boolean openState = cellState.isOpened();

        // then
        assertThat(flagState).isTrue();
        assertThat(openState).isTrue();
    }
}
