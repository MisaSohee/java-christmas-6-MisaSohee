package christmas;

import java.util.ArrayList;
import java.util.List;

public class EventDetail {
    private List<String> events;
    private String giftMenu;
    private int discount;
    private int giftPrice;

    public EventDetail() {
        events = new ArrayList<>();
        giftMenu = "없음";
        discount = 0;
        giftPrice = 0;
    }

    public void addEvent(String event, int discount, boolean isGift) {
        events.add(event + ": -" + discount + "원");
        if (isGift) {
            this.giftPrice = discount;
            return;
        }
        this.discount += discount;
    }

    public int getTotalBenefit() {
        return discount + giftPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void changeGiftMenu(String giftMenu) {
        this.giftMenu = giftMenu + " 1개";
    }

    public String getBadge() {
        int totalBenefit = getTotalBenefit();
        if (totalBenefit >= 20000) {
            return "산타";
        }
        if (totalBenefit >= 10000) {
            return "트리";
        }
        if (totalBenefit >= 5000) {
            return "별";
        }
        return "없음";
    }

    public List<String> getEvents() {
        return events;
    }

    public String getGiftMenu() {
        return giftMenu;
    }
}
