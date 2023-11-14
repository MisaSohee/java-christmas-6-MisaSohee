package christmas;

import java.util.ArrayList;
import java.util.List;

public class EventDetail {
    private List<String> events;
    private String giftMenu;
    private int discount;

    public EventDetail() {
        events = new ArrayList<>();
        giftMenu = "없음";
        discount = 0;
    }

    public void addEvent(String event, int discount) {
        events.add(event + ": -" + discount + "원");
    }

    public void setGiftMenu(String giftMenu) {
        this.giftMenu = giftMenu;
    }
}
