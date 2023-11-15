package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventDetailTest {
    private EventDetail eventDetail;

    @BeforeEach
    public void setup() {
        eventDetail = new EventDetail();
    }

    @Test
    @DisplayName("이벤트 추가 테스트")
    public void addEventTest() {
        eventDetail.addEvent("테스트 이벤트", 1000, false);
        assertTrue(eventDetail.getEvents().contains("테스트 이벤트: -1000원"));
        assertEquals(1000, eventDetail.getDiscount());

        eventDetail.addEvent("증정 이벤트", 5000, true);
        assertTrue(eventDetail.getEvents().contains("증정 이벤트: -5000원"));
        assertEquals(5000, eventDetail.getTotalBenefit() - eventDetail.getDiscount());
    }

    @Test
    @DisplayName("총 혜택 계산 테스트")
    public void getTotalBenefitTest() {
        eventDetail.addEvent("테스트 이벤트", 1000, false);
        assertEquals(1000, eventDetail.getTotalBenefit());

        eventDetail.addEvent("증정 이벤트", 5000, true);
        assertEquals(6000, eventDetail.getTotalBenefit());
    }

    @Test
    @DisplayName("증정품 입력 변경 테스트")
    public void changeGiftMenuTest() {
        eventDetail.changeGiftMenu("샴페인");
        assertEquals("샴페인 1개", eventDetail.getGiftMenu());
    }

    @Test
    @DisplayName("뱃지 반환 테스트")
    public void getBadgeTest() {
        eventDetail.addEvent("테스트 이벤트", 1000, false);
        assertEquals("없음", eventDetail.getBadge());

        eventDetail.addEvent("테스트 이벤트", 4000, false);
        assertEquals("별", eventDetail.getBadge());

        eventDetail.addEvent("테스트 이벤트", 5000, false);
        assertEquals("트리", eventDetail.getBadge());

        eventDetail.addEvent("테스트 이벤트", 10000, false);
        assertEquals("산타", eventDetail.getBadge());
    }
}