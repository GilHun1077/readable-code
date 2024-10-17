package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.exception.GameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardIndexConverterTest {

    @DisplayName("입력한 값에서 행 정보를 숫자 인덱스로 변경하여 반환한다.")
    @Test
    void getSelectedRowIndex() {
        //given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        //when
        int rowIndex = boardIndexConverter.getSelectedRowIndex("a12");

        //then
        assertThat(rowIndex).isEqualTo(11);
    }
    
    @DisplayName("입력된 행이 정보가 0 이하이면 예외가 발생한다.")
    @Test
    void throwExceptionFromInvalidInput() {
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // then
        assertThatThrownBy(() -> boardIndexConverter.getSelectedRowIndex("a0"))
            .isInstanceOf(GameException.class)
            .hasMessage("잘못된 입력입니다.");
    }

    @DisplayName("입력한 값에서 열 정보를 숫자 인덱스로 변경하여 반환한다.")
    @Test
    void getSelectedColIndex() {
        //given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        //when
        int colIndex = boardIndexConverter.getSelectedColIndex("a10");

        //then
        assertThat(colIndex).isEqualTo(0);
    }

    @DisplayName("입력된 열의 정보가 a 보다 작으면 예외가 발생한다.")
    @Test
    void throwExceptionFromInvalidColInput() {
        // given
        BoardIndexConverter boardIndexConverter = new BoardIndexConverter();

        // then
        assertThatThrownBy(() -> boardIndexConverter.getSelectedColIndex("00"))
            .isInstanceOf(GameException.class)
            .hasMessage("잘못된 입력입니다.");
    }
}
