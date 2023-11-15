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

        int visitDate = 14;
        orderInfo = new OrderInfo(visitDate, orderMap);
    }

    @DisplayName("D-Day 할인 적용 가능 여부 테스트")
    @Test
    public void 디데이할인적용가능여부_테스트() {
        assertTrue(EventManager.isDdayDiscountApplied(orderInfo.getVisitDate()));
    }

    @DisplayName("평일 할인 적용 가능 여부 테스트")
    @Test
    public void 평일할인적용가능여부_테스트() {
        assertTrue(EventManager.isWeekdayDiscountApplied(orderInfo.getVisitDate()));
    }

    @DisplayName("주말 할인 적용 가능 여부 테스트")
    @Test
    public void 주말할인적용가능여부_테스트() {
        assertFalse(EventManager.isWeekendDiscountApplied(orderInfo.getVisitDate()));
    }

    @DisplayName("특별 할인 적용 가능 여부 테스트")
    @Test
    public void 특별할인적용가능여부_테스트() {
        assertFalse(EventManager.isSpecialDiscountApplied(orderInfo.getVisitDate()));
    }

    @DisplayName("증정 적격 여부 테스트")
    @Test
    public void 증정적격여부_테스트() {
        int totalPriceBeforeDiscount = OrderInfo.calculateTotalOrderPrice(orderInfo.getOrderMap());
        assertTrue(EventManager.isEligibleForGift(totalPriceBeforeDiscount));
    }

    @DisplayName("D-Day 할인액 계산 테스트")
    @Test
    public void 디데이할인액계산_테스트() {
        assertEquals(2300, EventManager.calculateDdayDiscount(orderInfo.getVisitDate()));
    }
}