package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EventManager {
    private static final int GIFT_MENU_PRICE = 25000;

    public static int getGiftMenuPrice() {
        return GIFT_MENU_PRICE;
    }

    public static boolean isDdayDiscountApplied(int orderDate) {
        return orderDate <= 25;
    }

    public static boolean isWeekdayDiscountApplied(int orderDate) {
        LocalDate date = LocalDate.of(2023, 12, orderDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    public static boolean isWeekendDiscountApplied(int orderDate) {
        LocalDate date = LocalDate.of(2023, 12, orderDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public static boolean isSpecialDiscountApplied(int orderDate) {
        List<Integer> specialDays = Arrays.asList(3, 10, 17, 24, 25, 31);
        return specialDays.contains(orderDate);
    }

    public static boolean isEligibleForGift(int totalPriceBeforeDiscount) {
        final int GIFT_THRESHOLD = 120000;

        return totalPriceBeforeDiscount >= GIFT_THRESHOLD;
    }

    public static int calculateDdayDiscount(int orderDate) {
        if (isDdayDiscountApplied(orderDate)) {
            return 1000 + (orderDate - 1) * 100;
        }
        return 0;
    }

    public static int calculateWeekdayDiscount(Map<Menu, Integer> orderMap, int orderDate) {
        if (isWeekdayDiscountApplied(orderDate)) {
            return 2023 * getDessertCount(orderMap);
        }
        return 0;
    }

    public static int calculateWeekendDiscount(Map<Menu, Integer> orderMap, int orderDate) {
        if (isWeekendDiscountApplied(orderDate)) {
            return 2023 * getMainCount(orderMap);
        }
        return 0;
    }

    public static int calculateSpecialDiscount(int orderDate) {
        if (isSpecialDiscountApplied(orderDate)) {
            return 1000;
        }
        return 0;
    }

    private static int getDessertCount(Map<Menu, Integer> orderMap) {
        int dessertCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            if (entry.getKey().getCategory() == Category.DESSERT) {
                dessertCount += entry.getValue();
            }
        }
        return dessertCount;
    }

    private static int getMainCount(Map<Menu, Integer> orderMap) {
        int mainCount = 0;
        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            if (entry.getKey().getCategory() == Category.MAIN) {
                mainCount += entry.getValue();
            }
        }
        return mainCount;
    }

    public static EventDetail calculateEventDetails(OrderInfo orderInfo) {
        return EventPrecosser.processEvent(orderInfo);
    }
}
