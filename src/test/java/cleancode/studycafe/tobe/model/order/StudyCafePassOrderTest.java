package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafePassOrderTest {

    private StudyCafePassType hourlyPassType;
    private StudyCafePassType weeklyPassType;
    private StudyCafePassType fixedPassType;

    @BeforeEach
    void setUp() {
        hourlyPassType = StudyCafePassType.HOURLY;
        weeklyPassType = StudyCafePassType.WEEKLY;
        fixedPassType = StudyCafePassType.FIXED;
    }

    @DisplayName("스터디카페 이용권의 가격과 할인율에 따른 주문 금액을 계산한다.")
    @Test
    void getTotalPriceWhenLockerPriceZero() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(hourlyPassType, 4, 4000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(hourlyPassType, 4, 0);

        // when
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(3600);
    }

    @DisplayName("스터디카페 이용권 및 사물함 이용권의 가격과 할인율에 따른 주문 금액을 계산한다.")
    @Test
    void getTotalPriceWhenLockerPriceNotZero() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(fixedPassType, 4, 4000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(fixedPassType, 4, 2000);

        // when
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(5600);
    }

    @DisplayName("스터디카페 이용권의 가격과 할인율에 따른 할인금액을 계산한다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(hourlyPassType, 4, 4000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(hourlyPassType, 4, 0);

        // when
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);
        int discountPrice = passOrder.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(400);
    }
}