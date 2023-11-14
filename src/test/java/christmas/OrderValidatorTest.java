package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}