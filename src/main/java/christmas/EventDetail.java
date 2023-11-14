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
        this.discount = discount;
    }

    public void setGiftMenu(String giftMenu) {
        this.giftMenu = giftMenu;
    }

    public int calculateTotalBenefit() {
        return discount;
    }

    public void changeGiftMenu(String giftMenu) {
        this.giftMenu = giftMenu + " 1개";
    }

    public String getGiftMenu() {
        return giftMenu;
    }
}
