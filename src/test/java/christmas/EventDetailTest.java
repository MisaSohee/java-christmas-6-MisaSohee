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

}