package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeSeatPassTest {

    @DisplayName("선택한 패스타입과 동일한 타입이면 성공한다.")
    @Test
    void isSamePassType() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(cleancode.studycafe.tobe.model.pass.StudyCafePassType.FIXED, 4, 1000, 0.1);

        //when
        StudyCafePassType passType = StudyCafePassType.FIXED;

        //then
        assertThat(studyCafeSeatPass.isSamePassType(passType)).isTrue();
    }

    @DisplayName("선택한 패스타입과 다른 타입이면 실패한다.")
    @Test
    void isNotSamePassType() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(cleancode.studycafe.tobe.model.pass.StudyCafePassType.FIXED, 4, 1000, 0.1);

        //when
        StudyCafePassType passType = StudyCafePassType.HOURLY;

        // then
        assertThat(studyCafeSeatPass.isSamePassType(passType)).isFalse();
    }

    @DisplayName("카페 이용권과 사물함 이용권의 기간과 패스 타입이 모두 같으면 성공한다.")
    @Test
    void isSameDurationType() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 4000, 0.1);

        //when
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 4000);

        //then
        assertThat(studyCafeSeatPass.isSameDurationType(studyCafeLockerPass)).isTrue();
    }

    @DisplayName("카페 이용권과 사물함 이용권의 기간과 패스 타입이 하나라도 다르면 실패한다.")
    @Test
    void isNotSameDurationType() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 4000, 0.1);

        //when
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 12000);

        //then
        assertThat(studyCafeSeatPass.isSameDurationType(studyCafeLockerPass)).isFalse();
    }

    @DisplayName("카페 이용권의 사물함 사용 권한이 없으면 성공한다.")
    @Test
    void cannotUseLocker() {
        //given
        StudyCafeSeatPass hourlyCafePass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 4000, 0.1);
        StudyCafeSeatPass weeklyCafePass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 4000, 0.1);

        //when

        //then
        assertThat(hourlyCafePass.cannotUseLocker()).isTrue();
        assertThat(weeklyCafePass.cannotUseLocker()).isTrue();
    }

    @DisplayName("카페 이용권의 사물함 사용 권한이 있으면 실패한다.")
    @Test
    void canUseLocker() {
        //given
        StudyCafeSeatPass fixedCafePass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 4000, 0.1);

        //when

        //then
        assertThat(fixedCafePass.cannotUseLocker()).isFalse();
    }
}