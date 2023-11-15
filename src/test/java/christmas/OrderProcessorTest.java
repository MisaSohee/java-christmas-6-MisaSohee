package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    @DisplayName("주문 정보 문자열 파싱 테스트")
    @Test
    void parseOrderInputTest() {
        String orderInput = "티본스테이크-1,아이스크림-2,제로콜라-3";

        String[] orders = OrderProcessor.parseOrderInput(orderInput);

        assertArrayEquals(new String[]{"티본스테이크-1", "아이스크림-2", "제로콜라-3"}, orders);
    }

}