package christmas;

import java.util.Map;

public class EventPrecosser {
    public static EventDetail processEvent(OrderInfo orderInfo) {
        int orderDate = orderInfo.getVisitDate();
        Map<Menu, Integer> orderMap = orderInfo.getOrderMap();
        int totalPrice = OrderInfo.calculateTotalOrderPrice(orderMap);
        EventDetail eventDetail = new EventDetail();

        if (totalPrice >= 10000) {
            calculateDiscountsAndAddEvents(eventDetail, orderDate, orderMap);
            checkGiftEligibilityAndAddEvent(eventDetail, totalPrice);
        }

        return eventDetail;
    }

    private static void calculateDiscountsAndAddEvents(EventDetail eventDetail, int orderDate, Map<Menu, Integer> orderMap) {
        addDdayDiscountEvent(eventDetail, orderDate);
        addWeekdayDiscountEvent(eventDetail, orderDate, orderMap);
        addWeekendDiscountEvent(eventDetail, orderDate, orderMap);
        addSpecialDiscountEvent(eventDetail, orderDate);
    }

    private static void addDdayDiscountEvent(EventDetail eventDetail, int orderDate) {
        int ddayDiscount = EventManager.calculateDdayDiscount(orderDate);
        if (ddayDiscount > 0) {
            eventDetail.addEvent("크리스마스 디데이 할인", ddayDiscount, false);
        }
    }

    private static void addWeekdayDiscountEvent(EventDetail eventDetail, int orderDate, Map<Menu, Integer> orderMap) {
        int weekdayDiscount = EventManager.calculateWeekdayDiscount(orderMap, orderDate);
        if (weekdayDiscount > 0) {
            eventDetail.addEvent("평일 할인", weekdayDiscount, false);
        }
    }

    private static void addWeekendDiscountEvent(EventDetail eventDetail, int orderDate, Map<Menu, Integer> orderMap) {
        int weekendDiscount = EventManager.calculateWeekendDiscount(orderMap, orderDate);
        if (weekendDiscount > 0) {
            eventDetail.addEvent("주말 할인", weekendDiscount, false);
        }
    }

    private static void addSpecialDiscountEvent(EventDetail eventDetail, int orderDate) {
        int specialDiscount = EventManager.calculateSpecialDiscount(orderDate);
        if (specialDiscount > 0) {
            eventDetail.addEvent("특별 할인", specialDiscount, false);
        }
    }

    private static void checkGiftEligibilityAndAddEvent(EventDetail eventDetail, int totalPrice) {
        if (EventManager.isEligibleForGift(totalPrice)) {
            eventDetail.changeGiftMenu("샴페인");
            eventDetail.addEvent("증정 이벤트", EventManager.getGiftMenuPrice(), true);
        }
    }
}
