package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventManagerTest {
    private Map<Menu, Integer> orderMap;
    private OrderInfo orderInfo;

    @BeforeEach
    public void setup() {
        orderMap = new HashMap<>();
        orderMap.put(Menu.TBONESTEAK, 3);
        orderMap.put(Menu.CHOCOCAKE, 2);

        int visitDate = 15;
        orderInfo = new OrderInfo(visitDate, orderMap);
    }

    @DisplayName("D-Day 할인 적용 가능 여부 테스트")
    @Test
    public void 디데이할인적용가능여부_테스트() {
        assertTrue(EventManager.isDdayDiscountApplied(orderInfo.getVisitDate()));
    }
}