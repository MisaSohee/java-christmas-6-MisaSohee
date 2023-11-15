package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

class OrderInfoTest {
    private Map<Menu, Integer> orderMap;

    @BeforeEach
    public void setup() {
        orderMap = new HashMap<>();
    }

    @Test
    @DisplayName("총 주문 가격 계산 테스트")
    public void calculateTotalOrderPriceTest() {
        orderMap.put(Menu.YANGSONGISOUP, 2);
        orderMap.put(Menu.TBONESTEAK, 1);

        int totalOrderPrice = OrderInfo.calculateTotalOrderPrice(orderMap);

        Assertions.assertEquals(67000, totalOrderPrice, "총 주문 가격이 올바르게 계산되어야 합니다.");
    }

}