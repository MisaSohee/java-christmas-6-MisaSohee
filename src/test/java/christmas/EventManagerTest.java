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

    @DisplayName("평일 할인액 계산 테스트")
    @Test
    public void 평일할인액계산_테스트() {
        int visitDate = 14;
        OrderInfo orderInfo = new OrderInfo(visitDate, orderMap);

        assertEquals(4046, EventManager.calculateWeekdayDiscount(orderInfo.getOrderMap(), orderInfo.getVisitDate()));
    }

    @DisplayName("주말 할인액 계산 테스트")
    @Test
    public void 주말할인액계산_테스트() {
        int visitDate = 15;
        OrderInfo orderInfo = new OrderInfo(visitDate, orderMap);

        int expectedDiscount = 2023 * 3;
        assertEquals(expectedDiscount, EventManager.calculateWeekendDiscount(orderInfo.getOrderMap(), orderInfo.getVisitDate()));
    }

    @DisplayName("특별 할인액 계산 테스트")
    @Test
    public void 특별할인액계산_테스트() {
        assertEquals(0, EventManager.calculateSpecialDiscount(orderInfo.getVisitDate()));
    }

    @DisplayName("이벤트 상세 계산 테스트")
    @Test
    public void 이벤트상세계산_테스트() {
        EventDetail eventDetail = EventManager.calculateEventDetails(orderInfo);

        assertEquals(6346, eventDetail.getDiscount());
        assertEquals("샴페인 1개", eventDetail.getGiftMenu());
        assertEquals(31346, eventDetail.getTotalBenefit());
        assertEquals("산타", eventDetail.getBadge());
    }
}