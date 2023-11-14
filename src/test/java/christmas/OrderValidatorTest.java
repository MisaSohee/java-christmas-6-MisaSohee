package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    @Test
    @DisplayName("메뉴 존재 유효성 검사: 잘못된 메뉴 이름을 입력하면 IllegalArgumentException 발생")
    void 잘못된_메뉴_이름_입력시_IllegalArgumentException_발생() {
        String invalidMenuName = "InvalidMenu";

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.validateMenuExist(invalidMenuName);
        });
    }

    @Test
    @DisplayName("주문 수량 유효성 검사: 주문 수량이 1 미만일 경우 IllegalArgumentException 발생")
    void 주문_수량이_1_미만일_경우_IllegalArgumentException_발생() {
        int invalidQuantity = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.validateQuantityRange(invalidQuantity);
        });
    }

    @Test
    @DisplayName("전체 주문 수량 유효성 검사: 전체 주문 수량이 최대치를 초과할 경우 IllegalArgumentException 발생")
    void 전체_주문_수량이_최대치를_초과할_경우_IllegalArgumentException_발생() {
        Map<Menu, Integer> overMaxOrderMap = new HashMap<>();
        overMaxOrderMap.put(Menu.from("티본스테이크"), 21);

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.validateTotalMaxQuantity(overMaxOrderMap);
        });
    }

    @Test
    @DisplayName("수량 유효성 검사: 수량이 숫자가 아닐 경우 IllegalArgumentException 발생")
    void 수량이_숫자가_아닐_경우_IllegalArgumentException_발생() {
        String nonNumberQuantity = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.validateQuantityIsNumber(nonNumberQuantity);
        });
    }

    @Test
    @DisplayName("입력 유효성 검사: 입력에 공백이 포함되어 있을 경우 IllegalArgumentException 발생")
    void 입력에_공백이_포함되어_있을_경우_IllegalArgumentException_발생() {
        String inputWithSpace = "티본 스테이크-1";

        assertThrows(IllegalArgumentException.class, () -> {
            OrderValidator.validateNoSpaceInInput(inputWithSpace);
        });
    }

    @Test
    @DisplayName("주문 형식 유효성 검사: 주문이 '-'를 포함하지 않을 경우 IllegalArgumentException 발생")
    void 주문이_하이픈을_포함하지_않을_경우_IllegalArgumentException_발생() {
        // Given
        String orderWithoutHyphen = "티본스테이크 1,초코케이크 1";

        // Then
        assertThrows(IllegalArgumentException.class, () -> {
            // When
            OrderValidator.validateOrderFormat(orderWithoutHyphen);
        });
    }
}