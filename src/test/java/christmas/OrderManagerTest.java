package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {
    @Test
    @DisplayName("parseOrderInput 메서드 테스트: 주문 문자열을 받아서 주문 내역을 문자열 배열로 반환")
    void parseOrderInput() {
        String orderInput = "양송이수프-2,타파스-3";

        String[] actual = OrderManager.parseOrderInput(orderInput);

        String[] expected = {"양송이수프-2", "타파스-3"};
        assertArrayEquals(expected, actual);
    }
}